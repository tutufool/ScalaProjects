package sample.json

import org.json4s._
import org.json4s.jackson.JsonMethods._

/**
 * Created by leon on 14-2-24.
 */
object JacksonParse extends App{

  val value1 = parse(""" {"numbers":[1,2,3,4]}""" )

  println(value1)

  val value2 = parse("""{"name":"Toy","price":35.35}""", useBigDecimalForDouble = true)

  println(value2)


  implicit val formats = DefaultFormats // Brings in default date formats etc.

  case class Child(name: String, age: Int, birthdate: Option[java.util.Date])
  case class Address(street: String, city: String)
  case class Person(name: String, address: Address, children: List[Child])

  val json = parse( """
         { "name": "joe",
           "address": {
             "street": "Bulevard",
             "city": "Helsinki"
           },
           "children": [
             {
               "name": "Mary",
               "age": 5,
               "birthdate": "2004-09-04T18:06:22Z"
             },
             {
               "name": "Mazy",
               "age": 3
             }
           ]
         }
                    """)


  val person = json.extract[Person]
  println(person)

  case class PersonWithAddresses(name: String, addresses: Map[String, Address])
  val json2 = parse("""
         {
           "name": "joe",
           "addresses": {
             "address1": {
               "street": "Bulevard",
               "city": "Helsinki"
             },
             "address2": {
               "street": "Soho",
               "city": "London"
             }
           }
         }""")

  val personWithAddress = json2.extract[PersonWithAddresses]
  println(personWithAddress)





}
