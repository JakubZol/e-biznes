package controllers

import com.mohiva.play.silhouette.api.actions.SecuredRequest
import models.{Helmet, HelmetRepository}

import javax.inject.{Inject, Singleton}
import play.api.data.Form
import play.api.data.Forms._
import play.api.libs.json.Json
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class HelmetsController @Inject()(helmetsRepository: HelmetRepository, scc: SilhouetteControllerComponents)(implicit ec: ExecutionContext) extends SilhouetteController(scc) {

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

  def addHelmet = SecuredAction.async { implicit request: SecuredRequest[EnvType, AnyContent] =>
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

  def getHelmets = SecuredAction.async { implicit request: SecuredRequest[EnvType, AnyContent] =>
    helmetsRepository.list().map {
      helmet => Ok(Json.toJson(helmet))
    }
  }

  def updateHelmet(id: Long) = SecuredAction.async { implicit request: SecuredRequest[EnvType, AnyContent] =>
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

  def delete(id: Long): Action[AnyContent] = SecuredAction {
    helmetsRepository.delete(id)
    Redirect("/helmets")
  }


}

case class CreateHelmetForm(name: String, productType: String, size: String, brand: String, price: BigDecimal)
case class UpdateHelmetForm(id: Long, name: String, productType: String, size: String, brand: String, price: BigDecimal)
