package controllers

import com.mohiva.play.silhouette.api.actions.SecuredRequest
import models.{Ball, BallRepository}

import javax.inject.{Inject, Singleton}
import play.api.data.Form
import play.api.data.Forms._
import play.api.libs.json.Json
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class BallsController @Inject()(ballsRepository: BallRepository, scc: SilhouetteControllerComponents)(implicit ec: ExecutionContext) extends SilhouetteController(scc) {

  val createBallForm: Form[CreateBallForm] = Form {
    mapping(
      "name" -> nonEmptyText,
      "productType" -> nonEmptyText,
      "brand" -> nonEmptyText,
      "price" -> bigDecimal,
    )(CreateBallForm.apply)(CreateBallForm.unapply)
  }

  val updateBallForm: Form[UpdateBallForm] = Form {
    mapping(
      "id" -> longNumber,
      "name" -> nonEmptyText,
      "productType" -> nonEmptyText,
      "brand" -> nonEmptyText,
      "price" -> bigDecimal,
    )(UpdateBallForm.apply)(UpdateBallForm.unapply)
  }

  def addBall = SecuredAction.async { implicit request: SecuredRequest[EnvType, AnyContent] =>
    createBallForm.bindFromRequest().fold(
      errorForm => {
        Future.successful(
          BadRequest
        )
      },
      ball => {
        ballsRepository.create(ball.name, ball.productType, ball.brand, ball.price).map { _ =>
          Redirect(routes.BallsController.getBalls()).flashing("success" -> "product.created")
        }
      }
    )
  }

  def getBalls = SecuredAction.async { implicit request: SecuredRequest[EnvType, AnyContent] =>
    ballsRepository.list().map {
      ball => Ok(Json.toJson(ball))
    }
  }

  def updateBall(id: Long) = SecuredAction.async { implicit request: SecuredRequest[EnvType, AnyContent] =>
    updateBallForm.bindFromRequest().fold(
      errorForm => {
        Future.successful(
          BadRequest
        )
      },
      ball => {
        ballsRepository.update(ball.id, Ball(ball.id, ball.name, ball.productType, ball.brand, ball.price)).map { _ =>
          Redirect(routes.BallsController.getBalls()).flashing("success" -> "ball updated")
        }
      }
    )
  }

  def delete(id: Long): Action[AnyContent] = SecuredAction {
    ballsRepository.delete(id)
    Redirect("/balls")
  }


}

case class CreateBallForm(name: String, productType: String, brand: String, price: BigDecimal)
case class UpdateBallForm(id: Long, name: String, productType: String, brand: String, price: BigDecimal)
