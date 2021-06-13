
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

object productupdate extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[Form[UpdateProductForm],Seq[Category],MessagesRequestHeader,Flash,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(product: Form[UpdateProductForm],category: Seq[Category])(implicit request: MessagesRequestHeader, flash: Flash):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*3.2*/import helper._


Seq[Any](format.raw/*2.1*/("""
"""),format.raw/*4.1*/("""
"""),_display_(/*5.2*/flash/*5.7*/.get("success").getOrElse("")),format.raw/*5.36*/("""

"""),_display_(/*7.2*/form(routes.HomeController.updateProductHandle())/*7.51*/ {_display_(Seq[Any](format.raw/*7.53*/("""
  """),_display_(/*8.4*/helper/*8.10*/.CSRF.formField),format.raw/*8.25*/("""
  """),format.raw/*9.3*/("""<input name="id" id="id" value=""""),_display_(/*9.36*/product("id")/*9.49*/.value),format.raw/*9.55*/("""" type="hidden" />
  """),_display_(/*10.4*/inputText(product("name"))),format.raw/*10.30*/("""
  """),_display_(/*11.4*/inputText(product("description"))),format.raw/*11.37*/("""

  """),format.raw/*13.3*/("""<select name="category" id="category">
  """),_display_(/*14.4*/for(cat <- category) yield /*14.24*/{_display_(Seq[Any](format.raw/*14.25*/("""
    """),_display_(/*15.6*/if(cat.id.toString==product("category").value.getOrElse(0))/*15.65*/ {_display_(Seq[Any](format.raw/*15.67*/("""
      """),format.raw/*16.7*/("""<option value=""""),_display_(/*16.23*/cat/*16.26*/.id),format.raw/*16.29*/("""" selected>"""),_display_(/*16.41*/cat/*16.44*/.name),format.raw/*16.49*/("""</option>
    """)))}/*17.6*/else/*17.10*/{_display_(Seq[Any](format.raw/*17.11*/("""
      """),format.raw/*18.7*/("""<option value=""""),_display_(/*18.23*/cat/*18.26*/.id),format.raw/*18.29*/("""">"""),_display_(/*18.32*/cat/*18.35*/.name),format.raw/*18.40*/("""</option>
    """)))}),format.raw/*19.6*/("""

  """)))}),format.raw/*21.4*/("""
  """),format.raw/*22.3*/("""</select>

  <div class="buttons">
    <input type="submit" value="Update Product"/>
  </div>
""")))}),format.raw/*27.2*/("""
"""))
      }
    }
  }

  def render(product:Form[UpdateProductForm],category:Seq[Category],request:MessagesRequestHeader,flash:Flash): play.twirl.api.HtmlFormat.Appendable = apply(product,category)(request,flash)

  def f:((Form[UpdateProductForm],Seq[Category]) => (MessagesRequestHeader,Flash) => play.twirl.api.HtmlFormat.Appendable) = (product,category) => (request,flash) => apply(product,category)(request,flash)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2021-06-06T17:21:01.939
                  SOURCE: /home/jakubzol/projects/ebiznes-master/ebiznes2021/backend-scala/app/views/productupdate.scala.html
                  HASH: bc4cfafc8324a0ead30ce3afdd89d9fafb07f044
                  MATRIX: 796->1|982->117|1026->115|1053->133|1080->135|1092->140|1141->169|1169->172|1226->221|1265->223|1294->227|1308->233|1343->248|1372->251|1431->284|1452->297|1478->303|1526->325|1573->351|1603->355|1657->388|1688->392|1756->434|1792->454|1831->455|1863->461|1931->520|1971->522|2005->529|2048->545|2060->548|2084->551|2123->563|2135->566|2161->571|2194->586|2207->590|2246->591|2280->598|2323->614|2335->617|2359->620|2389->623|2401->626|2427->631|2472->646|2507->651|2537->654|2662->749
                  LINES: 21->1|24->3|27->2|28->4|29->5|29->5|29->5|31->7|31->7|31->7|32->8|32->8|32->8|33->9|33->9|33->9|33->9|34->10|34->10|35->11|35->11|37->13|38->14|38->14|38->14|39->15|39->15|39->15|40->16|40->16|40->16|40->16|40->16|40->16|40->16|41->17|41->17|41->17|42->18|42->18|42->18|42->18|42->18|42->18|42->18|43->19|45->21|46->22|51->27
                  -- GENERATED --
              */
          