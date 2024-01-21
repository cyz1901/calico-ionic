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
import calico.ionic.scalablyTyped.ionicCore.mod.Color
import calico.ionic.scalablyTyped.ionicCore.ionicCoreStrings.ios
import calico.ionic.scalablyTyped.ionicCore.ionicCoreStrings.md

opaque type HTMLIonToolbarElement[F[_]] <: fs2.dom.HtmlElement[F] = fs2.dom.HtmlElement[F]
object HTMLIonToolbarElement:
  extension [F[_]](ionToolbar: HTMLIonToolbarElement[F])
    def color: Prop[F, js.UndefOr[Color], js.UndefOr[Color]] =
      Prop("color", identity)

    def mode: Prop[F, js.UndefOr[ios | md], js.UndefOr[ios | md]] = Prop("mode", identity)

@js.native
@JSImport("@ionic/core/components/ion-toolbar.js", "IonToolbar")
private[ionic] class IonToolbarElement
    extends dom.HTMLElement
    with calico.ionic.scalablyTyped.ionicCore.distTypesComponentsMod.Components.IonToolbar

private trait IonToolbar[F[_]](using F: Async[F]):
  lazy val ionToolbar: IonicTag[F, HTMLIonToolbarElement[F]] =
    dom.window.customElements
      .define(
        "ion-toolbar",
        js.constructorOf[IonToolbarElement],
      )
    new IonToolbarElement()
    IonicTag("ion-toolbar")
