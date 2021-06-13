package models

import play.api.libs.json.Json

case class Ball (id: Long, name: String, productType: String, brand: String, price: BigDecimal)

object Ball {
  implicit val catFormat = Json.format[Ball]
}