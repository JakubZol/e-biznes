// @GENERATOR:play-routes-compiler
// @SOURCE:/home/jakubzol/projects/ebiznes/e-biznes/scala/conf/routes
// @DATE:Sun Jun 13 14:24:01 CEST 2021

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers {

  // @LINE:21
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:21
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:58
  class ReverseSweatbandsController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:58
    def getSweatbands(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "sweatbands")
    }
  
    // @LINE:60
    def updateSweatband(id:Long): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "sweatbands/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:61
    def delete(id:Long): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "sweatbands/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:59
    def addSweatband(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "sweatbands")
    }
  
  }

  // @LINE:28
  class ReverseBallsController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:30
    def updateBall(id:Long): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "balls/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:28
    def getBalls(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "balls")
    }
  
    // @LINE:31
    def delete(id:Long): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "balls/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:29
    def addBall(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "balls")
    }
  
  }

  // @LINE:33
  class ReverseGlovesController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:34
    def addGloves(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "gloves")
    }
  
    // @LINE:36
    def delete(id:Long): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "gloves/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:35
    def updateGloves(id:Long): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "gloves/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:33
    def getGloves(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "gloves")
    }
  
  }

  // @LINE:16
  class ReverseCountController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:16
    def count(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "count")
    }
  
  }

  // @LINE:63
  class ReverseTrousersController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:66
    def delete(id:Long): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "trousers/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:63
    def getTrousers(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "trousers")
    }
  
    // @LINE:64
    def addTrousers(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "trousers")
    }
  
    // @LINE:65
    def updateTrousers(id:Long): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "trousers/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
  }

  // @LINE:38
  class ReverseHatsController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:39
    def addHat(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "hats")
    }
  
    // @LINE:38
    def getHats(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "hats")
    }
  
    // @LINE:40
    def updateHat(id:Long): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "hats/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:41
    def delete(id:Long): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "hats/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
  }

  // @LINE:43
  class ReverseHelmetsController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:45
    def updateHelmet(id:Long): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "helmets/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:43
    def getHelmets(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "helmets")
    }
  
    // @LINE:46
    def delete(id:Long): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "helmets/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:44
    def addHelmet(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "helmets")
    }
  
  }

  // @LINE:23
  class ReverseUsersController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:24
    def addUser(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "users")
    }
  
    // @LINE:25
    def updateUser(id:Long): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "users/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:23
    def getUsers(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "users")
    }
  
    // @LINE:26
    def delete(id:Long): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "users/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
  }

  // @LINE:48
  class ReverseShirtsController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:49
    def addShirt(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "shirts")
    }
  
    // @LINE:50
    def updateShirt(id:Long): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "shirts/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:48
    def getShirts(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "shirts")
    }
  
    // @LINE:51
    def delete(id:Long): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "shirts/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
  }

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:14
    def delete(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "deleteproduct/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:13
    def getProduct(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "product/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:12
    def getProducts(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "products")
    }
  
    // @LINE:10
    def updateProductHandle(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "updateproducthandle")
    }
  
    // @LINE:8
    def addProductHandle(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addproducthandle")
    }
  
    // @LINE:9
    def updateProduct(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "updateproduct/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:7
    def addProduct(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "addproduct")
    }
  
    // @LINE:6
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:18
  class ReverseAsyncController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:18
    def message(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "message")
    }
  
  }

  // @LINE:53
  class ReverseShoesController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:56
    def delete(id:Long): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "shoes/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:53
    def getShoes(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "shoes")
    }
  
    // @LINE:55
    def updateShoes(id:Long): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "shoes/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:54
    def addShoes(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "shoes")
    }
  
  }


}
