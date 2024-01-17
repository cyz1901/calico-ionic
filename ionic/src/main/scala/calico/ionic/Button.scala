// /*
//  * Copyright 2023 Arman Bilge
//  *
//  * Licensed under the Apache License, Version 2.0 (the "License");
//  * you may not use this file except in compliance with the License.
//  * You may obtain a copy of the License at
//  *
//  *     http://www.apache.org/licenses/LICENSE-2.0
//  *
//  * Unless required by applicable law or agreed to in writing, software
//  * distributed under the License is distributed on an "AS IS" BASIS,
//  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//  * See the License for the specific language governing permissions and
//  * limitations under the License.
//  */

// package calico.ionic

// import calico.html.Prop
// import cats.effect.kernel.Async

// import scala.scalajs.js
// import scala.scalajs.js.annotation.JSImport

// opaque type Button[F[_]] <: fs2.dom.HtmlElement[F] = fs2.dom.HtmlElement[F]
// object Button:
//   extension [F[_]](button: Button[F])
//     def label: Prop[F, String, String] = Prop("label", identity)

// opaque type FilledButton[F[_]] <: Button[F] = Button[F]
// object FilledButton:
//   @js.native
//   @JSImport("@material/web/button/filled-button.js")
//   private[ionic] def use: Any = js.native

// opaque type OutlinedButton[F[_]] <: Button[F] = Button[F]
// object OutlinedButton:
//   @js.native
//   @JSImport("@material/web/button/outlined-button.js")
//   private[ionic] def use: Any = js.native

// private trait MaterialButton[F[_]](using F: Async[F]):

//   lazy val mdFilledButton: MdTag[F, FilledButton[F]] =
//     FilledButton.use
//     MdTag("md-filled-button")

//   lazy val mdOutlinedButton: MdTag[F, OutlinedButton[F]] =
//     OutlinedButton.use
//     MdTag("md-outlined-button")
