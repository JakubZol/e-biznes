package models

import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.JdbcProfile

import javax.inject.{Inject, Singleton}
import scala.concurrent.{ExecutionContext, Future}

@Singleton
class ShoesRepository  @Inject() (dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext) {
  private val dbConfig = dbConfigProvider.get[JdbcProfile]

  import dbConfig._
  import profile.api._


  private class ShoesTable(tag: Tag) extends Table[Shoes](tag, "shoes") {
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def name = column[String]("name")
    def productType = column[String]("type")
    def size = column[Int]("size")
    def brand = column[String]("brand")
    def price = column[BigDecimal]("price")

    def * = (id, name, productType, size, brand, price) <> ((Shoes.apply _).tupled, Shoes.unapply)
  }

  private val shoes = TableQuery[ShoesTable]
  def create(name: String, productType: String, size: Int, brand: String, price: BigDecimal): Future[Shoes] = db.run {
    (shoes.map(a => (a.name, a.productType, a.size, a.brand, a.price))
    returning shoes.map(_.id)
    into {case ((name, productType, size, brand, price), id) => Shoes(id, name, productType, size, brand, price)}
    ) += (name, productType, size, brand, price)
  }

  def list(): Future[Seq[Shoes]] = db.run {
    shoes.result
  }

  def delete(id: Long): Future[Unit] = db.run(shoes.filter(_.id === id).delete).map(_ => ())

  def update(id: Long, newShoes: Shoes): Future[Unit] = {
    val shoesToUpdate: Shoes = newShoes.copy(id)
    db.run(shoes.filter(_.id === id).update(shoesToUpdate)).map(_ => ())
  }

}