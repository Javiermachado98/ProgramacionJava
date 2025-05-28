import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.Arrays;
import org.bson.Document;

public class C_InsertDifferentData{

    public static void main(String[] args) {

        try {
            String connectionString = "mongodb://localhost:27017";
            MongoClient mongoClient = MongoClients.create(connectionString);
            MongoDatabase database = mongoClient.getDatabase("users"); 

            MongoCollection<Document> collection = database.getCollection("users");

            Document document = new Document()
                    .append("name", "Maricarmen")
                    .append("age", 20)
                    .append("email", "mc@iesjosemor.com")
                    .append("address", new Document()
                            .append("street", "C/Alta 23")
                            .append("city", "Monzón"))
                    .append("hobbies", Arrays.asList("reading", "traveling", "cooking"));
            
            collection.insertOne(document);

           Document document2 = new Document()
                    .append("name", "Cristina")
                    .append("age", 10)
                    .append("email", "cb@iesjosemor.com")
                    .append("address", new Document()
                            .append("street", "C/Alta 12")
                            .append("city", "Bielsa"))
                    .append("hobbies", Arrays.asList("sports", "traveling", "programming"));

            collection.insertOne(document2);

            System.out.println("Document inserted successfully.");

            mongoClient.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
