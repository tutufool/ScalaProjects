package fractal.sample

import org.scalatest._

class SimpleAppTest extends FlatSpec with Matchers {

  "The Answer" should "always be 42" in {
    SimpleApp.theAnswer should be (42)
  }

}
