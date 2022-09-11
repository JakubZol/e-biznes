package models

import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.JdbcProfile

import javax.inject.{Inject, Singleton}
import scala.concurrent.{ExecutionContext, Future}

@Singleton
class BallRepository  @Inject() (dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext) {
  private val dbConfig = dbConfigProvider.get[JdbcProfile]

  import dbConfig._
  import profile.api._


  private class BallTable(tag: Tag) extends Table[Ball](tag, "ball") {
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def name = column[String]("name")
    def productType = column[String]("type")
    def brand = column[String]("brand")
    def price = column[BigDecimal]("price")

    def * = (id, name, productType, brand, price) <> ((Ball.apply _).tupled, Ball.unapply)
  }

  private val ball = TableQuery[BallTable]
  def create(name: String, productType: String, brand: String, price: BigDecimal): Future[Ball] = db.run {
    (ball.map(a => (a.name, a.productType, a.brand, a.price))
    returning ball.map(_.id)
    into {case ((name, productType, brand, price), id) => Ball(id, name, productType, brand, price)}
    ) += ((name, productType, brand, price))
  }

  def list(): Future[Seq[Ball]] = db.run {
    ball.result
  }

  def delete(id: Long): Future[Unit] = db.run(ball.filter(_.id === id).delete).map(_ => ())

  def update(id: Long, newBall: Ball): Future[Unit] = {
    val ballToUpdate: Ball = newBall.copy(id)
    db.run(ball.filter(_.id === id).update(ballToUpdate)).map(_ => ())
  }

}