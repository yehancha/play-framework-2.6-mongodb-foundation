package models;

import org.bson.types.ObjectId;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;
import org.jongo.marshall.jackson.oid.MongoObjectId;
import play.api.Play;
import uk.co.panaxiom.playjongo.PlayJongo;

public class Beer {
    public static PlayJongo jongo = Play.current().injector().instanceOf(PlayJongo.class);

    public static MongoCollection beers() {
        return jongo.getCollection("beers");
    }

    @MongoObjectId
    public String _id;
    public String name;

    public boolean insert() {
        return beers().save(this).getN() > 0;
    }

    public boolean remove() {
        return beers().remove(new ObjectId(this._id)).getN() > 0;
    }

    public static MongoCursor<Beer> findAll() {
        return beers().find().as(Beer.class);
    }

    public static Beer get(String _id) {
        return beers().findOne("{_id: #}", new ObjectId(_id)).as(Beer.class);
    }

    public static Beer findByName(String name) {
        return beers().findOne("{name: #}", name).as(Beer.class);
    }
}
