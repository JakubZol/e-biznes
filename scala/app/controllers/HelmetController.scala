package controllers

import models.{Helmet, HelmetRepository}

import javax.inject.{Inject, Singleton}
import play.api.data.Form
import play.api.data.Forms._
import play.api.libs.json.Json
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class HelmetsController @Inject()(helmetsRepository: HelmetRepository, cc: MessagesControllerComponents)(implicit ec: ExecutionContext) extends MessagesAbstractController(cc) {

  val createHelmetForm: Form[CreateHelmetForm] = Form {
    mapping(
      "name" -> nonEmptyText,
      "productType" -> nonEmptyText,
      "brand" -> nonEmptyText,
      "size" -> nonEmptyText,
      "price" -> bigDecimal,
    )(CreateHelmetForm.apply)(CreateHelmetForm.unapply)
  }

  val updateHelmetForm: Form[UpdateHelmetForm] = Form {
    mapping(
      "id" -> longNumber,
      "name" -> nonEmptyText,
      "productType" -> nonEmptyText,
      "brand" -> nonEmptyText,
      "size" -> nonEmptyText,
      "price" -> bigDecimal,
    )(UpdateHelmetForm.apply)(UpdateHelmetForm.unapply)
  }

  def addHelmet: Action[AnyContent] = Action.async { implicit request =>
    createHelmetForm.bindFromRequest().fold(
      errorForm => {
        Future.successful(
          BadRequest
        )
      },
      helmet => {
        helmetsRepository.create(helmet.name, helmet.productType, helmet.size, helmet.brand, helmet.price).map { _ =>
          Redirect(routes.HelmetsController.getHelmets()).flashing("success" -> "product.created")
        }
      }
    )
  }

  def getHelmets: Action[AnyContent] = Action.async { implicit request =>
    helmetsRepository.list().map {
      helmet => Ok(Json.toJson(helmet))
    }
  }

  def updateHelmet(id: Long): Action[AnyContent] = Action.async { implicit request: MessagesRequest[AnyContent] =>
    updateHelmetForm.bindFromRequest().fold(
      errorForm => {
        Future.successful(
          BadRequest
        )
      },
      helmet => {
        helmetsRepository.update(helmet.id, Helmet(helmet.id, helmet.name, helmet.productType, helmet.size, helmet.brand, helmet.price)).map { _ =>
          Redirect(routes.HelmetsController.getHelmets()).flashing("success" -> "helmet updated")
        }
      }
    )
  }

  def delete(id: Long): Action[AnyContent] = Action {
    helmetsRepository.delete(id)
    Redirect("/helmets")
  }


}

case class CreateHelmetForm(name: String, productType: String, size: String, brand: String, price: BigDecimal)
case class UpdateHelmetForm(id: Long, name: String, productType: String, size: String, brand: String, price: BigDecimal)
