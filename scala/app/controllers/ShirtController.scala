package controllers

import models.{Shirt, ShirtRepository}

import javax.inject.{Inject, Singleton}
import play.api.data.Form
import play.api.data.Forms._
import play.api.libs.json.Json
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class ShirtsController @Inject()(shirtsRepository: ShirtRepository, cc: MessagesControllerComponents)(implicit ec: ExecutionContext) extends MessagesAbstractController(cc) {

  val createShirtForm: Form[CreateShirtForm] = Form {
    mapping(
      "name" -> nonEmptyText,
      "productType" -> nonEmptyText,
      "brand" -> nonEmptyText,
      "size" -> nonEmptyText,
      "price" -> bigDecimal,
    )(CreateShirtForm.apply)(CreateShirtForm.unapply)
  }

  val updateShirtForm: Form[UpdateShirtForm] = Form {
    mapping(
      "id" -> longNumber,
      "name" -> nonEmptyText,
      "productType" -> nonEmptyText,
      "brand" -> nonEmptyText,
      "size" -> nonEmptyText,
      "price" -> bigDecimal,
    )(UpdateShirtForm.apply)(UpdateShirtForm.unapply)
  }

  def addShirt: Action[AnyContent] = Action.async { implicit request =>
    createShirtForm.bindFromRequest().fold(
      errorForm => {
        Future.successful(
          BadRequest
        )
      },
      shirt => {
        shirtsRepository.create(shirt.name, shirt.productType, shirt.size, shirt.brand, shirt.price).map { _ =>
          Redirect(routes.ShirtsController.getShirts()).flashing("success" -> "product.created")
        }
      }
    )
  }

  def getShirts: Action[AnyContent] = Action.async { implicit request =>
    shirtsRepository.list().map {
      shirt => Ok(Json.toJson(shirt))
    }
  }

  def updateShirt(id: Long): Action[AnyContent] = Action.async { implicit request: MessagesRequest[AnyContent] =>
    updateShirtForm.bindFromRequest().fold(
      errorForm => {
        Future.successful(
          BadRequest
        )
      },
      shirt => {
        shirtsRepository.update(shirt.id, Shirt(shirt.id, shirt.name, shirt.productType, shirt.size, shirt.brand, shirt.price)).map { _ =>
          Redirect(routes.ShirtsController.getShirts()).flashing("success" -> "shirt updated")
        }
      }
    )
  }

  def delete(id: Long): Action[AnyContent] = Action {
    shirtsRepository.delete(id)
    Redirect("/shirts")
  }


}

case class CreateShirtForm(name: String, productType: String, size: String, brand: String, price: BigDecimal)
case class UpdateShirtForm(id: Long, name: String, productType: String, size: String, brand: String, price: BigDecimal)
