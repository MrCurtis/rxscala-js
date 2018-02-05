package rxscalajs.facade

import scala.scalajs.js
import js.annotation._

@js.native
trait HotObservableFacade[T] extends SubjectFacade[T] {
  def setup(): Unit = js.native
}
