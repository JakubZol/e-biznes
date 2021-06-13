package models

import play.api.libs.json.Json

case class Hat (id: Long, name: String, productType: String, brand: String, price: BigDecimal)

object Hat {
  implicit val catFormat = Json.format[Hat]
}