package rxscalajs

import scala.scalajs.js
import scala.scalajs.js.JSConverters._
import js.annotation._
import js.|

import rxscalajs.facade.ObservableFacade


@js.native
trait WithObservableToBeFacade extends js.Object {
  def toBe[T](marbles: String, values: js.Dictionary[T] = ???): Unit = js.native
}

class WithObservableToBeFunction(toBeFacade: WithObservableToBeFacade) {
  def toBe[T](marbles: String, values: Map[String,T] = ???): Unit =
    toBeFacade.toBe(marbles, values.toJSDictionary)
}

@js.native
@JSImport("rxjs/Rx", "TestScheduler", globalFallback = "Rx.TestScheduler")
class TestSchedulerFacade(assertDeepEqual: js.Function2[js.Any, js.Any, Boolean|Unit]) extends js.Object {
  def createHotObservable[T](marbles: String, values: js.Dictionary[T] = ???): ObservableFacade[T] = js.native
  def createColdObservable[T](marbles: String, values: js.Dictionary[T] = ???): ObservableFacade[T] = js.native
  def expectObservable[T](observable: ObservableFacade[T]): WithObservableToBeFacade = js.native
  def flush(): Unit = js.native
}

@JSImport("deep-equal", JSImport.Namespace)
@js.native
object DeepEqual extends js.Object {
    def apply(x: js.Any, y: js.Any): Boolean = js.native
}

class TestScheduler(assertDeepEqual: js.Function2[js.Any, js.Any, Boolean|Unit]) {
  val tsFacade = new TestSchedulerFacade((x,y) => assertDeepEqual(x,y))
  def createHotObservable[T](marbles: String, values: Map[String, T] = ???): Observable[T] =
    new Observable(tsFacade.createHotObservable(marbles, values.toJSDictionary))
  def createColdObservable[T](marbles: String, values: Map[String, T] = ???): Observable[T] =
    new Observable(tsFacade.createColdObservable(marbles, values.toJSDictionary))
  def expectObservable[T](observable: Observable[T]): WithObservableToBeFunction =
    new WithObservableToBeFunction(tsFacade.expectObservable(observable.inner))
  def flush(): Unit = tsFacade.flush()
}

object TestScheduler {
  def apply(assertDeepEqual: js.Function2[js.Any, js.Any, Boolean|Unit]) = new TestScheduler(assertDeepEqual)
}
