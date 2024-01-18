package calico.ionic

import org.scalajs.dom

object IonicUI {

  def initialize(): Unit =
    dom.document.documentElement.classList.add("ion-ce")
    IonicGlobal.initialize()
}
