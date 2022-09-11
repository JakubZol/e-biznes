package controllers

import models.User
import com.mohiva.play.silhouette.api.actions.SecuredRequest
import com.mohiva.play.silhouette.impl.providers.CredentialsProvider
import play.api.i18n.Lang
import play.api.libs.json.{JsString, Json}
import play.api.mvc.AnyContent
import utils.{JWTEnvironment, WithProvider}

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class UserController @Inject() (scc: SilhouetteControllerComponents)(implicit ex: ExecutionContext) extends SilhouetteController(scc) {

  implicit val UserFormat = Json.format[User]

  def getUser = securedAction(WithProvider[AuthType](CredentialsProvider.ID)).async {
    request: SecuredRequest[JWTEnvironment, AnyContent] =>
      implicit val lang: Lang = supportedLangs.availables.head
      val user = request.identity
      Future.successful(Ok(Json.toJson(user.copy(password = None))))
  }
}

