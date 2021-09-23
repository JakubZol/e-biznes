package models

import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.JdbcProfile

import javax.inject.{Inject, Singleton}
import scala.concurrent.{ExecutionContext, Future}

@Singleton
class GlovesRepository  @Inject() (dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext) {
  private val dbConfig = dbConfigProvider.get[JdbcProfile]

  import dbConfig._
  import profile.api._


  private class GlovesTable(tag: Tag) extends Table[Gloves](tag, "gloves") {
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def name = column[String]("name")
    def productType = column[String]("type")
    def size = column[String]("size")
    def brand = column[String]("brand")
    def price = column[BigDecimal]("price")

    def * = (id, name, productType, size, brand, price) <> ((Gloves.apply _).tupled, Gloves.unapply)
  }

  private val gloves = TableQuery[GlovesTable]
  def create(name: String, productType: String, size: String, brand: String, price: BigDecimal): Future[Gloves] = db.run {
    (gloves.map(a => (a.name, a.productType, a.size, a.brand, a.price))
    returning gloves.map(_.id)
    into {case ((name, productType, size, brand, price), id) => Gloves(id, name, productType, size, brand, price)}
    ) += (name, productType, size, brand, price)
  }

  def list(): Future[Seq[Gloves]] = db.run {
    gloves.result
  }

  def delete(id: Long): Future[Unit] = db.run(gloves.filter(_.id === id).delete).map(_ => ())

  def update(id: Long, newGloves: Gloves): Future[Unit] = {
    val glovesToUpdate: Gloves = newGloves.copy(id)
    db.run(gloves.filter(_.id === id).update(glovesToUpdate)).map(_ => ())
  }

}