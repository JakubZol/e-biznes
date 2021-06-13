package controllers

import models.{User, UserRepository}

import javax.inject.{Inject, Singleton}
import play.api.data.Form
import play.api.data.Forms._
import play.api.libs.json.Json
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class UsersController @Inject()(usersRepo: UserRepository, cc: MessagesControllerComponents)(implicit ec: ExecutionContext) extends MessagesAbstractController(cc) {

  val userForm: Form[CreateUserForm] = Form {
    mapping(
      "firstname" -> nonEmptyText,
      "lastname" -> nonEmptyText,
      "login" -> nonEmptyText,
      "age" -> number,
    )(CreateUserForm.apply)(CreateUserForm.unapply)
  }

  val updateUserForm: Form[UpdateUserForm] = Form {
    mapping(
      "id" -> longNumber,
      "firstname" -> nonEmptyText,
      "lastname" -> nonEmptyText,
      "login" -> nonEmptyText,
      "age" -> number,
    )(UpdateUserForm.apply)(UpdateUserForm.unapply)
  }

  def addUser: Action[AnyContent] = Action.async { implicit request =>
    userForm.bindFromRequest().fold(
      errorForm => {
        Future.successful(
          BadRequest
        )
      },
      user => {
        usersRepo.create(user.firstname, user.lastname, user.login, user.age).map { _ =>
          Redirect(routes.UsersController.getUsers()).flashing("success" -> "product.created")
        }
      }
    )
  }

  def getUsers: Action[AnyContent] = Action.async { implicit request =>
    usersRepo.list().map {
      user => Ok(Json.toJson(user))
    }
  }

  def updateUser(id: Long): Action[AnyContent] = Action.async { implicit request: MessagesRequest[AnyContent] =>
    updateUserForm.bindFromRequest().fold(
      errorForm => {
        Future.successful(
          BadRequest
        )
      },
      user => {
        usersRepo.update(user.id, User(user.id, user.firstname, user.lastname, user.login, user.age)).map { _ =>
          Redirect(routes.UsersController.getUsers()).flashing("success" -> "user updated")
        }
      }
    )
  }

  def delete(id: Long): Action[AnyContent] = Action {
    usersRepo.delete(id)
    Redirect("/users")
  }


}

case class CreateUserForm(firstname: String, lastname: String, login: String, age: Int)
case class UpdateUserForm(id: Long, firstname: String, lastname: String, login: String, age: Int)
