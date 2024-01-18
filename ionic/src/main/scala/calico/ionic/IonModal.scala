package calico.ionic

import calico.html.Prop
import cats.effect.kernel.Async

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import org.scalajs.dom

opaque type HTMLIonModalElement[F[_]] <: fs2.dom.HtmlElement[F] = fs2.dom.HtmlElement[F]
// object HTMLIonModalElement:
// extension [F[_]](ionModal: HTMLIonModalElement[F])
//   def disabled: Prop[F, Boolean, Boolean] = Prop("disabled", identity)

//   def expand: Prop[F, String, String] = Prop("expand", identity)

@js.native
@JSImport("@ionic/core/components/ion-modal.js", "IonModal")
private[ionic] class IonModalElement extends dom.HTMLElement

private trait IonModal[F[_]](using F: Async[F]):
  lazy val ionModal: IonicTag[F, HTMLIonModalElement[F]] =
    dom.window.customElements
      .define(
        "ion-modal",
        js.constructorOf[IonModalElement],
      )
    new IonModalElement()
    IonicTag("ion-modal")
