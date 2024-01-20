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

import cats.effect.kernel.Async

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import org.scalajs.dom
import calico.html.Prop

opaque type HTMLIonNavElement[F[_]] <: fs2.dom.HtmlElement[F] = fs2.dom.HtmlElement[F]
object HTMLIonNavElement:
  extension [F[_]](ionNav: HTMLIonNavElement[F])
    def animated: Prop[F, Boolean, Boolean] = Prop("animated", identity)

    def animation: Prop[F, js.Dynamic, js.Dynamic] = Prop("animation", identity)

@js.native
@JSImport("@ionic/core/components/ion-nav.js", "IonNav")
private[ionic] class IonNavElement extends dom.HTMLElement

private trait IonNav[F[_]](using F: Async[F]):
  lazy val ionNav: IonicTag[F, HTMLIonNavElement[F]] =
    dom.window.customElements
      .define(
        "ion-nav",
        js.constructorOf[IonNavElement],
      )
    new IonNavElement()
    IonicTag("ion-nav")
