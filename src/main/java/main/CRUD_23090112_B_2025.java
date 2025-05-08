/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package main;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import java.util.Arrays;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 * 4NGDfyeXXu2bL0uG
 *
 * @author ahmdsaif
 */
public class CRUD_23090112_B_2025 {

    public static void main(String[] args) {
        // Mengkoneksikan dengan Mongo DB Connection
        String URL = "mongodb+srv://ahmadsaif7456:4NGDfyeXXu2bL0uG@learning-mongo.8ztyaby.mongodb.net/";

        try (MongoClient mongo = MongoClients.create(URL)) {
            MongoDatabase DB = mongo.getDatabase("uts_23090112_B_2025"); // Menginisialisasi Database
            MongoCollection<Document> collection = DB.getCollection("coll_23090112_B_2025"); // Menginisialisasi Collection

            // Create
            Document produk1 = new Document("Nama Produk", "Laptop HP Victus 15")// String
                    .append("Harga", 24000000)// Integer
                    .append("Ketersediaan", true);// Boolean

            Document produk2 = new Document("Nama Produk", "Laptop Asus ROG Zephyrus")
                    .append("Harga", 30000000)
                    .append("Ketersediaan", true);

            Document produk3 = new Document("Nama Produk", "Laptop Lenovo Legion 5")
                    .append("Harga", 28000000)
                    .append("Ketersediaan", false);
            collection.insertMany(Arrays.asList(produk1, produk2, produk3));

            // Read
            FindIterable<Document> result = collection.find();
            for (Document d : result) {
                System.out.println(d.toJson());
            }

            // Update
            //collection.updateOne(Filters.eq("Nama Produk", "Laptop HP Victus"), Updates.set("Nama Produk", "Laptop Asus ROG"));
            // Delete 
            //collection.updateOne(Filters.eq("Nama Produk", "Oemar"), Updates.unset("Harga")); // Menghapus Salah Satu Kolom
            //collection.deleteOne(Filters.eq("Nama Produk", "Laptop HP Victus")); // Menghapus Dokumen
            // Searching
//            Bson f = Filters.eq("Nama Produk", "Laptop HP Victus");
//            FindIterable<Document> search = collection.find(f);
//            for(Document d : search){
//                System.out.println(d.toJson());  
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
