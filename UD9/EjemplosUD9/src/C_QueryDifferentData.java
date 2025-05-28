import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import java.util.List;

public class C_QueryDifferentData {

    public static void main(String[] args) {

        try {
            String connectionString = "mongodb://localhost:27017";
            MongoClient mongoClient = MongoClients.create(connectionString);
            MongoDatabase database = mongoClient.getDatabase("users"); // Replace with your database name

            MongoCollection<Document> collection = database.getCollection("users");

            Document query = new Document();
            Document projection = new Document("name", 1).append("hobbies", 1);

            MongoCursor<Document> cursor = collection.find(query).projection(projection).iterator();

            while (cursor.hasNext()) {
                Document document = cursor.next();
                String name = document.getString("name");
                List<String> hobbies = document.getList("hobbies", String.class);

                System.out.println("Name: " + name);
                System.out.println("Hobbies: " + hobbies);
                System.out.println("----------------------");
            }

            mongoClient.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
