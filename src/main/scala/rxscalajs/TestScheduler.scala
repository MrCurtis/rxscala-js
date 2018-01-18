package rxscalajs

import scala.scalajs.js
import js.annotation._
import js.|

import rxscalajs.subscription.Subscription
import rxscalajs.facade.ObservableFacade


@js.native
trait WithObservableToBeFunction extends js.Object {
  def toBe(marbles: String): Unit
}

@js.native
@JSGlobal("Rx.HotObservable")
class HotObservable extends js.Object {
  def subscribe[T](observerOrNext: T=>Unit): Subscription = js.native
}

@js.native
@JSGlobal("Rx.TestScheduler")
class TestScheduler extends js.Object {
  def createHotObservable[T](marbles: T): ObservableFacade[T] = js.native
  def createColdObservable[T](marbles: T): ObservableFacade[T] = js.native
  def expectObservable[T](observable: Observable[T]): WithObservableToBeFunction = js.native
}

