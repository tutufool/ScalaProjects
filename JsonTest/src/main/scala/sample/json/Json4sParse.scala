package sample.json

import org.json4s.native.JsonParser._


/**
 * Created by leon on 14-2-25.
 */
object Json4sParse extends App{
  val json3 = """{
    "firstName": "John",
    "lastName": "Smith",
    "address": {
      "streetAddress": "21 2nd Street",
      "city": "New York",
      "state": "NY",
      "postalCode": 10021
    },
    "phoneNumbers": [
      { "type": "home", "number": "212 555-1234" },
      { "type": "fax", "number": "646 555-4567" }
    ],
  }"""

  val parser = (p: Parser) => {
    def parse: BigInt = p.nextToken match {
      case FieldStart("postalCode") => p.nextToken match {
        case IntVal(code) => code
        case _ => p.fail("expected int")
      }
      case End => p.fail("no field named 'postalCode'")
      case _ => parse
    }

    parse
  }

  val postalCode = parse(json3, parser)

  println(postalCode)
}
