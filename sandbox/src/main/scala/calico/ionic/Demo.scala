package calico
package ionic

import calico.html.io.{*, given}
import calico.ionic.io.{*, given}

object Demo extends IOWebApp:
  def render = div(
    label(
      "Ionic",
      ionButton { cb =>
        cb.label := "Back"
      },
    ),
    // mdOutlinedButton { b =>
    //   b.label := "Back"
    // },
    // mdFilledButton { b =>
    //   b.label := "Next"
    // },
  )
