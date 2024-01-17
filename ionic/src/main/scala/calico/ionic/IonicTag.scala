package calico.ionic

import calico.html.Modifier
import cats.effect.kernel.Async
import cats.effect.kernel.Resource
import cats.effect.syntax.all.*
import cats.syntax.all.*
import org.scalajs.dom
import shapeless3.deriving.K0

final class IonicTag[F[_], E] private[ionic] (name: String)(using F: Async[F]):

  def apply[M](mkModifier: E => M)(using M: Modifier[F, E, M]): Resource[F, E] =
    build.toResource.flatTap(e => M.modify(mkModifier(e), e))

  def apply[M <: Tuple](
      mkModifiers: E => M,
  )(using inst: K0.ProductInstances[Modifier[F, E, _], M]): Resource[F, E] =
    build.toResource.flatTap { e =>
      inst.foldLeft(mkModifiers(e))(Resource.pure(e)) {
        [a] => (r: Resource[F, E], m: Modifier[F, E, a], a: a) => r.flatTap(m.modify(a, _))
      }
    }

  private def build = F.delay(dom.document.createElement(name).asInstanceOf[E])
