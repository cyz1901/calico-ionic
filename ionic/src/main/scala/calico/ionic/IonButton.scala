package calico.ionic

import cats.effect.kernel.Async

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import org.scalajs.dom

opaque type HTMLIonButtonElement[F[_]] <: fs2.dom.HtmlElement[F] = fs2.dom.HtmlElement[F]
object HTMLIonButtonElement:
  @js.native
  @JSImport("@ionic/core/components/ion-button.js", "IonButton")
  private[ionic] def use: dom.HTMLElement = js.native

private trait IonButton[F[_]](using F: Async[F]):
  lazy val ionButton: IonicTag[F, HTMLIonButtonElement[F]] =
    dom.window.customElements
      .define(
        "ion-button",
        HTMLIonButtonElement.use.asInstanceOf[js.Dynamic],
      )
    HTMLIonButtonElement.use
    IonicTag("ion-button")
