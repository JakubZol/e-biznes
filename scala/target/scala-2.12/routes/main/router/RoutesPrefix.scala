// @GENERATOR:play-routes-compiler
// @SOURCE:/home/jakubzol/projects/ebiznes/e-biznes/scala/conf/routes
// @DATE:Sun Jun 13 14:24:01 CEST 2021


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
