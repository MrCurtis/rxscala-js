package rxscalajs

import utest._

import rxscalajs.facade.{GroupedObservableFacade, ObservableFacade, SubjectFacade}
import rxscalajs.facade.HotObservableFacade


object HotObservableTest extends TestSuite {
  def tests = TestSuite {
    'FacadeTests {
      val cw = new TestScheduler((x,y) => {if (x != y) assert(false) else assert(true)} )
      val hotOb = cw.createHotObservable("1-2-3-4")
      hotOb.asObservable()
      val eO = cw.expectObservable(hotOb).toBe("1-4-5")
      cw.flush()
    }
  }
}
