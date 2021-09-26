package models

import com.mohiva.play.silhouette.api.LoginInfo
import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.JdbcProfile
import tables.UserTable

import javax.inject.{Inject, Singleton}
import scala.concurrent.{ExecutionContext, Future}

@Singleton
class UserRepository @Inject() (dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext) {
  private val dbConfig = dbConfigProvider.get[JdbcProfile]

  import dbConfig._
  import profile.api._

  private val users = TableQuery[UserTable]

  def save(user: User): Future[User] = db.run(users.insertOrUpdate(user)).map(_ => user)

  def find(loginInfo: LoginInfo): Future[Option[User]] = db.run {
    users.filter(_.login === loginInfo.providerKey).result.headOption
  }

  def delete(user: User): Future[User] = db.run(users.filter(_.id === user.id).delete).map(_ => user)

  def update(user: User): Future[User] = db.run {
    users.filter(_.login === user.login).update(user).map(_ => user)
  }
}
