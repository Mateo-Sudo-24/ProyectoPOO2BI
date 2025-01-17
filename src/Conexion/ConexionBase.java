package Conexion;

import com.mongodb.client.MongoDatabase;

public interface ConexionBase {
    void conectar();
    MongoDatabase getDatabase();
    void cerrarConexion();
}
