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
