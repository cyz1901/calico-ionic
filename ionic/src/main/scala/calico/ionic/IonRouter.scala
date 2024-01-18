package calico.ionic

import cats.effect.kernel.Async

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import org.scalajs.dom

opaque type HTMLIonRouterElement[F[_]] <: fs2.dom.HtmlElement[F] = fs2.dom.HtmlElement[F]
object HTMLIonRouterElement:
  @js.native
  @JSImport("@ionic/core/components/ion-router.js", "IonRouter")
  private[ionic] def use: dom.HTMLElement = js.native

private trait IonRouter[F[_]](using F: Async[F]):
  lazy val ionRouter: IonicTag[F, HTMLIonRouterElement[F]] =
    dom.window.customElements
      .define(
        "ion-router",
        HTMLIonRouterElement.use.asInstanceOf[js.Dynamic],
      )
    HTMLIonRouterElement.use
    IonicTag("ion-router")
