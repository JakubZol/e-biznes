package models

import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.JdbcProfile

import javax.inject.{Inject, Singleton}
import scala.concurrent.{ExecutionContext, Future}

@Singleton
class TrousersRepository  @Inject() (dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext) {
  private val dbConfig = dbConfigProvider.get[JdbcProfile]

  import dbConfig._
  import profile.api._


  private class TrousersTable(tag: Tag) extends Table[Trousers](tag, "trousers") {
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def name = column[String]("name")
    def productType = column[String]("type")
    def size = column[String]("size")
    def brand = column[String]("brand")
    def price = column[BigDecimal]("price")

    def * = (id, name, productType, size, brand, price) <> ((Trousers.apply _).tupled, Trousers.unapply)
  }

  private val trousers = TableQuery[TrousersTable]
  def create(name: String, productType: String, size: String, brand: String, price: BigDecimal): Future[Trousers] = db.run {
    (trousers.map(a => (a.name, a.productType, a.size, a.brand, a.price))
    returning trousers.map(_.id)
    into {case ((name, productType, size, brand, price), id) => Trousers(id, name, productType, size, brand, price)}
    ) += (name, productType, size, brand, price)
  }

  def list(): Future[Seq[Trousers]] = db.run {
    trousers.result
  }

  def delete(id: Long): Future[Unit] = db.run(trousers.filter(_.id === id).delete).map(_ => ())

  def update(id: Long, new_trousers: Trousers): Future[Unit] = {
    val trousersToUpdate: Trousers = new_trousers.copy(id)
    db.run(trousers.filter(_.id === id).update(trousersToUpdate)).map(_ => ())
  }

}