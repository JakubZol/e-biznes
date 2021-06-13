package models

import play.api.libs.json.Json

case class Sweatband (id: Long, name: String, productType: String, brand: String, price: BigDecimal)

object Sweatband {
  implicit val catFormat = Json.format[Sweatband]
}