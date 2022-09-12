package controllers

import com.mohiva.play.silhouette.api.actions.SecuredRequest
import models.{Trousers, TrousersRepository}

import javax.inject.{Inject, Singleton}
import play.api.data.Form
import play.api.data.Forms._
import play.api.libs.json.Json
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class TrousersController @Inject()(trousersRepository: TrousersRepository, scc: SilhouetteControllerComponents)(implicit ec: ExecutionContext) extends SilhouetteController(scc) {

  val createTrousersForm: Form[CreateTrousersForm] = Form {
    mapping(
      "name" -> nonEmptyText,
      "productType" -> nonEmptyText,
      "brand" -> nonEmptyText,
      "size" -> nonEmptyText,
      "price" -> bigDecimal,
    )(CreateTrousersForm.apply)(CreateTrousersForm.unapply)
  }

  val updateTrousersForm: Form[UpdateTrousersForm] = Form {
    mapping(
      "id" -> longNumber,
      "name" -> nonEmptyText,
      "productType" -> nonEmptyText,
      "brand" -> nonEmptyText,
      "size" -> nonEmptyText,
      "price" -> bigDecimal,
    )(UpdateTrousersForm.apply)(UpdateTrousersForm.unapply)
  }

  def addTrousers = SecuredAction.async { implicit request: SecuredRequest[EnvType, AnyContent] =>
    createTrousersForm.bindFromRequest().fold(
      errorForm => {
        Future.successful(
          BadRequest
        )
      },
      trousers => {
        trousersRepository.create(trousers.name, trousers.productType, trousers.size, trousers.brand, trousers.price).map { _ =>
          Redirect(routes.TrousersController.getTrousers()).flashing("success" -> "product.created")
        }
      }
    )
  }

  def getTrousers =  SecuredAction.async { implicit request: SecuredRequest[EnvType, AnyContent] =>
    trousersRepository.list().map {
      trousers => Ok(Json.toJson(trousers))
    }
  }

  def updateTrousers(id: Long) = SecuredAction.async { implicit request: SecuredRequest[EnvType, AnyContent] =>
    updateTrousersForm.bindFromRequest().fold(
      errorForm => {
        Future.successful(
          BadRequest
        )
      },
      trousers => {
        trousersRepository.update(trousers.id, Trousers(trousers.id, trousers.name, trousers.productType, trousers.size, trousers.brand, trousers.price)).map { _ =>
          Redirect(routes.TrousersController.getTrousers()).flashing("success" -> "trousers updated")
        }
      }
    )
  }

  def delete(id: Long): Action[AnyContent] = SecuredAction {
    trousersRepository.delete(id)
    Redirect("/trousers")
  }


}

case class CreateTrousersForm(name: String, productType: String, size: String, brand: String, price: BigDecimal)
case class UpdateTrousersForm(id: Long, name: String, productType: String, size: String, brand: String, price: BigDecimal)
