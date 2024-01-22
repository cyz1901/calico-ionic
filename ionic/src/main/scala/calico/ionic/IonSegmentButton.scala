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
import calico.ionic.scalablyTyped.ionicCore.ionicCoreStrings.large
import calico.ionic.scalablyTyped.ionicCore.ionicCoreStrings.small
import calico.ionic.scalablyTyped.ionicCore.ionicCoreStrings.ios
import calico.ionic.scalablyTyped.ionicCore.ionicCoreStrings.md
import calico.ionic.scalablyTyped.ionicCore.ionicCoreStrings.button
import calico.ionic.scalablyTyped.ionicCore.ionicCoreStrings.reset
import calico.ionic.scalablyTyped.ionicCore.ionicCoreStrings.submit
import calico.ionic.scalablyTyped.ionicCore.distTypesComponentsSegmentSegmentInterfaceMod.SegmentValue
import calico.ionic.scalablyTyped.ionicCore.distTypesComponentsSegmentButtonSegmentButtonInterfaceMod.SegmentButtonLayout
import scala.scalajs.js.Promise

opaque type HTMLIonSegmentButtonElement[F[_]] <: fs2.dom.HtmlElement[F] = fs2.dom.HtmlElement[F]
object HTMLIonSegmentButtonElement:
  extension [F[_]](ionSegmentButton: HTMLIonSegmentButtonElement[F])
    def layout: Prop[F, js.UndefOr[SegmentButtonLayout], js.UndefOr[SegmentButtonLayout]] =
      Prop("layout", identity)

    def disabled: Prop[F, Boolean, Boolean] = Prop("disabled", identity)

    def mode: Prop[F, js.UndefOr[ios | md], js.UndefOr[ios | md]] = Prop("mode", identity)

    def `type`: Prop[F, submit | reset | button, submit | reset | button] =
      Prop("scrollable", identity)

    def value: Prop[F, SegmentValue, SegmentValue] =
      Prop("value", identity)

@js.native
@JSImport("@ionic/core/components/ion-segment-button.js", "IonSegmentButton")
private[ionic] class IonSegmentButtonElement
    extends dom.HTMLElement
    with calico.ionic.scalablyTyped.ionicCore.distTypesComponentsMod.Components.IonSegmentButton {

  def setFocus(): Promise[Unit] = js.native

  var disabled: Boolean = js.native

  var value: SegmentValue = js.native

  var `type`: submit | reset | button = js.native

}

private trait IonSegmentButton[F[_]](using F: Async[F]):
  lazy val ionSegmentButton: IonicTag[F, HTMLIonSegmentButtonElement[F]] =
    dom.window.customElements
      .define(
        "ion-segment-button",
        js.constructorOf[IonSegmentButtonElement],
      )
    new IonSegmentButtonElement()
    IonicTag("ion-segment-button")
