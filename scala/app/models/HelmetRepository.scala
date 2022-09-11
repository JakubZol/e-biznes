package models

import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.JdbcProfile

import javax.inject.{Inject, Singleton}
import scala.concurrent.{ExecutionContext, Future}

@Singleton
class HelmetRepository  @Inject() (dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext) {
  private val dbConfig = dbConfigProvider.get[JdbcProfile]

  import dbConfig._
  import profile.api._


  private class HelmetTable(tag: Tag) extends Table[Helmet](tag, "helmet") {
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def name = column[String]("name")
    def productType = column[String]("type")
    def size = column[String]("size")
    def brand = column[String]("brand")
    def price = column[BigDecimal]("price")

    def * = (id, name, productType, size, brand, price) <> ((Helmet.apply _).tupled, Helmet.unapply)
  }

  private val helmet = TableQuery[HelmetTable]
  def create(name: String, productType: String, size: String, brand: String, price: BigDecimal): Future[Helmet] = db.run {
    (helmet.map(a => (a.name, a.productType, a.size, a.brand, a.price))
    returning helmet.map(_.id)
    into {case ((name, productType, size, brand, price), id) => Helmet(id, name, productType, size, brand, price)}
    ) += ((name, productType, size, brand, price))
  }

  def list(): Future[Seq[Helmet]] = db.run {
    helmet.result
  }

  def delete(id: Long): Future[Unit] = db.run(helmet.filter(_.id === id).delete).map(_ => ())

  def update(id: Long, newHelmet: Helmet): Future[Unit] = {
    val helmetToUpdate: Helmet = newHelmet.copy(id)
    db.run(helmet.filter(_.id === id).update(helmetToUpdate)).map(_ => ())
  }

}