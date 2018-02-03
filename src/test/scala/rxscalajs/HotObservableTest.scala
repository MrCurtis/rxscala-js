package rxscalajs

import utest._

import rxscalajs.facade.{GroupedObservableFacade, ObservableFacade, SubjectFacade}
import rxscalajs.facade.HotObservableFacade


object HotObservableTest extends TestSuite {
  def tests = TestSuite {
    'FacadeTests {
      val obs = HotObservableFacade.of(1,11,21,1211,111221)
    }
  }
}
