package models

import play.api.libs.json.Json

case class Gloves (id: Long, name: String, productType: String, size: String, brand: String, price: BigDecimal)

object Gloves {
  implicit val catFormat = Json.format[Gloves]
}