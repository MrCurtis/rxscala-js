package rxscalajs

import scala.scalajs.js
import js.annotation._
import js.|

import rxscalajs.subscription.Subscription
import rxscalajs.facade.{ObservableFacade, SubjectFacade, HotObservableFacade}


@js.native
trait WithObservableToBeFunction extends js.Object {
  def toBe[T](marbles: String, values: js.Dictionary[T] = ???): Unit = js.native
}

@js.native
@JSImport("rxjs/Rx", "TestScheduler", globalFallback = "Rx.TestScheduler")
class TestScheduler(assertDeepEqual: js.Function2[js.Any, js.Any, Boolean|Unit]) extends js.Object {
  def createHotObservable[T](marbles: String, values: js.Dictionary[T] = ???): ObservableFacade[T] = js.native
  def createColdObservable[T](marbles: String, values: js.Dictionary[T] = ???): ObservableFacade[T] = js.native
  def expectObservable[T](observable: ObservableFacade[T]): WithObservableToBeFunction = js.native
  def flush(): Unit = js.native
}

@JSImport("deep-equal", JSImport.Namespace)
@js.native
object DeepEqual extends js.Object {
    def apply(x: js.Any, y: js.Any): Boolean = js.native
}
