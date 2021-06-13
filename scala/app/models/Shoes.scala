package models

import play.api.libs.json.Json

case class Shoes (id: Long, name: String, productType: String, size: Int, brand: String, price: BigDecimal)

object Shoes {
  implicit val catFormat = Json.format[Shoes]
}