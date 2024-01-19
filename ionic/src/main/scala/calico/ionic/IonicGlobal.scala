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

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

private[ionic] object IonicGlobal {

  @JSImport("@ionic/core/dist/collection/global/ionic-global.js", JSImport.Namespace)
  @js.native
  val ^ : js.Any = js.native

  inline def initialize(): Unit =
    ^.asInstanceOf[js.Dynamic].applyDynamic("initialize")().asInstanceOf[Unit]

}
