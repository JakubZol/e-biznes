package services

import com.mohiva.play.silhouette.api.LoginInfo
import com.mohiva.play.silhouette.api.services.IdentityService
import models.User

import javax.inject.Inject
import models.UserRepository

import scala.concurrent.{ExecutionContext, Future}


class UserService @Inject() (userRepository: UserRepository)(implicit ex: ExecutionContext) extends IdentityService[User]{

  def retrieve(loginInfo: LoginInfo): Future[Option[User]] = userRepository.find(loginInfo)

  def save(user: User): Future[User] = userRepository.save(user)

  def update(user: User): Future[User] = userRepository.update(user)

  def delete(user: User): Future[User] = userRepository.delete(user)
}

