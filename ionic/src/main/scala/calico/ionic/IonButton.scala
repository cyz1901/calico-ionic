package calico.ionic

import calico.html.Prop
import cats.effect.kernel.Async

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

import org.scalajs.dom

opaque type HTMLIonButtonElement[F[_]] <: fs2.dom.HtmlElement[F] = fs2.dom.HtmlElement[F]
object HTMLIonButtonElement:
  @js.native
  @JSImport("@ionic/core/components/ion-button.js")
  private[ionic] def use: Any = js.native

private trait IonButton[F[_]](using F: Async[F]):
  lazy val ionButton: IonicTag[F, HTMLIonButtonElement[F]] =
    // HTMLIonButtonElement.use
    dom.window.customElements
      .define(
        "ion-button",
        HTMLIonButtonElement.use.asInstanceOf[js.Dynamic],
      )
    IonicTag("ion-button")
