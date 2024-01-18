package calico
package ionic

import calico.html.io.{*, given}
import calico.ionic.io.{*, given}
import cats.effect.*
import cats.effect.syntax.all.*
import cats.syntax.all.*

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import org.scalajs.dom.HTMLElement

@js.native
@JSImport("styles/index.css", JSImport.Default)
object IndexCss extends js.Object

object Demo extends IOWebApp {
  val indexCss: IndexCss.type = IndexCss

  def render =
    IO(
      IonicUI.initialize(),
      // org.scalajs.dom.window.customElements
      //   .define("page-one", js.constructorOf[PageOne]),
    ).toResource >>
      div(
        "Ionic",
        ionButton { cb =>
          ("wohu", cb.disabled := true, cb.expand := "full")
        },
        ionRoute(p =>
          (
            p.url := "/",
            p.component := "page-one",
          ),
        ),
      )

    // div(
    //   // ionRouter(cb =>
    //   ionRoute(p =>
    //     (
    //       p.url := "/",
    //       p.component := "page-one",
    //     ),
    //   ),
    //   // ),
    // )

    // div(()).evalTap(
    //   _.innerHtml.set(
    //     """
    //   <ion-router>
    //     <ion-route url="/" component="page-one"></ion-route>
    //   </ion-router>
    //     """,
    //   ),
    // )

    // test two
    // div(
    //   ionRouter(cb =>
    //     ionRoute(p =>
    //       (
    //         p.url := "/",
    //         p.component := "page-one",
    //       ),
    //     ),
    //   ),
    // )

    // test one
    // div(
    //   "Ionic",
    //   ionButton { cb =>
    //     ("wohu", cb.disabled := true)
    //   },
    // )
}

// class PageOne extends HTMLElement {
//   def connectedCallback() =
//     ionButton { cb =>
//       ("PageOne", cb.disabled := false)
//     }
// }
