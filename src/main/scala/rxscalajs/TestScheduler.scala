package rxscalajs

import scala.scalajs.js
import js.annotation._
import js.|


@js.native
@JSGlobal("Rx.HotObservable")
class HotObservable extends js.Object {
}

@js.native
@JSGlobal("Rx.TestScheduler")
class TestScheduler extends js.Object {
  def createHotObservable[T](marbles: String): HotObservable = js.native
}
