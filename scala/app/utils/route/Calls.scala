package utils.route

import play.api.mvc.Call

object Calls {
  def home: Call = Call("GET", Constants.frontendUrl)

  def authenticationFailed: Call = Call("GET", Constants.frontendUrl + "authenticationFailed")
}
