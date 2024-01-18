package calico.ionic

import calico.html.Prop
import cats.effect.kernel.Async

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import org.scalajs.dom

opaque type HTMLIonRouteElement[F[_]] <: fs2.dom.HtmlElement[F] = fs2.dom.HtmlElement[F]
object HTMLIonRouteElement:
  extension [F[_]](ionRoute: HTMLIonRouteElement[F])
    def url: Prop[F, String, String] = Prop("url", identity)

@js.native
@JSImport("@ionic/core/components/ion-route.js", "IonRoute")
private[ionic] class IonRouteElement extends dom.HTMLElement

private trait IonRoute[F[_]](using F: Async[F]):
  lazy val ionRoute: IonicTag[F, HTMLIonRouteElement[F]] =
    dom.window.customElements
      .define(
        "ion-route",
        js.constructorOf[IonRouteElement],
      )
    new IonRouteElement()
    IonicTag("ion-route")
