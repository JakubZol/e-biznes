package models

import play.api.libs.json.Json

case class Trousers (id: Long, name: String, productType: String, size: String, brand: String, price: BigDecimal)

object Trousers {
  implicit val catFormat = Json.format[Trousers]
}