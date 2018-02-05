package rxscalajs

import utest._

import rxscalajs.facade.{GroupedObservableFacade, ObservableFacade, SubjectFacade}
import rxscalajs.facade.HotObservableFacade


object HotObservableTest extends TestSuite {
  def tests = TestSuite {
    'FacadeTests {
      val cw = new TestScheduler((x, y) => {assert(false); x == y})
      val hotOb = cw.createHotObservable("1-2-3-4")
      hotOb.asObservable()
      val eO = cw.expectObservable(hotOb)
      cw.flush()
      assert(false)
    }
  }
}
