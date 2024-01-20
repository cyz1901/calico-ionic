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

import org.scalajs.dom
import calico.html.Prop

import org.scalablytyped.runtime.StringDictionary
import org.scalajs.dom.HTMLElement
import calico.ionic.scalablyTyped.ionicCore.distTypesComponentsMod.global.HTMLIonModalElement
import calico.ionic.scalablyTyped.ionicCore.distTypesComponentsModalModalInterfaceMod.ModalBreakpointChangeEventDetail
import calico.ionic.scalablyTyped.ionicCore.distTypesComponentsModalModalInterfaceMod.ModalHandleBehavior
import calico.ionic.scalablyTyped.ionicCore.distTypesStencilPublicRuntimeMod.ComponentInterface
import calico.ionic.scalablyTyped.ionicCore.distTypesStencilPublicRuntimeMod.EventEmitter
import calico.ionic.scalablyTyped.ionicCore.distTypesUtilsAnimationAnimationInterfaceMod.Animation
import calico.ionic.scalablyTyped.ionicCore.distTypesUtilsOverlaysInterfaceMod.OverlayEventDetail
import calico.ionic.scalablyTyped.ionicCore.distTypesUtilsOverlaysInterfaceMod.OverlayInterface
import calico.ionic.scalablyTyped.ionicCore.mod.ComponentProps
import calico.ionic.scalablyTyped.ionicCore.mod.ComponentRef
import calico.ionic.scalablyTyped.ionicCore.mod.FrameworkDelegate
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSImport, JSName}

opaque type HtmlLIonModalElement[F[_]] <: fs2.dom.HtmlElement[F] = fs2.dom.HtmlElement[F]
object HtmlLIonModalElement:
  extension [F[_]](ionModal: HtmlLIonModalElement[F])
    def animated: Prop[F, Boolean, Boolean] = Prop("animated", identity)

    def backdropBreakpoint: Prop[F, Int, Int] = Prop("backdrop-breakpoint", identity)

    def backdropDismiss: Prop[F, Boolean, Boolean] = Prop("backdrop-dismiss", identity)

@js.native
@JSImport("@ionic/core/components/ion-modal.js", "IonModal")
private[ionic] class IonModalElement
    extends dom.HTMLElement
    with calico.ionic.scalablyTyped.ionicCore.distTypesComponentsMod.Components.IonModal

private trait IonModal[F[_]](using F: Async[F]):
  lazy val ionModal: IonicTag[F, HtmlLIonModalElement[F]] =
    dom.window.customElements
      .define(
        "ion-modal",
        js.constructorOf[IonModalElement],
      )
    new IonModalElement()
    IonicTag("ion-modal")
