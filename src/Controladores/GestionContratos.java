package Controladores;

import Conexion.ConexionBaseSingleton;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class GestionContratos {
    private MongoCollection<Document> coleccion;

    public GestionContratos(String atlas) {
        // Usamos la conexión centralizada
        this.coleccion = ConexionBaseSingleton.getDatabase().getCollection("contratos");
    }

    // Método para registrar un contrato
    public void registrarContrato(String propiedadId, String usuarioId, String fechaInicio, String fechaFin) {
        try {
            Document contrato = new Document("propiedadId", propiedadId)
                    .append("usuarioId", usuarioId)
                    .append("fechaInicio", fechaInicio)
                    .append("fechaFin", fechaFin);
            coleccion.insertOne(contrato);
            System.out.println("Contrato registrado exitosamente.");
        } catch (Exception e) {
            System.err.println("Error al registrar contrato: " + e.getMessage());
        }
    }

    // Método para cerrar la conexión
    public void cerrarConexion() {
        ConexionBaseSingleton.cerrarConexion();
    }
}
