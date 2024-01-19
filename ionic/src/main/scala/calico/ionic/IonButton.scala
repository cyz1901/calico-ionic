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
