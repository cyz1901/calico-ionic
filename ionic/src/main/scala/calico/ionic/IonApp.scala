// package calico.ionic

// import calico.html.Prop
// import cats.effect.kernel.Async

// import scala.scalajs.js
// import scala.scalajs.js.annotation.JSImport

// opaque type HTMLIonAppElement[F[_]] <: fs2.dom.HtmlElement[F] = fs2.dom.HtmlElement[F]
// object HTMLIonAppElement:
//   @js.native
//   @JSImport("@ionic/core/components/ion-app.js")
//   private[ionic] def use: Any = js.native

// private trait IonApp[F[_]](using F: Async[F]):
//   lazy val mdFilledButton: IonicTag[F, HTMLIonAppElement[F]] =
//     HTMLIonAppElement.use
//     IonicTag("md-filled-button")
