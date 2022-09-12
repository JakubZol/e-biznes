package controllers

import com.mohiva.play.silhouette.api.actions.SecuredRequest
import models.{Gloves, GlovesRepository}

import javax.inject.{Inject, Singleton}
import play.api.data.Form
import play.api.data.Forms._
import play.api.libs.json.Json
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class GlovesController @Inject()(glovesRepository: GlovesRepository, scc: SilhouetteControllerComponents)(implicit ec: ExecutionContext) extends SilhouetteController(scc) {

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

  def addGloves = SecuredAction.async { implicit request: SecuredRequest[EnvType, AnyContent] =>
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

  def getGloves = SecuredAction.async { implicit request: SecuredRequest[EnvType, AnyContent] =>
    glovesRepository.list().map {
      gloves => Ok(Json.toJson(gloves))
    }
  }

  def updateGloves(id: Long) = SecuredAction.async { implicit request: SecuredRequest[EnvType, AnyContent] =>
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

  def delete(id: Long): Action[AnyContent] = SecuredAction {
    glovesRepository.delete(id)
    Redirect("/gloves")
  }


}

case class CreateGlovesForm(name: String, productType: String, size: String, brand: String, price: BigDecimal)
case class UpdateGlovesForm(id: Long, name: String, productType: String, size: String, brand: String, price: BigDecimal)
