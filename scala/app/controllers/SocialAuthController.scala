package controllers

import com.mohiva.play.silhouette.api._
import com.mohiva.play.silhouette.api.exceptions.ProviderException
import com.mohiva.play.silhouette.impl.providers._
import play.api.mvc.{AnyContent, Cookie, Request}
import utils.route.Calls
import java.net.URLEncoder
import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

/**
 * The social auth controller.
 *
 * @param components             The Play controller components.
 * @param silhouette             The Silhouette stack.
 * @param userService            The user service implementation.
 * @param authInfoRepository     The auth info service implementation.
 * @param socialProviderRegistry The social provider registry.
 * @param ex                     The execution context.
 */
class SocialAuthController @Inject() (
  scc: SilhouetteControllerComponents
)(
  implicit
  ex: ExecutionContext
) extends SilhouetteController(scc) {

  /**
   * Authenticates a user against a social provider.
   *
   * @param provider The ID of the provider to authenticate against.
   * @return The result to display.
   */
  def authenticate() = Action.async { implicit request: Request[AnyContent] =>
    (socialProviderRegistry.get[SocialProvider]("facebook") match {
      case Some(p: SocialProvider with CommonSocialProfileBuilder) =>
        p.authenticate().flatMap {
          case Left(result) => Future.successful(result)
          case Right(authInfo) => for {
            profile <- p.retrieveProfile(authInfo)
            user <- userService.save(profile)
            authenticator <- authenticatorService.create(profile.loginInfo)
            value <- authenticatorService.init(authenticator)
            result <- authenticatorService.embed(value, Redirect(Calls.home)
              .withCookies(
                new Cookie(name = "email", value = user.email.get, httpOnly = false),
                new Cookie(name = "fullName", value = URLEncoder.encode(user.fullName.get, "UTF-8"), httpOnly = false)
              )
            )
          } yield {
            eventBus.publish(LoginEvent(user, request))
            result
          }
        }
      case _ => Future.failed(new ProviderException(s"Cannot authenticate with unexpected social provider facebook"))
    }).recover {
      case e: ProviderException =>
        logger.error("Unexpected provider error", e)
        Redirect(Calls.authenticationFailed)
    }
  }
}
