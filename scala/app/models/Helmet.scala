package models

import play.api.libs.json.Json

case class Helmet (id: Long, name: String, productType: String, size: String, brand: String, price: BigDecimal)

object Helmet {
  implicit val catFormat = Json.format[Helmet]
}