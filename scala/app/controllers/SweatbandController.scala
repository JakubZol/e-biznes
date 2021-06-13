package controllers

import models.{Sweatband, SweatbandRepository}

import javax.inject.{Inject, Singleton}
import play.api.data.Form
import play.api.data.Forms._
import play.api.libs.json.Json
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class SweatbandsController @Inject()(sweatbandsRepository: SweatbandRepository, cc: MessagesControllerComponents)(implicit ec: ExecutionContext) extends MessagesAbstractController(cc) {

  val createSweatbandForm: Form[CreateSweatbandForm] = Form {
    mapping(
      "name" -> nonEmptyText,
      "productType" -> nonEmptyText,
      "brand" -> nonEmptyText,
      "price" -> bigDecimal,
    )(CreateSweatbandForm.apply)(CreateSweatbandForm.unapply)
  }

  val updateSweatbandForm: Form[UpdateSweatbandForm] = Form {
    mapping(
      "id" -> longNumber,
      "name" -> nonEmptyText,
      "productType" -> nonEmptyText,
      "brand" -> nonEmptyText,
      "price" -> bigDecimal,
    )(UpdateSweatbandForm.apply)(UpdateSweatbandForm.unapply)
  }

  def addSweatband: Action[AnyContent] = Action.async { implicit request =>
    createSweatbandForm.bindFromRequest().fold(
      errorForm => {
        Future.successful(
          BadRequest
        )
      },
      sweatband => {
        sweatbandsRepository.create(sweatband.name, sweatband.productType, sweatband.brand, sweatband.price).map { _ =>
          Redirect(routes.SweatbandsController.getSweatbands()).flashing("success" -> "product.created")
        }
      }
    )
  }

  def getSweatbands: Action[AnyContent] = Action.async { implicit request =>
    sweatbandsRepository.list().map {
      sweatband => Ok(Json.toJson(sweatband))
    }
  }

  def updateSweatband(id: Long): Action[AnyContent] = Action.async { implicit request: MessagesRequest[AnyContent] =>
    updateSweatbandForm.bindFromRequest().fold(
      errorForm => {
        Future.successful(
          BadRequest
        )
      },
      sweatband => {
        sweatbandsRepository.update(sweatband.id, Sweatband(sweatband.id, sweatband.name, sweatband.productType, sweatband.brand, sweatband.price)).map { _ =>
          Redirect(routes.SweatbandsController.getSweatbands()).flashing("success" -> "sweatband updated")
        }
      }
    )
  }

  def delete(id: Long): Action[AnyContent] = Action {
    sweatbandsRepository.delete(id)
    Redirect("/sweatbands")
  }


}

case class CreateSweatbandForm(name: String, productType: String, brand: String, price: BigDecimal)
case class UpdateSweatbandForm(id: Long, name: String, productType: String, brand: String, price: BigDecimal)
