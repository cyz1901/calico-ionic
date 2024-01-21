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
import calico.ionic.scalablyTyped.ionicCore.ionicCoreStrings.ionRender

@js.native
@JSImport("styles/index.css", JSImport.Default)
object IndexCss extends js.Object

class PageOne extends dom.HTMLElement {
  def connectedCallback() =
    ionContent { _ =>
      "PageOne"
    }
}

object Demo extends IOWebApp {
  val indexCss: IndexCss.type = IndexCss

  def render =
    IO(
      IonicUI.initialize(),
      org.scalajs.dom.window.customElements
        .define("page-one", js.constructorOf[PageOne]),
    ).toResource >> ionApp(_ =>
      (
        ionRouter(_ => ()).evalTap(
          _.innerHtml.set(
            """
          <ion-route url="/root" component="page-one"></ion-route>
          """,
          ),
        ),
        ionRouterOutlet(_ => ""),
      ),
    )

}
