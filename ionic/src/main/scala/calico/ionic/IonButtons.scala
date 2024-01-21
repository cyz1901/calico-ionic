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

package calico.ionic

import calico.html.Prop
import cats.effect.kernel.Async

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import org.scalajs.dom

opaque type HTMLIonButtonsElement[F[_]] <: fs2.dom.HtmlElement[F] = fs2.dom.HtmlElement[F]
object HTMLIonButtonsElement:
  extension [F[_]](ionButtons: HTMLIonButtonsElement[F])
    def collapse: Prop[F, Boolean, Boolean] = Prop("collapse", identity)

@js.native
@JSImport("@ionic/core/components/ion-buttons.js", "IonButtons")
private[ionic] class IonButtonsElement extends dom.HTMLElement

private trait IonButtons[F[_]](using F: Async[F]):
  lazy val ionButtons: IonicTag[F, HTMLIonButtonsElement[F]] =
    dom.window.customElements
      .define(
        "ion-buttons",
        js.constructorOf[IonButtonsElement],
      )
    new IonButtonsElement()
    IonicTag("ion-buttons")
