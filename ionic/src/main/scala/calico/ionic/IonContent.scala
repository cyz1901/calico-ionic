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

opaque type HTMLIonContentElement[F[_]] <: fs2.dom.HtmlElement[F] = fs2.dom.HtmlElement[F]
object HTMLIonContentElement:
  extension [F[_]](ionContent: HTMLIonContentElement[F])
    def color: Prop[F, js.UndefOr[Color], js.UndefOr[Color]] =
      Prop("color", identity)

    def forceOverscroll: Prop[F, js.UndefOr[Boolean], js.UndefOr[Boolean]] =
      Prop("force-overscroll", identity)

    def fullscreen: Prop[F, Boolean, Boolean] =
      Prop("fullscreen", identity)

    def scrollEvents: Prop[F, Boolean, Boolean] =
      Prop("scroll-events", identity)

    def scrollX: Prop[F, Boolean, Boolean] =
      Prop("scroll-x", identity)

    def scrollY: Prop[F, Boolean, Boolean] =
      Prop("scroll-y", identity)

@js.native
@JSImport("@ionic/core/components/ion-content.js", "IonContent")
private[ionic] class IonContentElement
    extends dom.HTMLElement
    with calico.ionic.scalablyTyped.ionicCore.distTypesComponentsMod.Components.IonContent

private trait IonContent[F[_]](using F: Async[F]):
  lazy val ionContent: IonicTag[F, HTMLIonContentElement[F]] =
    dom.window.customElements
      .define(
        "ion-content",
        js.constructorOf[IonContentElement],
      )
    new IonContentElement()
    IonicTag("ion-content")
