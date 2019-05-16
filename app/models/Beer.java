package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.bson.types.ObjectId;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;
import play.api.Play;
import uk.co.panaxiom.playjongo.PlayJongo;

import java.util.UUID;

public class Beer {
    public static PlayJongo jongo = Play.current().injector().instanceOf(PlayJongo.class);

    public static MongoCollection beers() {
        return jongo.getCollection("beers");
    }

    @JsonProperty("_id")
    public String id;
    public String name;

    public boolean insert() {
        id = UUID.randomUUID().toString();
        return beers().save(this).getN() > 0;
    }

    public boolean remove() {
        return beers().remove(this.id).getN() > 0;
    }

    public static MongoCursor<Beer> findAll() {
        return beers().find().as(Beer.class);
    }

    public static Beer findByName(String name) {
        return beers().findOne("{name: #}", name).as(Beer.class);
    }
}
