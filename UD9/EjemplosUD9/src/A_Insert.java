import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class A_Insert {

    public static void main(String[] args) {

        try {
            String connectionString = "mongodb://localhost:27017";
            MongoClient mongoClient = MongoClients.create(connectionString);
            MongoDatabase database = mongoClient.getDatabase("users"); // Replace with your database name

            MongoCollection<Document> collection = database.getCollection("users");

            Document document = new Document()
                    .append("name", "Rufino")
                    .append("age", 19)
                    .append("email", "rufino@iesjosemor.com");

            collection.insertOne(document);

            System.out.println("Document inserted successfully.");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
