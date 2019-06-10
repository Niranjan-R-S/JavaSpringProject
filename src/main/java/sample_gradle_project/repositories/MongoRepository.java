package sample_gradle_project.repositories;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClient;

public class MongoRepository {
    public final MongoDatabase database;
    public final MongoClient mongo;

    public MongoRepository(){
        this.mongo= new MongoClient("localhost", 27017);
        this.database = mongo.getDatabase("rna_transcriptions_db");
    }
}