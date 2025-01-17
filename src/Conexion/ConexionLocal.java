package Conexion;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class ConexionAtlas implements ConexionBase {
    private MongoClient mongoClient;
    private MongoDatabase database;
    private static final String CONNECTION_STRING = "mongodb+srv://Mateo:<db_password>@cluster0.kui1t.mongodb.net/?retryWrites=true&w=majority";

    @Override
    public void conectar() {
        try {
            mongoClient = MongoClients.create(
                    MongoClientSettings.builder()
                            .applyConnectionString(new ConnectionString(CONNECTION_STRING))
                            .serverApi(ServerApi.builder()
                                    .version(ServerApiVersion.V1)
                                    .build())
                            .build()
            );
            database = mongoClient.getDatabase("ProyectoPOO2Bi");
            System.out.println("Conexión exitosa a MongoDB Atlas.");
        } catch (Exception e) {
            System.err.println("Error al conectar a MongoDB Atlas: " + e.getMessage());
        }
    }

    @Override
    public MongoDatabase getDatabase() {
        if (database == null) {
            throw new IllegalStateException("Debes conectar primero a la base de datos.");
        }
        return database;
    }

    @Override
    public void cerrarConexion() {
        if (mongoClient != null) {
            mongoClient.close();
            System.out.println("Conexión a MongoDB Atlas cerrada.");
        }
    }
}
