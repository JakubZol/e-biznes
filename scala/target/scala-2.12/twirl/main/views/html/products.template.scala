
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

object products extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[Seq[Product],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(products: Seq[Product]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),_display_(/*3.2*/for(product <- products) yield /*3.26*/ {_display_(Seq[Any](format.raw/*3.28*/("""
  """),format.raw/*4.3*/("""<b>"""),_display_(/*4.7*/product/*4.14*/.name),format.raw/*4.19*/("""</b>
  """),_display_(/*5.4*/product/*5.11*/.description),format.raw/*5.23*/("""
  """),_display_(/*6.4*/product/*6.11*/.category),format.raw/*6.20*/("""
  """),format.raw/*7.3*/("""<a href=""""),_display_(/*7.13*/controllers/*7.24*/.routes.HomeController.updateProduct(product.id)),format.raw/*7.72*/("""">Edit</a>
  <a href=""""),_display_(/*8.13*/controllers/*8.24*/.routes.HomeController.delete(product.id)),format.raw/*8.65*/("""">Delete</a>
""")))}),format.raw/*9.2*/("""
"""))
      }
    }
  }

  def render(products:Seq[Product]): play.twirl.api.HtmlFormat.Appendable = apply(products)

  def f:((Seq[Product]) => play.twirl.api.HtmlFormat.Appendable) = (products) => apply(products)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2021-06-06T17:21:01.965
                  SOURCE: /home/jakubzol/projects/ebiznes-master/ebiznes2021/backend-scala/app/views/products.scala.html
                  HASH: 63a8688f163a04393dd2c463ed91b41151788f71
                  MATRIX: 738->1|856->26|883->28|922->52|961->54|990->57|1019->61|1034->68|1059->73|1092->81|1107->88|1139->100|1168->104|1183->111|1212->120|1241->123|1277->133|1296->144|1364->192|1413->215|1432->226|1493->267|1536->281
                  LINES: 21->1|26->2|27->3|27->3|27->3|28->4|28->4|28->4|28->4|29->5|29->5|29->5|30->6|30->6|30->6|31->7|31->7|31->7|31->7|32->8|32->8|32->8|33->9
                  -- GENERATED --
              */
          