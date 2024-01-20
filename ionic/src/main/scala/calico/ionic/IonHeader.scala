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
import calico.ionic.scalablyTyped.ionicCore.ionicCoreStrings.condense
import calico.ionic.scalablyTyped.ionicCore.ionicCoreStrings.fade
import calico.ionic.scalablyTyped.ionicCore.ionicCoreStrings.ios
import calico.ionic.scalablyTyped.ionicCore.ionicCoreStrings.md

opaque type HTMLIonHeaderElement[F[_]] <: fs2.dom.HtmlElement[F] = fs2.dom.HtmlElement[F]
object HTMLIonHeaderElement:
  extension [F[_]](ionHeader: HTMLIonHeaderElement[F])
    def collapse: Prop[F, js.UndefOr[condense | fade], js.UndefOr[condense | fade]] =
      Prop("collapse", identity)

    def mode: Prop[F, js.UndefOr[ios | md], js.UndefOr[ios | md]] = Prop("mode", identity)

@js.native
@JSImport("@ionic/core/components/ion-header.js", "IonHeader")
private[ionic] class IonHeaderElement
    extends dom.HTMLElement
    with calico.ionic.scalablyTyped.ionicCore.distTypesComponentsMod.Components.IonHeader {

  var translucent: Boolean = js.native

}

private trait IonHeader[F[_]](using F: Async[F]):
  lazy val ionHeader: IonicTag[F, HTMLIonHeaderElement[F]] =
    dom.window.customElements
      .define(
        "ion-header",
        js.constructorOf[IonHeaderElement],
      )
    new IonHeaderElement()
    IonicTag("ion-header")
