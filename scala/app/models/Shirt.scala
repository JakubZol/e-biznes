package models

import play.api.libs.json.Json

case class Shirt (id: Long, name: String, productType: String, size: String, brand: String, price: BigDecimal)

object Shirt {
  implicit val catFormat = Json.format[Shirt]
}