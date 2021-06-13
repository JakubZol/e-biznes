// @GENERATOR:play-routes-compiler
// @SOURCE:/home/jakubzol/projects/ebiznes/e-biznes/scala/conf/routes
// @DATE:Sun Jun 13 14:24:01 CEST 2021

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  HomeController_12: controllers.HomeController,
  // @LINE:16
  CountController_3: controllers.CountController,
  // @LINE:18
  AsyncController_11: controllers.AsyncController,
  // @LINE:21
  Assets_7: controllers.Assets,
  // @LINE:23
  UsersController_4: controllers.UsersController,
  // @LINE:28
  BallsController_10: controllers.BallsController,
  // @LINE:33
  GlovesController_0: controllers.GlovesController,
  // @LINE:38
  HatsController_8: controllers.HatsController,
  // @LINE:43
  HelmetsController_9: controllers.HelmetsController,
  // @LINE:48
  ShirtsController_1: controllers.ShirtsController,
  // @LINE:53
  ShoesController_6: controllers.ShoesController,
  // @LINE:58
  SweatbandsController_2: controllers.SweatbandsController,
  // @LINE:63
  TrousersController_5: controllers.TrousersController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    HomeController_12: controllers.HomeController,
    // @LINE:16
    CountController_3: controllers.CountController,
    // @LINE:18
    AsyncController_11: controllers.AsyncController,
    // @LINE:21
    Assets_7: controllers.Assets,
    // @LINE:23
    UsersController_4: controllers.UsersController,
    // @LINE:28
    BallsController_10: controllers.BallsController,
    // @LINE:33
    GlovesController_0: controllers.GlovesController,
    // @LINE:38
    HatsController_8: controllers.HatsController,
    // @LINE:43
    HelmetsController_9: controllers.HelmetsController,
    // @LINE:48
    ShirtsController_1: controllers.ShirtsController,
    // @LINE:53
    ShoesController_6: controllers.ShoesController,
    // @LINE:58
    SweatbandsController_2: controllers.SweatbandsController,
    // @LINE:63
    TrousersController_5: controllers.TrousersController
  ) = this(errorHandler, HomeController_12, CountController_3, AsyncController_11, Assets_7, UsersController_4, BallsController_10, GlovesController_0, HatsController_8, HelmetsController_9, ShirtsController_1, ShoesController_6, SweatbandsController_2, TrousersController_5, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_12, CountController_3, AsyncController_11, Assets_7, UsersController_4, BallsController_10, GlovesController_0, HatsController_8, HelmetsController_9, ShirtsController_1, ShoesController_6, SweatbandsController_2, TrousersController_5, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addproduct""", """controllers.HomeController.addProduct"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addproducthandle""", """controllers.HomeController.addProductHandle"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updateproduct/""" + "$" + """id<[^/]+>""", """controllers.HomeController.updateProduct(id:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updateproducthandle""", """controllers.HomeController.updateProductHandle"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """products""", """controllers.HomeController.getProducts"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """product/""" + "$" + """id<[^/]+>""", """controllers.HomeController.getProduct(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteproduct/""" + "$" + """id<[^/]+>""", """controllers.HomeController.delete(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """count""", """controllers.CountController.count"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """message""", """controllers.AsyncController.message"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """users""", """controllers.UsersController.getUsers"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """users""", """controllers.UsersController.addUser"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """users/""" + "$" + """id<[^/]+>""", """controllers.UsersController.updateUser(id:Long)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """users/""" + "$" + """id<[^/]+>""", """controllers.UsersController.delete(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """balls""", """controllers.BallsController.getBalls"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """balls""", """controllers.BallsController.addBall"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """balls/""" + "$" + """id<[^/]+>""", """controllers.BallsController.updateBall(id:Long)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """balls/""" + "$" + """id<[^/]+>""", """controllers.BallsController.delete(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """gloves""", """controllers.GlovesController.getGloves"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """gloves""", """controllers.GlovesController.addGloves"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """gloves/""" + "$" + """id<[^/]+>""", """controllers.GlovesController.updateGloves(id:Long)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """gloves/""" + "$" + """id<[^/]+>""", """controllers.GlovesController.delete(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """hats""", """controllers.HatsController.getHats"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """hats""", """controllers.HatsController.addHat"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """hats/""" + "$" + """id<[^/]+>""", """controllers.HatsController.updateHat(id:Long)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """hats/""" + "$" + """id<[^/]+>""", """controllers.HatsController.delete(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """helmets""", """controllers.HelmetsController.getHelmets"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """helmets""", """controllers.HelmetsController.addHelmet"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """helmets/""" + "$" + """id<[^/]+>""", """controllers.HelmetsController.updateHelmet(id:Long)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """helmets/""" + "$" + """id<[^/]+>""", """controllers.HelmetsController.delete(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """shirts""", """controllers.ShirtsController.getShirts"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """shirts""", """controllers.ShirtsController.addShirt"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """shirts/""" + "$" + """id<[^/]+>""", """controllers.ShirtsController.updateShirt(id:Long)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """shirts/""" + "$" + """id<[^/]+>""", """controllers.ShirtsController.delete(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """shoes""", """controllers.ShoesController.getShoes"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """shoes""", """controllers.ShoesController.addShoes"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """shoes/""" + "$" + """id<[^/]+>""", """controllers.ShoesController.updateShoes(id:Long)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """shoes/""" + "$" + """id<[^/]+>""", """controllers.ShoesController.delete(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """sweatbands""", """controllers.SweatbandsController.getSweatbands"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """sweatbands""", """controllers.SweatbandsController.addSweatband"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """sweatbands/""" + "$" + """id<[^/]+>""", """controllers.SweatbandsController.updateSweatband(id:Long)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """sweatbands/""" + "$" + """id<[^/]+>""", """controllers.SweatbandsController.delete(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """trousers""", """controllers.TrousersController.getTrousers"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """trousers""", """controllers.TrousersController.addTrousers"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """trousers/""" + "$" + """id<[^/]+>""", """controllers.TrousersController.updateTrousers(id:Long)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """trousers/""" + "$" + """id<[^/]+>""", """controllers.TrousersController.delete(id:Long)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_12.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_HomeController_addProduct1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addproduct")))
  )
  private[this] lazy val controllers_HomeController_addProduct1_invoker = createInvoker(
    HomeController_12.addProduct,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "addProduct",
      Nil,
      "GET",
      this.prefix + """addproduct""",
      """""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_HomeController_addProductHandle2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addproducthandle")))
  )
  private[this] lazy val controllers_HomeController_addProductHandle2_invoker = createInvoker(
    HomeController_12.addProductHandle,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "addProductHandle",
      Nil,
      "POST",
      this.prefix + """addproducthandle""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_HomeController_updateProduct3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateproduct/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_updateProduct3_invoker = createInvoker(
    HomeController_12.updateProduct(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "updateProduct",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """updateproduct/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_HomeController_updateProductHandle4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateproducthandle")))
  )
  private[this] lazy val controllers_HomeController_updateProductHandle4_invoker = createInvoker(
    HomeController_12.updateProductHandle,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "updateProductHandle",
      Nil,
      "POST",
      this.prefix + """updateproducthandle""",
      """""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_HomeController_getProducts5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("products")))
  )
  private[this] lazy val controllers_HomeController_getProducts5_invoker = createInvoker(
    HomeController_12.getProducts,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "getProducts",
      Nil,
      "GET",
      this.prefix + """products""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_HomeController_getProduct6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("product/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_getProduct6_invoker = createInvoker(
    HomeController_12.getProduct(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "getProduct",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """product/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_HomeController_delete7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteproduct/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_delete7_invoker = createInvoker(
    HomeController_12.delete(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "delete",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """deleteproduct/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_CountController_count8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("count")))
  )
  private[this] lazy val controllers_CountController_count8_invoker = createInvoker(
    CountController_3.count,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CountController",
      "count",
      Nil,
      "GET",
      this.prefix + """count""",
      """ An example controller showing how to use dependency injection""",
      Seq()
    )
  )

  // @LINE:18
  private[this] lazy val controllers_AsyncController_message9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("message")))
  )
  private[this] lazy val controllers_AsyncController_message9_invoker = createInvoker(
    AsyncController_11.message,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AsyncController",
      "message",
      Nil,
      "GET",
      this.prefix + """message""",
      """ An example controller showing how to write asynchronous code""",
      Seq()
    )
  )

  // @LINE:21
  private[this] lazy val controllers_Assets_versioned10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned10_invoker = createInvoker(
    Assets_7.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )

  // @LINE:23
  private[this] lazy val controllers_UsersController_getUsers11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("users")))
  )
  private[this] lazy val controllers_UsersController_getUsers11_invoker = createInvoker(
    UsersController_4.getUsers,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UsersController",
      "getUsers",
      Nil,
      "GET",
      this.prefix + """users""",
      """""",
      Seq()
    )
  )

  // @LINE:24
  private[this] lazy val controllers_UsersController_addUser12_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("users")))
  )
  private[this] lazy val controllers_UsersController_addUser12_invoker = createInvoker(
    UsersController_4.addUser,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UsersController",
      "addUser",
      Nil,
      "POST",
      this.prefix + """users""",
      """""",
      Seq()
    )
  )

  // @LINE:25
  private[this] lazy val controllers_UsersController_updateUser13_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("users/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UsersController_updateUser13_invoker = createInvoker(
    UsersController_4.updateUser(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UsersController",
      "updateUser",
      Seq(classOf[Long]),
      "PUT",
      this.prefix + """users/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:26
  private[this] lazy val controllers_UsersController_delete14_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("users/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UsersController_delete14_invoker = createInvoker(
    UsersController_4.delete(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UsersController",
      "delete",
      Seq(classOf[Long]),
      "DELETE",
      this.prefix + """users/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:28
  private[this] lazy val controllers_BallsController_getBalls15_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("balls")))
  )
  private[this] lazy val controllers_BallsController_getBalls15_invoker = createInvoker(
    BallsController_10.getBalls,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.BallsController",
      "getBalls",
      Nil,
      "GET",
      this.prefix + """balls""",
      """""",
      Seq()
    )
  )

  // @LINE:29
  private[this] lazy val controllers_BallsController_addBall16_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("balls")))
  )
  private[this] lazy val controllers_BallsController_addBall16_invoker = createInvoker(
    BallsController_10.addBall,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.BallsController",
      "addBall",
      Nil,
      "POST",
      this.prefix + """balls""",
      """""",
      Seq()
    )
  )

  // @LINE:30
  private[this] lazy val controllers_BallsController_updateBall17_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("balls/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_BallsController_updateBall17_invoker = createInvoker(
    BallsController_10.updateBall(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.BallsController",
      "updateBall",
      Seq(classOf[Long]),
      "PUT",
      this.prefix + """balls/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:31
  private[this] lazy val controllers_BallsController_delete18_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("balls/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_BallsController_delete18_invoker = createInvoker(
    BallsController_10.delete(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.BallsController",
      "delete",
      Seq(classOf[Long]),
      "DELETE",
      this.prefix + """balls/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:33
  private[this] lazy val controllers_GlovesController_getGloves19_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("gloves")))
  )
  private[this] lazy val controllers_GlovesController_getGloves19_invoker = createInvoker(
    GlovesController_0.getGloves,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.GlovesController",
      "getGloves",
      Nil,
      "GET",
      this.prefix + """gloves""",
      """""",
      Seq()
    )
  )

  // @LINE:34
  private[this] lazy val controllers_GlovesController_addGloves20_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("gloves")))
  )
  private[this] lazy val controllers_GlovesController_addGloves20_invoker = createInvoker(
    GlovesController_0.addGloves,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.GlovesController",
      "addGloves",
      Nil,
      "POST",
      this.prefix + """gloves""",
      """""",
      Seq()
    )
  )

  // @LINE:35
  private[this] lazy val controllers_GlovesController_updateGloves21_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("gloves/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_GlovesController_updateGloves21_invoker = createInvoker(
    GlovesController_0.updateGloves(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.GlovesController",
      "updateGloves",
      Seq(classOf[Long]),
      "PUT",
      this.prefix + """gloves/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:36
  private[this] lazy val controllers_GlovesController_delete22_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("gloves/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_GlovesController_delete22_invoker = createInvoker(
    GlovesController_0.delete(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.GlovesController",
      "delete",
      Seq(classOf[Long]),
      "DELETE",
      this.prefix + """gloves/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:38
  private[this] lazy val controllers_HatsController_getHats23_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("hats")))
  )
  private[this] lazy val controllers_HatsController_getHats23_invoker = createInvoker(
    HatsController_8.getHats,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HatsController",
      "getHats",
      Nil,
      "GET",
      this.prefix + """hats""",
      """""",
      Seq()
    )
  )

  // @LINE:39
  private[this] lazy val controllers_HatsController_addHat24_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("hats")))
  )
  private[this] lazy val controllers_HatsController_addHat24_invoker = createInvoker(
    HatsController_8.addHat,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HatsController",
      "addHat",
      Nil,
      "POST",
      this.prefix + """hats""",
      """""",
      Seq()
    )
  )

  // @LINE:40
  private[this] lazy val controllers_HatsController_updateHat25_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("hats/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HatsController_updateHat25_invoker = createInvoker(
    HatsController_8.updateHat(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HatsController",
      "updateHat",
      Seq(classOf[Long]),
      "PUT",
      this.prefix + """hats/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:41
  private[this] lazy val controllers_HatsController_delete26_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("hats/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HatsController_delete26_invoker = createInvoker(
    HatsController_8.delete(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HatsController",
      "delete",
      Seq(classOf[Long]),
      "DELETE",
      this.prefix + """hats/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:43
  private[this] lazy val controllers_HelmetsController_getHelmets27_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("helmets")))
  )
  private[this] lazy val controllers_HelmetsController_getHelmets27_invoker = createInvoker(
    HelmetsController_9.getHelmets,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HelmetsController",
      "getHelmets",
      Nil,
      "GET",
      this.prefix + """helmets""",
      """""",
      Seq()
    )
  )

  // @LINE:44
  private[this] lazy val controllers_HelmetsController_addHelmet28_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("helmets")))
  )
  private[this] lazy val controllers_HelmetsController_addHelmet28_invoker = createInvoker(
    HelmetsController_9.addHelmet,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HelmetsController",
      "addHelmet",
      Nil,
      "POST",
      this.prefix + """helmets""",
      """""",
      Seq()
    )
  )

  // @LINE:45
  private[this] lazy val controllers_HelmetsController_updateHelmet29_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("helmets/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HelmetsController_updateHelmet29_invoker = createInvoker(
    HelmetsController_9.updateHelmet(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HelmetsController",
      "updateHelmet",
      Seq(classOf[Long]),
      "PUT",
      this.prefix + """helmets/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:46
  private[this] lazy val controllers_HelmetsController_delete30_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("helmets/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HelmetsController_delete30_invoker = createInvoker(
    HelmetsController_9.delete(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HelmetsController",
      "delete",
      Seq(classOf[Long]),
      "DELETE",
      this.prefix + """helmets/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:48
  private[this] lazy val controllers_ShirtsController_getShirts31_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("shirts")))
  )
  private[this] lazy val controllers_ShirtsController_getShirts31_invoker = createInvoker(
    ShirtsController_1.getShirts,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ShirtsController",
      "getShirts",
      Nil,
      "GET",
      this.prefix + """shirts""",
      """""",
      Seq()
    )
  )

  // @LINE:49
  private[this] lazy val controllers_ShirtsController_addShirt32_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("shirts")))
  )
  private[this] lazy val controllers_ShirtsController_addShirt32_invoker = createInvoker(
    ShirtsController_1.addShirt,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ShirtsController",
      "addShirt",
      Nil,
      "POST",
      this.prefix + """shirts""",
      """""",
      Seq()
    )
  )

  // @LINE:50
  private[this] lazy val controllers_ShirtsController_updateShirt33_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("shirts/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ShirtsController_updateShirt33_invoker = createInvoker(
    ShirtsController_1.updateShirt(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ShirtsController",
      "updateShirt",
      Seq(classOf[Long]),
      "PUT",
      this.prefix + """shirts/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:51
  private[this] lazy val controllers_ShirtsController_delete34_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("shirts/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ShirtsController_delete34_invoker = createInvoker(
    ShirtsController_1.delete(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ShirtsController",
      "delete",
      Seq(classOf[Long]),
      "DELETE",
      this.prefix + """shirts/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:53
  private[this] lazy val controllers_ShoesController_getShoes35_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("shoes")))
  )
  private[this] lazy val controllers_ShoesController_getShoes35_invoker = createInvoker(
    ShoesController_6.getShoes,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ShoesController",
      "getShoes",
      Nil,
      "GET",
      this.prefix + """shoes""",
      """""",
      Seq()
    )
  )

  // @LINE:54
  private[this] lazy val controllers_ShoesController_addShoes36_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("shoes")))
  )
  private[this] lazy val controllers_ShoesController_addShoes36_invoker = createInvoker(
    ShoesController_6.addShoes,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ShoesController",
      "addShoes",
      Nil,
      "POST",
      this.prefix + """shoes""",
      """""",
      Seq()
    )
  )

  // @LINE:55
  private[this] lazy val controllers_ShoesController_updateShoes37_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("shoes/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ShoesController_updateShoes37_invoker = createInvoker(
    ShoesController_6.updateShoes(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ShoesController",
      "updateShoes",
      Seq(classOf[Long]),
      "PUT",
      this.prefix + """shoes/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:56
  private[this] lazy val controllers_ShoesController_delete38_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("shoes/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ShoesController_delete38_invoker = createInvoker(
    ShoesController_6.delete(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ShoesController",
      "delete",
      Seq(classOf[Long]),
      "DELETE",
      this.prefix + """shoes/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:58
  private[this] lazy val controllers_SweatbandsController_getSweatbands39_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("sweatbands")))
  )
  private[this] lazy val controllers_SweatbandsController_getSweatbands39_invoker = createInvoker(
    SweatbandsController_2.getSweatbands,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.SweatbandsController",
      "getSweatbands",
      Nil,
      "GET",
      this.prefix + """sweatbands""",
      """""",
      Seq()
    )
  )

  // @LINE:59
  private[this] lazy val controllers_SweatbandsController_addSweatband40_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("sweatbands")))
  )
  private[this] lazy val controllers_SweatbandsController_addSweatband40_invoker = createInvoker(
    SweatbandsController_2.addSweatband,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.SweatbandsController",
      "addSweatband",
      Nil,
      "POST",
      this.prefix + """sweatbands""",
      """""",
      Seq()
    )
  )

  // @LINE:60
  private[this] lazy val controllers_SweatbandsController_updateSweatband41_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("sweatbands/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_SweatbandsController_updateSweatband41_invoker = createInvoker(
    SweatbandsController_2.updateSweatband(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.SweatbandsController",
      "updateSweatband",
      Seq(classOf[Long]),
      "PUT",
      this.prefix + """sweatbands/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:61
  private[this] lazy val controllers_SweatbandsController_delete42_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("sweatbands/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_SweatbandsController_delete42_invoker = createInvoker(
    SweatbandsController_2.delete(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.SweatbandsController",
      "delete",
      Seq(classOf[Long]),
      "DELETE",
      this.prefix + """sweatbands/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:63
  private[this] lazy val controllers_TrousersController_getTrousers43_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("trousers")))
  )
  private[this] lazy val controllers_TrousersController_getTrousers43_invoker = createInvoker(
    TrousersController_5.getTrousers,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TrousersController",
      "getTrousers",
      Nil,
      "GET",
      this.prefix + """trousers""",
      """""",
      Seq()
    )
  )

  // @LINE:64
  private[this] lazy val controllers_TrousersController_addTrousers44_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("trousers")))
  )
  private[this] lazy val controllers_TrousersController_addTrousers44_invoker = createInvoker(
    TrousersController_5.addTrousers,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TrousersController",
      "addTrousers",
      Nil,
      "POST",
      this.prefix + """trousers""",
      """""",
      Seq()
    )
  )

  // @LINE:65
  private[this] lazy val controllers_TrousersController_updateTrousers45_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("trousers/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TrousersController_updateTrousers45_invoker = createInvoker(
    TrousersController_5.updateTrousers(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TrousersController",
      "updateTrousers",
      Seq(classOf[Long]),
      "PUT",
      this.prefix + """trousers/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:66
  private[this] lazy val controllers_TrousersController_delete46_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("trousers/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TrousersController_delete46_invoker = createInvoker(
    TrousersController_5.delete(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TrousersController",
      "delete",
      Seq(classOf[Long]),
      "DELETE",
      this.prefix + """trousers/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_HomeController_index0_route(params@_) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_12.index)
      }
  
    // @LINE:7
    case controllers_HomeController_addProduct1_route(params@_) =>
      call { 
        controllers_HomeController_addProduct1_invoker.call(HomeController_12.addProduct)
      }
  
    // @LINE:8
    case controllers_HomeController_addProductHandle2_route(params@_) =>
      call { 
        controllers_HomeController_addProductHandle2_invoker.call(HomeController_12.addProductHandle)
      }
  
    // @LINE:9
    case controllers_HomeController_updateProduct3_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_HomeController_updateProduct3_invoker.call(HomeController_12.updateProduct(id))
      }
  
    // @LINE:10
    case controllers_HomeController_updateProductHandle4_route(params@_) =>
      call { 
        controllers_HomeController_updateProductHandle4_invoker.call(HomeController_12.updateProductHandle)
      }
  
    // @LINE:12
    case controllers_HomeController_getProducts5_route(params@_) =>
      call { 
        controllers_HomeController_getProducts5_invoker.call(HomeController_12.getProducts)
      }
  
    // @LINE:13
    case controllers_HomeController_getProduct6_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_HomeController_getProduct6_invoker.call(HomeController_12.getProduct(id))
      }
  
    // @LINE:14
    case controllers_HomeController_delete7_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_HomeController_delete7_invoker.call(HomeController_12.delete(id))
      }
  
    // @LINE:16
    case controllers_CountController_count8_route(params@_) =>
      call { 
        controllers_CountController_count8_invoker.call(CountController_3.count)
      }
  
    // @LINE:18
    case controllers_AsyncController_message9_route(params@_) =>
      call { 
        controllers_AsyncController_message9_invoker.call(AsyncController_11.message)
      }
  
    // @LINE:21
    case controllers_Assets_versioned10_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned10_invoker.call(Assets_7.versioned(path, file))
      }
  
    // @LINE:23
    case controllers_UsersController_getUsers11_route(params@_) =>
      call { 
        controllers_UsersController_getUsers11_invoker.call(UsersController_4.getUsers)
      }
  
    // @LINE:24
    case controllers_UsersController_addUser12_route(params@_) =>
      call { 
        controllers_UsersController_addUser12_invoker.call(UsersController_4.addUser)
      }
  
    // @LINE:25
    case controllers_UsersController_updateUser13_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_UsersController_updateUser13_invoker.call(UsersController_4.updateUser(id))
      }
  
    // @LINE:26
    case controllers_UsersController_delete14_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_UsersController_delete14_invoker.call(UsersController_4.delete(id))
      }
  
    // @LINE:28
    case controllers_BallsController_getBalls15_route(params@_) =>
      call { 
        controllers_BallsController_getBalls15_invoker.call(BallsController_10.getBalls)
      }
  
    // @LINE:29
    case controllers_BallsController_addBall16_route(params@_) =>
      call { 
        controllers_BallsController_addBall16_invoker.call(BallsController_10.addBall)
      }
  
    // @LINE:30
    case controllers_BallsController_updateBall17_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_BallsController_updateBall17_invoker.call(BallsController_10.updateBall(id))
      }
  
    // @LINE:31
    case controllers_BallsController_delete18_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_BallsController_delete18_invoker.call(BallsController_10.delete(id))
      }
  
    // @LINE:33
    case controllers_GlovesController_getGloves19_route(params@_) =>
      call { 
        controllers_GlovesController_getGloves19_invoker.call(GlovesController_0.getGloves)
      }
  
    // @LINE:34
    case controllers_GlovesController_addGloves20_route(params@_) =>
      call { 
        controllers_GlovesController_addGloves20_invoker.call(GlovesController_0.addGloves)
      }
  
    // @LINE:35
    case controllers_GlovesController_updateGloves21_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_GlovesController_updateGloves21_invoker.call(GlovesController_0.updateGloves(id))
      }
  
    // @LINE:36
    case controllers_GlovesController_delete22_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_GlovesController_delete22_invoker.call(GlovesController_0.delete(id))
      }
  
    // @LINE:38
    case controllers_HatsController_getHats23_route(params@_) =>
      call { 
        controllers_HatsController_getHats23_invoker.call(HatsController_8.getHats)
      }
  
    // @LINE:39
    case controllers_HatsController_addHat24_route(params@_) =>
      call { 
        controllers_HatsController_addHat24_invoker.call(HatsController_8.addHat)
      }
  
    // @LINE:40
    case controllers_HatsController_updateHat25_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_HatsController_updateHat25_invoker.call(HatsController_8.updateHat(id))
      }
  
    // @LINE:41
    case controllers_HatsController_delete26_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_HatsController_delete26_invoker.call(HatsController_8.delete(id))
      }
  
    // @LINE:43
    case controllers_HelmetsController_getHelmets27_route(params@_) =>
      call { 
        controllers_HelmetsController_getHelmets27_invoker.call(HelmetsController_9.getHelmets)
      }
  
    // @LINE:44
    case controllers_HelmetsController_addHelmet28_route(params@_) =>
      call { 
        controllers_HelmetsController_addHelmet28_invoker.call(HelmetsController_9.addHelmet)
      }
  
    // @LINE:45
    case controllers_HelmetsController_updateHelmet29_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_HelmetsController_updateHelmet29_invoker.call(HelmetsController_9.updateHelmet(id))
      }
  
    // @LINE:46
    case controllers_HelmetsController_delete30_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_HelmetsController_delete30_invoker.call(HelmetsController_9.delete(id))
      }
  
    // @LINE:48
    case controllers_ShirtsController_getShirts31_route(params@_) =>
      call { 
        controllers_ShirtsController_getShirts31_invoker.call(ShirtsController_1.getShirts)
      }
  
    // @LINE:49
    case controllers_ShirtsController_addShirt32_route(params@_) =>
      call { 
        controllers_ShirtsController_addShirt32_invoker.call(ShirtsController_1.addShirt)
      }
  
    // @LINE:50
    case controllers_ShirtsController_updateShirt33_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_ShirtsController_updateShirt33_invoker.call(ShirtsController_1.updateShirt(id))
      }
  
    // @LINE:51
    case controllers_ShirtsController_delete34_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_ShirtsController_delete34_invoker.call(ShirtsController_1.delete(id))
      }
  
    // @LINE:53
    case controllers_ShoesController_getShoes35_route(params@_) =>
      call { 
        controllers_ShoesController_getShoes35_invoker.call(ShoesController_6.getShoes)
      }
  
    // @LINE:54
    case controllers_ShoesController_addShoes36_route(params@_) =>
      call { 
        controllers_ShoesController_addShoes36_invoker.call(ShoesController_6.addShoes)
      }
  
    // @LINE:55
    case controllers_ShoesController_updateShoes37_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_ShoesController_updateShoes37_invoker.call(ShoesController_6.updateShoes(id))
      }
  
    // @LINE:56
    case controllers_ShoesController_delete38_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_ShoesController_delete38_invoker.call(ShoesController_6.delete(id))
      }
  
    // @LINE:58
    case controllers_SweatbandsController_getSweatbands39_route(params@_) =>
      call { 
        controllers_SweatbandsController_getSweatbands39_invoker.call(SweatbandsController_2.getSweatbands)
      }
  
    // @LINE:59
    case controllers_SweatbandsController_addSweatband40_route(params@_) =>
      call { 
        controllers_SweatbandsController_addSweatband40_invoker.call(SweatbandsController_2.addSweatband)
      }
  
    // @LINE:60
    case controllers_SweatbandsController_updateSweatband41_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_SweatbandsController_updateSweatband41_invoker.call(SweatbandsController_2.updateSweatband(id))
      }
  
    // @LINE:61
    case controllers_SweatbandsController_delete42_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_SweatbandsController_delete42_invoker.call(SweatbandsController_2.delete(id))
      }
  
    // @LINE:63
    case controllers_TrousersController_getTrousers43_route(params@_) =>
      call { 
        controllers_TrousersController_getTrousers43_invoker.call(TrousersController_5.getTrousers)
      }
  
    // @LINE:64
    case controllers_TrousersController_addTrousers44_route(params@_) =>
      call { 
        controllers_TrousersController_addTrousers44_invoker.call(TrousersController_5.addTrousers)
      }
  
    // @LINE:65
    case controllers_TrousersController_updateTrousers45_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_TrousersController_updateTrousers45_invoker.call(TrousersController_5.updateTrousers(id))
      }
  
    // @LINE:66
    case controllers_TrousersController_delete46_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_TrousersController_delete46_invoker.call(TrousersController_5.delete(id))
      }
  }
}
