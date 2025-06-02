import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class TareaMongo {
    public static void main(String[] args) {

        try {
            String connectionString = "mongodb://localhost:27017";
            MongoClient  mongoClient =



        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }

    }
}
