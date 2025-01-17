package Conexion;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class ConexionBaseSingleton {

    private static MongoClient mongoClient;
    private static MongoDatabase database;

    // Método para obtener la conexión a la base de datos MongoDB
    public static MongoClient getInstance() {
        if (mongoClient == null) {
            try {
                String uri = "mongodb+srv://Mateo:Administrador32@cluster0.kui1t.mongodb.net/?retryWrites=true&w=majority";
                System.out.println("Intentando conectar a MongoDB...");
                mongoClient = MongoClients.create(uri);

                // Intentamos acceder a la base de datos "ProyectoPOO2BI"
                database = mongoClient.getDatabase("ProyectoPOO2BI");

                if (database == null) {
                    throw new IllegalStateException("La base de datos no se ha encontrado o no se ha conectado correctamente.");
                } else {
                    System.out.println("Conexión exitosa a la base de datos: " + database.getName());
                }
            } catch (Exception e) {
                System.err.println("Error al conectar a MongoDB: " + e.getMessage());
            }
        }
        return mongoClient;
    }

    // Método para obtener la base de datos
    public static MongoDatabase getDatabase() {
        // Verificamos si la conexión se ha inicializado correctamente
        if (database == null) {
            throw new IllegalStateException("La conexión a la base de datos no se ha inicializado correctamente.");
        }
        return database;
    }

    // Método para cerrar la conexión
    public static void cerrarConexion() {
        if (mongoClient != null) {
            mongoClient.close();
            mongoClient = null;
            database = null;
        }
    }
}
