package calico
package ionic

import calico.html.io.{*, given}
import calico.ionic.io.{*, given}
import cats.effect.*
import cats.effect.syntax.all.*
import cats.syntax.all.*

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

@js.native
@JSImport("../../../styles/index.css", JSImport.Default)
object IndexCss extends js.Object

@JSImport("@ionic/core", JSImport.Namespace)
@js.native
object IonicCore extends js.Object {}

object Demo extends IOWebApp {
  val indexCss: IndexCss.type = IndexCss

  def render =
    IO(
      IonicCore,
      IonicGlobal.initialize(),
    ).toResource >> div(
      "Ionic",
      ionButton { cb =>
        "Back"
      },
    )
}
