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
import calico.ionic.scalablyTyped.ionicCore.distTypesComponentsModalModalInterfaceMod.ModalHandleBehavior
import calico.ionic.scalablyTyped.ionicCore.ionicCoreStrings.ios
import calico.ionic.scalablyTyped.ionicCore.ionicCoreStrings.md

opaque type HtmlLIonModalElement[F[_]] <: fs2.dom.HtmlElement[F] = fs2.dom.HtmlElement[F]
object HtmlLIonModalElement:
  extension [F[_]](ionModal: HtmlLIonModalElement[F])
    def animated: Prop[F, Boolean, Boolean] = Prop("animated", identity)

    def backdropBreakpoint: Prop[F, Int, Int] = Prop("backdrop-breakpoint", identity)

    def backdropDismiss: Prop[F, Boolean, Boolean] = Prop("backdrop-dismiss", identity)

    def canDismiss: Prop[
      F,
      Boolean | (js.Function2[js.UndefOr[Any], js.UndefOr[String], js.Promise[Boolean]]),
      Boolean | (js.Function2[js.UndefOr[Any], js.UndefOr[String], js.Promise[Boolean]]),
    ] = Prop("can-dismiss", identity)

    def handle: Prop[F, js.UndefOr[Boolean], js.UndefOr[Boolean]] = Prop("handle", identity)

    def handleBehavior
        : Prop[F, js.UndefOr[ModalHandleBehavior], js.UndefOr[ModalHandleBehavior]] =
      Prop("handle-behavior", identity)

    def initialBreakpoint: Prop[F, js.UndefOr[Double], js.UndefOr[Double]] =
      Prop("initial-breakpoint", identity)

    def isOpen: Prop[F, Boolean, Boolean] = Prop("is-open", identity)

    def keepContentsMounted: Prop[F, Boolean, Boolean] = Prop("keep-contents-mounted", identity)

    def keyboardClose: Prop[F, Boolean, Boolean] = Prop("keyboard-close", identity)

    def mode: Prop[F, js.UndefOr[ios | md], js.UndefOr[ios | md]] = Prop("mode", identity)

    def showBackdrop: Prop[F, Boolean, Boolean] = Prop("show-backdrop", identity)

    def trigger: Prop[F, js.UndefOr[String], js.UndefOr[String]] = Prop("trigger", identity)

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
