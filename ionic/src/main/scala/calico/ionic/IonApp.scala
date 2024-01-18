package calico.ionic

import calico.html.Prop
import cats.effect.kernel.Async

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import org.scalajs.dom

opaque type HTMLIonAppElement[F[_]] <: fs2.dom.HtmlElement[F] = fs2.dom.HtmlElement[F]
object HTMLIonAppElement:
  extension [F[_]](ionApp: HTMLIonAppElement[F])
    def url: Prop[F, String, String] = Prop("url", identity)

@js.native
@JSImport("@ionic/core/components/ion-app.js", "IonApp")
private[ionic] class IonAppElement extends dom.HTMLElement

private trait IonApp[F[_]](using F: Async[F]):
  lazy val ionApp: IonicTag[F, HTMLIonAppElement[F]] =
    dom.window.customElements
      .define(
        "ion-app",
        js.constructorOf[IonAppElement],
      )
    new IonAppElement()
    IonicTag("ion-app")
