// @GENERATOR:play-routes-compiler
// @SOURCE:/home/jakubzol/projects/ebiznes/e-biznes/scala/conf/routes
// @DATE:Sun Jun 13 14:24:01 CEST 2021

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers.javascript {

  // @LINE:21
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:21
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:58
  class ReverseSweatbandsController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:58
    def getSweatbands: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SweatbandsController.getSweatbands",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "sweatbands"})
        }
      """
    )
  
    // @LINE:60
    def updateSweatband: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SweatbandsController.updateSweatband",
      """
        function(id0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "sweatbands/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:61
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SweatbandsController.delete",
      """
        function(id0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "sweatbands/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:59
    def addSweatband: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SweatbandsController.addSweatband",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "sweatbands"})
        }
      """
    )
  
  }

  // @LINE:28
  class ReverseBallsController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:30
    def updateBall: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.BallsController.updateBall",
      """
        function(id0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "balls/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:28
    def getBalls: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.BallsController.getBalls",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "balls"})
        }
      """
    )
  
    // @LINE:31
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.BallsController.delete",
      """
        function(id0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "balls/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:29
    def addBall: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.BallsController.addBall",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "balls"})
        }
      """
    )
  
  }

  // @LINE:33
  class ReverseGlovesController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:34
    def addGloves: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.GlovesController.addGloves",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "gloves"})
        }
      """
    )
  
    // @LINE:36
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.GlovesController.delete",
      """
        function(id0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "gloves/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:35
    def updateGloves: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.GlovesController.updateGloves",
      """
        function(id0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "gloves/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:33
    def getGloves: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.GlovesController.getGloves",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "gloves"})
        }
      """
    )
  
  }

  // @LINE:16
  class ReverseCountController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:16
    def count: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CountController.count",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "count"})
        }
      """
    )
  
  }

  // @LINE:63
  class ReverseTrousersController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:66
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TrousersController.delete",
      """
        function(id0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "trousers/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:63
    def getTrousers: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TrousersController.getTrousers",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "trousers"})
        }
      """
    )
  
    // @LINE:64
    def addTrousers: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TrousersController.addTrousers",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "trousers"})
        }
      """
    )
  
    // @LINE:65
    def updateTrousers: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TrousersController.updateTrousers",
      """
        function(id0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "trousers/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
  }

  // @LINE:38
  class ReverseHatsController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:39
    def addHat: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HatsController.addHat",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "hats"})
        }
      """
    )
  
    // @LINE:38
    def getHats: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HatsController.getHats",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "hats"})
        }
      """
    )
  
    // @LINE:40
    def updateHat: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HatsController.updateHat",
      """
        function(id0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "hats/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:41
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HatsController.delete",
      """
        function(id0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "hats/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
  }

  // @LINE:43
  class ReverseHelmetsController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:45
    def updateHelmet: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HelmetsController.updateHelmet",
      """
        function(id0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "helmets/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:43
    def getHelmets: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HelmetsController.getHelmets",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "helmets"})
        }
      """
    )
  
    // @LINE:46
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HelmetsController.delete",
      """
        function(id0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "helmets/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:44
    def addHelmet: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HelmetsController.addHelmet",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "helmets"})
        }
      """
    )
  
  }

  // @LINE:23
  class ReverseUsersController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:24
    def addUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UsersController.addUser",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "users"})
        }
      """
    )
  
    // @LINE:25
    def updateUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UsersController.updateUser",
      """
        function(id0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "users/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:23
    def getUsers: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UsersController.getUsers",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "users"})
        }
      """
    )
  
    // @LINE:26
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UsersController.delete",
      """
        function(id0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "users/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
  }

  // @LINE:48
  class ReverseShirtsController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:49
    def addShirt: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ShirtsController.addShirt",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "shirts"})
        }
      """
    )
  
    // @LINE:50
    def updateShirt: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ShirtsController.updateShirt",
      """
        function(id0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "shirts/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:48
    def getShirts: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ShirtsController.getShirts",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "shirts"})
        }
      """
    )
  
    // @LINE:51
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ShirtsController.delete",
      """
        function(id0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "shirts/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:14
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.delete",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteproduct/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:13
    def getProduct: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.getProduct",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "product/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:12
    def getProducts: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.getProducts",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "products"})
        }
      """
    )
  
    // @LINE:10
    def updateProductHandle: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.updateProductHandle",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "updateproducthandle"})
        }
      """
    )
  
    // @LINE:8
    def addProductHandle: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.addProductHandle",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addproducthandle"})
        }
      """
    )
  
    // @LINE:9
    def updateProduct: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.updateProduct",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "updateproduct/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:7
    def addProduct: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.addProduct",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "addproduct"})
        }
      """
    )
  
    // @LINE:6
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }

  // @LINE:18
  class ReverseAsyncController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:18
    def message: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AsyncController.message",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "message"})
        }
      """
    )
  
  }

  // @LINE:53
  class ReverseShoesController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:56
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ShoesController.delete",
      """
        function(id0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "shoes/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:53
    def getShoes: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ShoesController.getShoes",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "shoes"})
        }
      """
    )
  
    // @LINE:55
    def updateShoes: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ShoesController.updateShoes",
      """
        function(id0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "shoes/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:54
    def addShoes: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ShoesController.addShoes",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "shoes"})
        }
      """
    )
  
  }


}
