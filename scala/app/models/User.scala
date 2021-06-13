package models

import play.api.libs.json.Json

case class User (id: Long, firstname: String, lastname: String, login: String, age:Int)

object User {
  implicit val userFormat = Json.format[User]
}