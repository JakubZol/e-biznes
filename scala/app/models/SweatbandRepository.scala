package models

import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.JdbcProfile

import javax.inject.{Inject, Singleton}
import scala.concurrent.{ExecutionContext, Future}

@Singleton
class SweatbandRepository  @Inject() (dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext) {
  private val dbConfig = dbConfigProvider.get[JdbcProfile]

  import dbConfig._
  import profile.api._


  private class SweatbandTable(tag: Tag) extends Table[Sweatband](tag, "sweatband") {
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def name = column[String]("name")
    def productType = column[String]("type")
    def brand = column[String]("brand")
    def price = column[BigDecimal]("price")

    def * = (id, name, productType, brand, price) <> ((Sweatband.apply _).tupled, Sweatband.unapply)
  }

  private val sweatband = TableQuery[SweatbandTable]
  def create(name: String, productType: String, brand: String, price: BigDecimal): Future[Sweatband] = db.run {
    (sweatband.map(a => (a.name, a.productType, a.brand, a.price))
    returning sweatband.map(_.id)
    into {case ((name, productType, brand, price), id) => Sweatband(id, name, productType, brand, price)}
    ) += ((name, productType, brand, price))
  }

  def list(): Future[Seq[Sweatband]] = db.run {
    sweatband.result
  }

  def delete(id: Long): Future[Unit] = db.run(sweatband.filter(_.id === id).delete).map(_ => ())

  def update(id: Long, newSweatband: Sweatband): Future[Unit] = {
    val sweatbandToUpdate: Sweatband = newSweatband.copy(id)
    db.run(sweatband.filter(_.id === id).update(sweatbandToUpdate)).map(_ => ())
  }

}