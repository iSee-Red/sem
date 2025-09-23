package com.napier.sem;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class App
{
    public static void main(String[] args)
    {
        // Connect to MongoDB on local system - port 27000
        MongoClient mongoClient = new MongoClient("mongo-dbserver");
        // Get a database
        MongoDatabase database = mongoClient.getDatabase("mydb");
        // Get collection from database
        MongoCollection<Document> collection = database.getCollection("test:");
        // Create document to store
        Document doc = new Document("name","Euan B")
                .append("class","DevOps")
                .append("year","2025")
                .append("result", new Document("CW",95).append("EX",85));
        // Add document to collection
        collection.insertOne(doc);

        // Check document is in collection
        Document myDoc = collection.find().first();
        System.out.println(myDoc.toJson());
    }
}
