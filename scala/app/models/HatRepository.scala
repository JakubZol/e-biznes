package models

import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.JdbcProfile

import javax.inject.{Inject, Singleton}
import scala.concurrent.{ExecutionContext, Future}

@Singleton
class HatRepository  @Inject() (dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext) {
  private val dbConfig = dbConfigProvider.get[JdbcProfile]

  import dbConfig._
  import profile.api._


  private class HatTable(tag: Tag) extends Table[Hat](tag, "hat") {
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def name = column[String]("name")
    def productType = column[String]("type")
    def brand = column[String]("brand")
    def price = column[BigDecimal]("price")

    def * = (id, name, productType, brand, price) <> ((Hat.apply _).tupled, Hat.unapply)
  }

  private val hat = TableQuery[HatTable]
  def create(name: String, productType: String, brand: String, price: BigDecimal): Future[Hat] = db.run {
    (hat.map(a => (a.name, a.productType, a.brand, a.price))
    returning hat.map(_.id)
    into {case ((name, productType, brand, price), id) => Hat(id, name, productType, brand, price)}
    ) += ((name, productType, brand, price))
  }

  def list(): Future[Seq[Hat]] = db.run {
    hat.result
  }

  def delete(id: Long): Future[Unit] = db.run(hat.filter(_.id === id).delete).map(_ => ())

  def update(id: Long, newHat: Hat): Future[Unit] = {
    val hatToUpdate: Hat = newHat.copy(id)
    db.run(hat.filter(_.id === id).update(hatToUpdate)).map(_ => ())
  }

}