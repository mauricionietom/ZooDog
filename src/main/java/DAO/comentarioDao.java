/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import models.Perro;
import models.Comentarios;
import org.bson.Document;

/**
 *
 * @author lauranieto
 */
public class comentarioDao {
    
    public static ArrayList<Comentarios> listarComentarios() {
        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
        MongoDatabase database = mongoClient.getDatabase("ZooDog");
        MongoCollection<Document> collection = database.getCollection("comentario");
        ArrayList<Comentarios> comentarios = new ArrayList();
        for (Document comentarioDocument : collection.find()) {
            comentarios.add(new Comentarios(comentarioDocument.getString("comentario")));
        }
        mongoClient.close();
        return comentarios;
    }
   
    public static Comentarios agregarComentario(Comentarios comentarios){
        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
        MongoDatabase database = mongoClient.getDatabase("ZooDog");
        MongoCollection<Document> collection = database.getCollection("comentario");
      Document doc = new Document("comentario",comentarios.getComentario());
      collection.insertOne(doc);
      
      mongoClient.close();
    return comentarios;
        
        
    }
    
}
