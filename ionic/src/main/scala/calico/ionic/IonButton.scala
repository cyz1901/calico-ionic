package calico.ionic

import calico.html.Prop
import cats.effect.kernel.Async

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

opaque type HTMLIonButtonElement[F[_]] <: fs2.dom.HtmlElement[F] = fs2.dom.HtmlElement[F]
object HTMLIonButtonElement:
  extension [F[_]](button: HTMLIonButtonElement[F])
    def label: Prop[F, String, String] = Prop("label", identity)

  @js.native
  @JSImport("@ionic/core/components/ion-button.js")
  private[ionic] def use: Any = js.native

private trait IonButton[F[_]](using F: Async[F]):
  lazy val ionButton: IonicTag[F, HTMLIonButtonElement[F]] =
    HTMLIonButtonElement.use
    IonicTag("ion-button")
