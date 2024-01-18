package calico.ionic

import cats.effect.IO
import cats.effect.kernel.Async

object io extends Ionic[IO]

sealed class Ionic[F[_]](using Async[F])
    extends IonButton[F],
      IonRoute[F],
      IonRouter[F],
      IonModal[F],
      IonApp[F]
