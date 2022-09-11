package models

import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.JdbcProfile

import javax.inject.{Inject, Singleton}
import scala.concurrent.{ExecutionContext, Future}

@Singleton
class ShirtRepository  @Inject() (dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext) {
  private val dbConfig = dbConfigProvider.get[JdbcProfile]

  import dbConfig._
  import profile.api._


  private class ShirtTable(tag: Tag) extends Table[Shirt](tag, "shirt") {
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def name = column[String]("name")
    def productType = column[String]("type")
    def size = column[String]("size")
    def brand = column[String]("brand")
    def price = column[BigDecimal]("price")

    def * = (id, name, productType, size, brand, price) <> ((Shirt.apply _).tupled, Shirt.unapply)
  }

  private val shirt = TableQuery[ShirtTable]
  def create(name: String, productType: String, size: String, brand: String, price: BigDecimal): Future[Shirt] = db.run {
    (shirt.map(a => (a.name, a.productType, a.size, a.brand, a.price))
      returning shirt.map(_.id)
      into {case ((name, productType, size, brand, price), id) => Shirt(id, name, productType, size, brand, price)}
      ) += ((name, productType, size, brand, price))
  }

  def list(): Future[Seq[Shirt]] = db.run {
    shirt.result
  }

  def delete(id: Long): Future[Unit] = db.run(shirt.filter(_.id === id).delete).map(_ => ())

  def update(id: Long, newShirt: Shirt): Future[Unit] = {
    val shirtToUpdate: Shirt = newShirt.copy(id)
    db.run(shirt.filter(_.id === id).update(shirtToUpdate)).map(_ => ())
  }

}