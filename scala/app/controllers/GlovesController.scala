package controllers

import models.{Gloves, GlovesRepository}

import javax.inject.{Inject, Singleton}
import play.api.data.Form
import play.api.data.Forms._
import play.api.libs.json.Json
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class GlovesController @Inject()(glovesRepository: GlovesRepository, cc: MessagesControllerComponents)(implicit ec: ExecutionContext) extends MessagesAbstractController(cc) {

  val createGlovesForm: Form[CreateGlovesForm] = Form {
    mapping(
      "name" -> nonEmptyText,
      "productType" -> nonEmptyText,
      "brand" -> nonEmptyText,
      "size" -> nonEmptyText,
      "price" -> bigDecimal,
    )(CreateGlovesForm.apply)(CreateGlovesForm.unapply)
  }

  val updateGlovesForm: Form[UpdateGlovesForm] = Form {
    mapping(
      "id" -> longNumber,
      "name" -> nonEmptyText,
      "productType" -> nonEmptyText,
      "brand" -> nonEmptyText,
      "size" -> nonEmptyText,
      "price" -> bigDecimal,
    )(UpdateGlovesForm.apply)(UpdateGlovesForm.unapply)
  }

  def addGloves: Action[AnyContent] = Action.async { implicit request =>
    createGlovesForm.bindFromRequest().fold(
      errorForm => {
        Future.successful(
          BadRequest
        )
      },
      gloves => {
        glovesRepository.create(gloves.name, gloves.productType, gloves.size, gloves.brand, gloves.price).map { _ =>
          Redirect(routes.GlovesController.getGloves()).flashing("success" -> "product.created")
        }
      }
    )
  }

  def getGloves: Action[AnyContent] = Action.async { implicit request =>
    glovesRepository.list().map {
      gloves => Ok(Json.toJson(gloves))
    }
  }

  def updateGloves(id: Long): Action[AnyContent] = Action.async { implicit request: MessagesRequest[AnyContent] =>
    updateGlovesForm.bindFromRequest().fold(
      errorForm => {
        Future.successful(
          BadRequest
        )
      },
      gloves => {
        glovesRepository.update(gloves.id, Gloves(gloves.id, gloves.name, gloves.productType, gloves.size, gloves.brand, gloves.price)).map { _ =>
          Redirect(routes.GlovesController.getGloves()).flashing("success" -> "gloves updated")
        }
      }
    )
  }

  def delete(id: Long): Action[AnyContent] = Action {
    glovesRepository.delete(id)
    Redirect("/gloves")
  }


}

case class CreateGlovesForm(name: String, productType: String, size: String, brand: String, price: BigDecimal)
case class UpdateGlovesForm(id: Long, name: String, productType: String, size: String, brand: String, price: BigDecimal)
