package controllers;

import models.Beer;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class BeerController extends Controller {

    public Result getAll() {
        return ok(Json.toJson(Beer.findAll()));
    }

    public Result add() {
        Beer beer = Json.fromJson(request().body().asJson(), Beer.class);
        return beer.insert() ? ok(Json.toJson(beer)) : badRequest();
    }

    public Result remove() {
        Beer beer = Json.fromJson(request().body().asJson(), Beer.class);
        return beer.remove() ? ok() : notFound();
    }
}
