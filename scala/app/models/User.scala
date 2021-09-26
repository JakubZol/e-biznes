package models

import com.mohiva.play.silhouette.api.util.PasswordInfo
import com.mohiva.play.silhouette.api.{ Identity, LoginInfo }
import com.mohiva.play.silhouette.impl.providers.CredentialsProvider
import com.mohiva.play.silhouette.password.BCryptSha256PasswordHasher

case class User (id: Option[Long], firstname: String, lastname: String, login: String, age:Int, password: Option[String] = None) extends Identity {
  def loginInfo = LoginInfo(CredentialsProvider.ID, login)

  def passwordInfo = PasswordInfo(BCryptSha256PasswordHasher.ID, password.get)
}
