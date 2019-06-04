package DAO;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import models.Perro;
import org.bson.Document;

import java.util.ArrayList;

import static com.mongodb.client.model.Filters.*;

public class PerroDAO {

    public static Perro listarPerro(String puesto){
        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
        MongoDatabase database = mongoClient.getDatabase("ZooDog");
        MongoCollection<Document> collection = database.getCollection("perro");
        Document perroDocument = collection.find(eq("puesto", puesto)).first();
        mongoClient.close();
        return new Perro(puesto, perroDocument.getString("raza"),
                perroDocument.getString("personalidad"),
                perroDocument.getString("energia"),
                perroDocument.getString("descripcion"));
    }
    public static ArrayList<Perro> listarPerros() {
        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
        MongoDatabase database = mongoClient.getDatabase("ZooDog");
        MongoCollection<Document> collection = database.getCollection("perro");
        ArrayList<Perro> perros = new ArrayList();
        for (Document perroDocument : collection.find()) {
            perros.add(new Perro(perroDocument.getString("puesto"), perroDocument.getString("raza"),
                    perroDocument.getString("personalidad"),
                    perroDocument.getString("energia"),
                    perroDocument.getString("descripcion")));
        }
        mongoClient.close();
        return perros;
    }
}
