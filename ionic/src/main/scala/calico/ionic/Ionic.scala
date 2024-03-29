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

import cats.effect.IO
import cats.effect.kernel.Async
import org.scalajs.dom

object io extends Ionic[IO] {

  def initialize(): Unit =
    dom.document.documentElement.classList.add("ion-ce")
    IonicGlobal.initialize()
}

sealed class Ionic[F[_]](using Async[F])
    extends IonButton[F],
      IonButtons[F],
      IonSegmentButton[F],
      IonSegment[F],
      IonToolbar[F],
      IonTitle[F],
      IonRoute[F],
      IonRouter[F],
      IonRouterOutlet[F],
      IonModal[F],
      IonHeader[F],
      IonContent[F],
      IonNav[F],
      IonApp[F]
