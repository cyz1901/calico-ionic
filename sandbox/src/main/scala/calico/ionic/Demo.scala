/*
 * Copyright 2024 cyz1901
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package calico
package ionic

import calico.html.io.{*, given}
import calico.ionic.io.*
import cats.effect.*
import cats.syntax.all.*

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import org.scalajs.dom
import calico.ionic.scalablyTyped.ionicCore.ionicCoreStrings.ios
import calico.ionic.scalablyTyped.ionicCore.ionicCoreStrings.md

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
        ionHeader(h => ("jjj", h.mode := md)),
        ionButton { cb =>
          (
            "wohu",
            cb.disabled := false,
            cb.expand := "full",
            onClick --> {
              _.foreach(_ =>
                IO {
                  val n = dom.document.querySelector("ion-modal")
                  n.asInstanceOf[js.Dynamic].updateDynamic("isOpen")(true)
                  println(n.asInstanceOf[js.Dynamic].selectDynamic("isOpen"))
                },
              )
            },
          )
        },
        ionModal(m => "mama"),
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
