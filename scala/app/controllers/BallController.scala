package controllers

import models.{Ball, BallRepository}

import javax.inject.{Inject, Singleton}
import play.api.data.Form
import play.api.data.Forms._
import play.api.libs.json.Json
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class BallsController @Inject()(ballsRepository: BallRepository, cc: MessagesControllerComponents)(implicit ec: ExecutionContext) extends MessagesAbstractController(cc) {

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

  def addBall: Action[AnyContent] = Action.async { implicit request =>
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

  def getBalls: Action[AnyContent] = Action.async { implicit request =>
    ballsRepository.list().map {
      ball => Ok(Json.toJson(ball))
    }
  }

  def updateBall(id: Long): Action[AnyContent] = Action.async { implicit request: MessagesRequest[AnyContent] =>
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

  def delete(id: Long): Action[AnyContent] = Action {
    ballsRepository.delete(id)
    Redirect("/balls")
  }


}

case class CreateBallForm(name: String, productType: String, brand: String, price: BigDecimal)
case class UpdateBallForm(id: Long, name: String, productType: String, brand: String, price: BigDecimal)
