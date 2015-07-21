package controllers

import models.{DB, Cat}
import play.api.data.Form
import play.api.data.Forms._
import play.api.libs.json.Json
import play.api.mvc._

class Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready. Harut :P"))
  }

  val catForm: Form[Cat] = Form {
    mapping(
      "name" -> text
    )(Cat.apply)(Cat.unapply)
  }

  def addCat = Action { implicit request =>
    val cat = catForm.bindFromRequest.get
    DB.save(cat)
    Redirect(routes.Application.index())
  }

  def getCats = Action {
    val cats = DB.query[Cat].fetch
    Ok(Json.toJson(cats))
  }

}
