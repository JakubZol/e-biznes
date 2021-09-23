package models

import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.JdbcProfile

import javax.inject.{Inject, Singleton}
import scala.concurrent.{ExecutionContext, Future}

@Singleton
class UserRepository @Inject() (dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext) {
  private val dbConfig = dbConfigProvider.get[JdbcProfile]

  import dbConfig._
  import profile.api._


  private class UserTable(tag: Tag) extends Table[User](tag, "user") {
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def firstname = column[String]("firstname")
    def lastname = column[String]("lastname")
    def login = column[String]("login")
    def age = column[Int]("age")

    def * = (id, firstname, lastname, login, age) <> ((User.apply _).tupled, User.unapply)
  }

  private val user = TableQuery[UserTable]
  def create(firstname: String, lastname: String, login: String, age: Int): Future[User] = db.run {
    (user.map(u => (u.firstname, u.lastname, u.login, u.age))
      returning user.map(_.id)
      into {case ((firstname, lastname, login, age), id) => User(id, firstname, lastname, login, age)}
      ) += (firstname, lastname, login, age)
  }

  def list(): Future[Seq[User]] = db.run {
    user.result
  }

  def delete(id: Long): Future[Unit] = db.run(user.filter(_.id === id).delete).map(_ => ())

  def update(id: Long, newUser: User): Future[Unit] = {
    val userToUpdate: User = newUser.copy(id)
    db.run(user.filter(_.id === id).update(userToUpdate)).map(_ => ())
  }

}
