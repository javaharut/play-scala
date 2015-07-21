package models

import play.api.libs.json.Json

/**
 * Created by HARUT1 on 7/18/2015.
 */
case class Cat(name: String)

object Cat {
  implicit val catFormat =  Json.format[Cat]
}