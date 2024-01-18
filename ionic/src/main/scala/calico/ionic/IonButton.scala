package calico.ionic

import calico.html.Prop
import cats.effect.kernel.Async

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import org.scalajs.dom

opaque type HTMLIonButtonElement[F[_]] <: fs2.dom.HtmlElement[F] = fs2.dom.HtmlElement[F]
object HTMLIonButtonElement:
  extension [F[_]](ionButton: HTMLIonButtonElement[F])
    def disabled: Prop[F, Boolean, Boolean] = Prop("disabled", identity)

    def expand: Prop[F, String, String] = Prop("expand", identity)

@js.native
@JSImport("@ionic/core/components/ion-button.js", "IonButton")
private[ionic] class IonButtonElement extends dom.HTMLElement

private trait IonButton[F[_]](using F: Async[F]):
  lazy val ionButton: IonicTag[F, HTMLIonButtonElement[F]] =
    dom.window.customElements
      .define(
        "ion-button",
        js.constructorOf[IonButtonElement],
      )
    new IonButtonElement()
    IonicTag("ion-button")
