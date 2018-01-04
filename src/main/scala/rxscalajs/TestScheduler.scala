package rxscalajs

import scala.scalajs.js
import js.annotation._
import js.|

import rxscalajs.subscription.Subscription


@js.native
@JSGlobal("Rx.HotObservable")
class HotObservable extends js.Object {
  def subscribe[T](observerOrNext: T=>Unit): Subscription = js.native
}

@js.native
@JSGlobal("Rx.TestScheduler")
class TestScheduler extends js.Object {
  def createHotObservable[T](marbles: String): HotObservable = js.native
}
