
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

object productadd extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[Form[CreateProductForm],Seq[Category],MessagesRequestHeader,Flash,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(product: Form[CreateProductForm],category: Seq[Category])(implicit request: MessagesRequestHeader, flash: Flash):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*3.2*/import helper._


Seq[Any](format.raw/*2.1*/("""
"""),format.raw/*4.1*/("""
"""),_display_(/*5.2*/flash/*5.7*/.get("success").getOrElse("")),format.raw/*5.36*/("""

"""),_display_(/*7.2*/form(routes.HomeController.addProductHandle())/*7.48*/ {_display_(Seq[Any](format.raw/*7.50*/("""
  """),_display_(/*8.4*/helper/*8.10*/.CSRF.formField),format.raw/*8.25*/("""
  """),_display_(/*9.4*/inputText(product("name"))),format.raw/*9.30*/("""
  """),_display_(/*10.4*/inputText(product("description"))),format.raw/*10.37*/("""

  """),format.raw/*12.3*/("""<select name="category" id="category">
  """),_display_(/*13.4*/for(cat <- category) yield /*13.24*/{_display_(Seq[Any](format.raw/*13.25*/("""
    """),format.raw/*14.5*/("""<option value=""""),_display_(/*14.21*/cat/*14.24*/.id),format.raw/*14.27*/("""">"""),_display_(/*14.30*/cat/*14.33*/.name),format.raw/*14.38*/("""</option>
  """)))}),format.raw/*15.4*/("""
  """),format.raw/*16.3*/("""</select>

  <div class="buttons">
    <input type="submit" value="Add Product"/>
  </div>
""")))}),format.raw/*21.2*/("""
"""))
      }
    }
  }

  def render(product:Form[CreateProductForm],category:Seq[Category],request:MessagesRequestHeader,flash:Flash): play.twirl.api.HtmlFormat.Appendable = apply(product,category)(request,flash)

  def f:((Form[CreateProductForm],Seq[Category]) => (MessagesRequestHeader,Flash) => play.twirl.api.HtmlFormat.Appendable) = (product,category) => (request,flash) => apply(product,category)(request,flash)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2021-06-06T17:21:01.924
                  SOURCE: /home/jakubzol/projects/ebiznes-master/ebiznes2021/backend-scala/app/views/productadd.scala.html
                  HASH: ad6fc50d9b405f8b76f0b2411438bba86e962904
                  MATRIX: 793->1|979->117|1023->115|1050->133|1077->135|1089->140|1138->169|1166->172|1220->218|1259->220|1288->224|1302->230|1337->245|1366->249|1412->275|1442->279|1496->312|1527->316|1595->358|1631->378|1670->379|1702->384|1745->400|1757->403|1781->406|1811->409|1823->412|1849->417|1892->430|1922->433|2044->525
                  LINES: 21->1|24->3|27->2|28->4|29->5|29->5|29->5|31->7|31->7|31->7|32->8|32->8|32->8|33->9|33->9|34->10|34->10|36->12|37->13|37->13|37->13|38->14|38->14|38->14|38->14|38->14|38->14|38->14|39->15|40->16|45->21
                  -- GENERATED --
              */
          