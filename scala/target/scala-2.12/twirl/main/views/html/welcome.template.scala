
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

object welcome extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(message: String, style: String = "scala"):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),_display_(/*3.2*/defining(play.core.PlayVersion.current)/*3.41*/ { version =>_display_(Seq[Any](format.raw/*3.54*/("""

"""),format.raw/*5.1*/("""<section id="top">
  <div class="wrapper">
    <h1><a href="https://playframework.com/documentation/"""),_display_(/*7.59*/version),format.raw/*7.66*/("""/Home">"""),_display_(/*7.74*/message),format.raw/*7.81*/("""</a></h1>
  </div>
</section>

<div id="content" class="wrapper doc">
<article>

  <h1>Welcome to Play</h1>

  <p>
    Congratulations, you’ve just created a new Play application. This page will help you with the next few steps.
  </p>

  <blockquote>
    <p>
      You’re using Play """),_display_(/*22.26*/version),format.raw/*22.33*/("""
    """),format.raw/*23.5*/("""</p>
  </blockquote>

  <h2>Why do you see this page?</h2>

    <p>
      The <code>conf/routes</code> file defines a route that tells Play to invoke the <code>HomeController.index</code> action
      whenever a browser requests the <code>/</code> URI using the GET method:
    </p>

    <pre><code># Home page
GET     /               controllers.HomeController.index</code></pre>

    <p>
      Play has invoked the <code>controllers.HomeController.index</code> method to obtain the <code>Action</code> to execute:
    </p>

    <pre><code>def index = Action """),format.raw/*40.35*/("""{"""),format.raw/*40.36*/(""" """),format.raw/*40.37*/("""implicit request: Request[AnyContent] =>
  Ok(views.html.index("Your new application is ready!"))
"""),format.raw/*42.1*/("""}"""),format.raw/*42.2*/("""</code></pre>

    <p>
      An action is a function that handles the incoming HTTP request, and returns the HTTP result to send back to the web client.
      Here we send a <code>200 OK</code> response, using a template to fill its content.
    </p>

    <p>
      The template is defined in the <code>app/views/index.scala.html</code> file and compiled as a Scala function.
    </p>

    <pre><code>@(message: String)

@main("Welcome to Play") """),format.raw/*55.27*/("""{"""),format.raw/*55.28*/("""

    """),format.raw/*57.5*/("""@welcome(message)

"""),format.raw/*59.1*/("""}"""),format.raw/*59.2*/("""</code></pre>

    <p>
      The first line of the template defines the function signature. Here it just takes a single <code>String</code> parameter.
      This template then calls another function defined in <code>app/views/main.scala.html</code>, which displays the HTML
      layout, and another function that displays this welcome message. You can freely add any HTML fragment mixed with Scala
      code in this file.
    </p>

    <p>You can read more about <a href="https://www.playframework.com/documentation/"""),_display_(/*68.86*/version),format.raw/*68.93*/("""/ScalaTemplates">Twirl</a>, the template language used by Play, and how Play handles <a href="https://www.playframework.com/documentation/"""),_display_(/*68.232*/version),format.raw/*68.239*/("""/ScalaActions">actions</a>.</p>

    <h2>Async Controller</h2>

    Now that you've seen how Play renders a page, take a look at <code>AsyncController.scala</code>, which shows how to do asynchronous programming when handling a request.  The code is almost exactly the same as <code>ProductController.scala</code>, but instead of returning <code>Result</code>, the action returns <code>Future[Result]</code> to Play.  When the execution completes, Play can use a thread to render the result without blocking the thread in the mean time.

    <p>
        <a href=""""),_display_(/*75.19*/routes/*75.25*/.AsyncController.message),format.raw/*75.49*/("""">Click here for the AsyncController action!</a>
    </p>

    <p>
        You can read more about <a href="https://www.playframework.com/documentation/"""),_display_(/*79.87*/version),format.raw/*79.94*/("""/ScalaAsync">asynchronous actions</a> in the documentation.
    </p>

    <h2>Count Controller</h2>

    <p>
        Both the HomeController and AsyncController are very simple, and typically controllers present the results of the interaction of several services.  As an example, see the <code>CountController</code>, which shows how to inject a component into a controller and use the component when handling requests.  The count controller increments every time you click on it, so keep clicking to see the numbers go up.
    </p>

    <p>
        <a href=""""),_display_(/*89.19*/routes/*89.25*/.CountController.count),format.raw/*89.47*/("""">Click here for the CountController action!</a>
    </p>

    <p>
        You can read more about <a href="https://www.playframework.com/documentation/"""),_display_(/*93.87*/version),format.raw/*93.94*/("""/ScalaDependencyInjection">dependency injection</a> in the documentation.
    </p>

    <h2>Need more info on the console?</h2>

  <p>
    For more information on the various commands you can run on Play, i.e. running tests and packaging applications for production, see <a href="https://playframework.com/documentation/"""),_display_(/*99.187*/version),format.raw/*99.194*/("""/PlayConsole">Using the Play console</a>.
  </p>

  <h2>Need to set up an IDE?</h2>

  <p>
      You can start hacking your application right now using any text editor. Any changes will be automatically reloaded at each page refresh,
      including modifications made to Scala source files.
  </p>

  <p>
      If you want to set-up your application in <strong>IntelliJ IDEA</strong> or any other Java IDE, check the
      <a href="https://www.playframework.com/documentation/"""),_display_(/*111.61*/version),format.raw/*111.68*/("""/IDE">Setting up your preferred IDE</a> page.
  </p>

  <h2>Need more documentation?</h2>

  <p>
    Play documentation is available at <a href="https://www.playframework.com/documentation/"""),_display_(/*117.94*/version),format.raw/*117.101*/("""">https://www.playframework.com/documentation</a>.
  </p>

  <p>
    Play comes with lots of example templates showcasing various bits of Play functionality at <a href="https://www.playframework.com/download#examples">https://www.playframework.com/download#examples</a>.
  </p>

  <h2>Need more help?</h2>

  <p>
    Play questions are asked and answered on Stackoverflow using the "playframework" tag: <a href="https://stackoverflow.com/questions/tagged/playframework">https://stackoverflow.com/questions/tagged/playframework</a>
  </p>

  <p>
    The <a href="https://groups.google.com/group/play-framework">Play Google Group</a> is where Play users come to seek help,
    announce projects, and discuss issues and new features. If you don’t have a Google account, you can still join the mailing
    list by sending an e-mail to
    <strong>play-framework+subscribe@googlegroups.com</strong>.
  </p>

  <p>
    Gitter is a real time chat channel, like IRC. The <a href="https://gitter.im/playframework/playframework">playframework/playframework</a>  channel is used by Play users to discuss the ins and outs of writing great Play applications.
  </p>

</article>

<aside>
  <h3>Browse</h3>
  <ul>
    <li><a href="https://playframework.com/documentation/"""),_display_(/*146.59*/version),format.raw/*146.66*/("""">Documentation</a></li>
    <li><a href="https://playframework.com/documentation/"""),_display_(/*147.59*/version),format.raw/*147.66*/("""/api/"""),_display_(/*147.72*/style),format.raw/*147.77*/("""/index.html">Browse the """),_display_(/*147.102*/{style.capitalize}),format.raw/*147.120*/(""" """),format.raw/*147.121*/("""API</a></li>
  </ul>
  <h3>Start here</h3>
  <ul>
    <li><a href="https://playframework.com/documentation/"""),_display_(/*151.59*/version),format.raw/*151.66*/("""/PlayConsole">Using the Play console</a></li>
    <li><a href="https://playframework.com/documentation/"""),_display_(/*152.59*/version),format.raw/*152.66*/("""/IDE">Setting up your preferred IDE</a></li>
    <li><a href="https://playframework.com/download#examples">Example Projects</a>
  </ul>
  <h3>Help here</h3>
  <ul>
    <li><a href="https://stackoverflow.com/questions/tagged/playframework">Stack Overflow</a></li>
    <li><a href="https://groups.google.com/group/play-framework">Mailing List</a></li>
    <li><a href="https://gitter.im/playframework/playframework">Gitter Channel</a></li>
  </ul>

</aside>

</div>
""")))}),format.raw/*165.2*/("""
"""))
      }
    }
  }

  def render(message:String,style:String): play.twirl.api.HtmlFormat.Appendable = apply(message,style)

  def f:((String,String) => play.twirl.api.HtmlFormat.Appendable) = (message,style) => apply(message,style)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2021-06-06T17:21:01.906
                  SOURCE: /home/jakubzol/projects/ebiznes-master/ebiznes2021/backend-scala/app/views/welcome.scala.html
                  HASH: 7dafefdfbb0469b2764123c5df38370bcfad92a4
                  MATRIX: 738->1|874->44|901->46|948->85|998->98|1026->100|1153->201|1180->208|1214->216|1241->223|1553->508|1581->515|1613->520|2201->1080|2230->1081|2259->1082|2384->1180|2412->1181|2886->1629|2915->1630|2948->1636|2994->1656|3022->1657|3568->2176|3596->2183|3763->2322|3792->2329|4383->2893|4398->2899|4443->2923|4623->3076|4651->3083|5238->3643|5253->3649|5296->3671|5476->3824|5504->3831|5853->4152|5882->4159|6388->4637|6417->4644|6635->4834|6665->4841|7950->6099|7979->6106|8090->6189|8119->6196|8153->6202|8180->6207|8234->6232|8275->6250|8306->6251|8442->6359|8471->6366|8603->6470|8632->6477|9128->6942
                  LINES: 21->1|26->2|27->3|27->3|27->3|29->5|31->7|31->7|31->7|31->7|46->22|46->22|47->23|64->40|64->40|64->40|66->42|66->42|79->55|79->55|81->57|83->59|83->59|92->68|92->68|92->68|92->68|99->75|99->75|99->75|103->79|103->79|113->89|113->89|113->89|117->93|117->93|123->99|123->99|135->111|135->111|141->117|141->117|170->146|170->146|171->147|171->147|171->147|171->147|171->147|171->147|171->147|175->151|175->151|176->152|176->152|189->165
                  -- GENERATED --
              */
          