import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class B_Consulta {
        
    public static void main(String[] args) {

        try {
            String connectionString = "mongodb://localhost:27017";
            MongoClient mongoClient = MongoClients.create(connectionString);
            MongoDatabase database = mongoClient.getDatabase("users"); 

            MongoCollection<Document> collection = database.getCollection("users");

            Document query = new Document("age", new Document("$gt", 20));
            MongoCursor<Document> cursor = collection.find(query).iterator();

            while (cursor.hasNext()) {
                Document document = cursor.next();
                String name = document.getString("name");
                int age = document.getInteger("age");
                String email = document.getString("email");

                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
                System.out.println("Email: " + email);
                System.out.println("----------------------");
            }

            cursor.close();
            mongoClient.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}