package tables

import models.User
import slick.jdbc.SQLiteProfile.api._


class UserTable(tag: Tag) extends Table[User](tag, Some("main"), "users") {

  def id = column[Option[Long]]("id", O.PrimaryKey, O.AutoInc, O.Unique)

  def firstname = column[String]("firstname")

  def lastname = column[String]("lastname")

  def password = column[Option[String]]("password")

  def login = column[String]("login", O.Unique)

  def age = column[Int]("age")

  def * = (id, firstname, lastname, login, age, password) <> ((User.apply _).tupled, User.unapply)
}