package rxscalajs

import scala.collection.mutable.Map

import utest._

import scala.scalajs.js
import scala.scalajs.js.JSConverters._

case class MyCase(a: Int, b: String)


object TestSchedulerFacadeTest extends TestSuite {
  def tests = TestSuite {
    'FacadeTests {
      val x = MyCase(1, "two")
      val y = MyCase(1, "two")
      val cw = new TestSchedulerFacade((x,y) => assert(DeepEqual(x, y)))
      val hotOb = cw.createHotObservable("1-2", Map("1" -> x, "2" -> x).toJSDictionary)
      val eO = cw.expectObservable(hotOb).toBe("1-2", Map("1" -> y, "2" -> y).toJSDictionary)
      cw.flush()
    }
  }
}
