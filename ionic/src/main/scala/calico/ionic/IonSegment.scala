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
import calico.ionic.scalablyTyped.ionicCore.distTypesComponentsSegmentSegmentInterfaceMod.SegmentValue

opaque type HTMLIonSegmentElement[F[_]] <: fs2.dom.HtmlElement[F] = fs2.dom.HtmlElement[F]
object HTMLIonSegmentElement:
  extension [F[_]](ionSegment: HTMLIonSegmentElement[F])
    def color: Prop[F, js.UndefOr[Color], js.UndefOr[Color]] = Prop("color", identity)

    def disabled: Prop[F, Boolean, Boolean] = Prop("disabled", identity)

    def mode: Prop[F, js.UndefOr[ios | md], js.UndefOr[ios | md]] = Prop("mode", identity)

    def scrollable: Prop[F, Boolean, Boolean] = Prop("scrollable", identity)

    def selectOnFocus: Prop[F, Boolean, Boolean] = Prop("select-on-focus", identity)

    def swipeGesture: Prop[F, Boolean, Boolean] = Prop("swipe-gesture", identity)

    def value: Prop[F, js.UndefOr[SegmentValue], js.UndefOr[SegmentValue]] =
      Prop("value", identity)

@js.native
@JSImport("@ionic/core/components/ion-segment.js", "IonSegment")
private[ionic] class IonSegmentElement
    extends dom.HTMLElement
    with calico.ionic.scalablyTyped.ionicCore.distTypesComponentsMod.Components.IonSegment {

  var disabled: Boolean = js.native

  var scrollable: Boolean = js.native

  var selectOnFocus: Boolean = js.native

  var swipeGesture: Boolean = js.native

}

private trait IonSegment[F[_]](using F: Async[F]):
  lazy val ionSegment: IonicTag[F, HTMLIonSegmentElement[F]] =
    dom.window.customElements
      .define(
        "ion-segment",
        js.constructorOf[IonSegmentElement],
      )
    new IonSegmentElement()
    IonicTag("ion-segment")
