package controllers


import models.{Hat, HatRepository}

import javax.inject.{Inject, Singleton}
import play.api.data.Form
import play.api.data.Forms._
import play.api.libs.json.Json
import play.api.mvc._
import com.mohiva.play.silhouette.api.actions.SecuredRequest

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class HatsController @Inject()(hatsRepository: HatRepository, scc: SilhouetteControllerComponents)(implicit ec: ExecutionContext) extends SilhouetteController(scc) {

  val createHatForm: Form[CreateHatForm] = Form {
    mapping(
      "name" -> nonEmptyText,
      "productType" -> nonEmptyText,
      "brand" -> nonEmptyText,
      "price" -> bigDecimal,
    )(CreateHatForm.apply)(CreateHatForm.unapply)
  }

  val updateHatForm: Form[UpdateHatForm] = Form {
    mapping(
      "id" -> longNumber,
      "name" -> nonEmptyText,
      "productType" -> nonEmptyText,
      "brand" -> nonEmptyText,
      "price" -> bigDecimal,
    )(UpdateHatForm.apply)(UpdateHatForm.unapply)
  }

  def addHat = SecuredAction.async { implicit request: SecuredRequest[EnvType, AnyContent] =>
    createHatForm.bindFromRequest().fold(
      errorForm => {
        Future.successful(
          BadRequest
        )
      },
      hat => {
        hatsRepository.create(hat.name, hat.productType, hat.brand, hat.price).map { _ =>
          Redirect(routes.HatsController.getHats()).flashing("success" -> "product.created")
        }
      }
    )
  }

  def getHats = SecuredAction.async { implicit request: SecuredRequest[EnvType, AnyContent] =>
    hatsRepository.list().map {
      hat => Ok(Json.toJson(hat))
    }
  }

  def updateHat(id: Long) = SecuredAction.async { implicit request: SecuredRequest[EnvType, AnyContent] =>
    updateHatForm.bindFromRequest().fold(
      errorForm => {
        Future.successful(
          BadRequest
        )
      },
      hat => {
        hatsRepository.update(hat.id, Hat(hat.id, hat.name, hat.productType, hat.brand, hat.price)).map { _ =>
          Redirect(routes.HatsController.getHats()).flashing("success" -> "hat updated")
        }
      }
    )
  }

  def delete(id: Long): Action[AnyContent] = SecuredAction {
    hatsRepository.delete(id)
    Redirect("/hats")
  }


}

case class CreateHatForm(name: String, productType: String, brand: String, price: BigDecimal)
case class UpdateHatForm(id: Long, name: String, productType: String, brand: String, price: BigDecimal)
