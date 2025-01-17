package Controladores;

import Conexion.ConexionBase;
import Conexion.ConexionFactory;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class GestionContratos {
    private ConexionBase conexion;
    private MongoCollection<Document> coleccion;

    public GestionContratos(String tipoConexion) {
        this.conexion = ConexionFactory.getConexion(tipoConexion);
        this.conexion.conectar();
        this.coleccion = conexion.getDatabase().getCollection("contratos");
    }

    // Método para registrar un contrato
    public void registrarContrato(String propiedadId, String usuarioId, String fechaInicio, String fechaFin) {
        Document contrato = new Document("propiedadId", propiedadId)
                .append("usuarioId", usuarioId)
                .append("fechaInicio", fechaInicio)
                .append("fechaFin", fechaFin);
        coleccion.insertOne(contrato);
        System.out.println("Contrato registrado exitosamente.");
    }

    // Método para cerrar la conexión
    public void cerrarConexion() {
        conexion.cerrarConexion();
    }
}
