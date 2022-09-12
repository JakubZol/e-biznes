package controllers

import com.mohiva.play.silhouette.api.actions.SecuredRequest
import models.{Shoes, ShoesRepository}

import javax.inject.{Inject, Singleton}
import play.api.data.Form
import play.api.data.Forms._
import play.api.libs.json.Json
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class ShoesController @Inject()(shoesRepository: ShoesRepository, scc: SilhouetteControllerComponents)(implicit ec: ExecutionContext) extends SilhouetteController(scc) {

  val createShoesForm: Form[CreateShoesForm] = Form {
    mapping(
      "name" -> nonEmptyText,
      "productType" -> nonEmptyText,
      "size" -> number,
      "brand" -> nonEmptyText,
      "price" -> bigDecimal,
    )(CreateShoesForm.apply)(CreateShoesForm.unapply)
  }

  val updateShoesForm: Form[UpdateShoesForm] = Form {
    mapping(
      "id" -> longNumber,
      "name" -> nonEmptyText,
      "productType" -> nonEmptyText,
      "size" -> number,
      "brand" -> nonEmptyText,
      "price" -> bigDecimal,
    )(UpdateShoesForm.apply)(UpdateShoesForm.unapply)
  }

  def addShoes = SecuredAction.async { implicit request: SecuredRequest[EnvType, AnyContent] =>
    createShoesForm.bindFromRequest().fold(
      errorForm => {
        Future.successful(
          BadRequest
        )
      },
      shoes => {
        shoesRepository.create(shoes.name, shoes.productType, shoes.size, shoes.brand, shoes.price).map { _ =>
          Redirect(routes.ShoesController.getShoes()).flashing("success" -> "product.created")
        }
      }
    )
  }

  def getShoes = SecuredAction.async { implicit request: SecuredRequest[EnvType, AnyContent] =>
    shoesRepository.list().map {
      shoes => Ok(Json.toJson(shoes))
    }
  }

  def updateShoes(id: Long) = SecuredAction.async { implicit request: SecuredRequest[EnvType, AnyContent] =>
    updateShoesForm.bindFromRequest().fold(
      errorForm => {
        Future.successful(
          BadRequest
        )
      },
      shoes => {
        shoesRepository.update(shoes.id, Shoes(shoes.id, shoes.name, shoes.productType, shoes.size, shoes.brand, shoes.price)).map { _ =>
          Redirect(routes.ShoesController.getShoes()).flashing("success" -> "shoes updated")
        }
      }
    )
  }

  def delete(id: Long): Action[AnyContent] = SecuredAction {
    shoesRepository.delete(id)
    Redirect("/shoes")
  }


}

case class CreateShoesForm(name: String, productType: String, size: Int, brand: String, price: BigDecimal)
case class UpdateShoesForm(id: Long, name: String, productType: String, size: Int, brand: String, price: BigDecimal)
