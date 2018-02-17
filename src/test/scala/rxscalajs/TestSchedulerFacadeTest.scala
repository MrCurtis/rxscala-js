package rxscalajs

import utest._

import scala.scalajs.js
import scala.scalajs.js.JSConverters._

case class MyCase(a: Int, b: String)


object TestSchedulerFacadeTests extends TestSuite {
  def tests = TestSuite {
    'FacadeTests {
      val x = MyCase(1, "two")
      val y = MyCase(1, "two")
      val cw = new TestSchedulerFacade((x,y) => assert(DeepEqual(x, y)))
      val hotOb = cw.createHotObservable("1-2", Map("1" -> x, "2" -> x).toJSDictionary)
      cw.expectObservable(hotOb).toBe("1-2", Map("1" -> y, "2" -> y).toJSDictionary)
      cw.flush()
    }
  }
}


object TestSchedulerTests extends TestSuite {
  def tests = TestSuite {
    "Create TestScheduler and use HotObservable" - {
      val x = MyCase(1, "two")
      val y = MyCase(1, "two")
      val ts = TestScheduler((x,y) => assert(DeepEqual(x, y)))
      val hotOb = ts.createHotObservable("^1-2", Map("1" -> x, "2" -> x))
      ts.expectObservable(hotOb).toBe("-1-2", Map("1" -> y, "2" -> y))
      ts.flush()
    }
    "Create TestScheduler and use ColdObservable" - {
      val x = MyCase(1, "two")
      val y = MyCase(1, "two")
      val ts = TestScheduler((x,y) => assert(DeepEqual(x, y)))
      val coldOb = ts.createColdObservable("1-2", Map("1" -> x, "2" -> x))
      ts.expectObservable(coldOb).toBe("1-2", Map("1" -> y, "2" -> y))
      ts.flush()
    }
    "Raises exception when observables not deep-equal" - {
      val x = MyCase(1, "two")
      val y = MyCase(1, "three")
      val ts = TestScheduler((x,y) => assert(DeepEqual(x, y)))
      val coldOb = ts.createColdObservable("1-2", Map("1" -> x, "2" -> x))
      ts.expectObservable(coldOb).toBe("1-2", Map("1" -> x, "2" -> y))
      val error = intercept[AssertionError] {
        ts.flush()
      }
      assertMatch(error) {
        case AssertionError(_, _, _) =>
      }
    }
  }
}
