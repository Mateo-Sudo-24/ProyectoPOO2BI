package Controladores;

import Conexion.ConexionBase;
import Conexion.ConexionFactory;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class GestionPropiedades {
    private ConexionBase conexion;
    private MongoCollection<Document> coleccion;

    public GestionPropiedades(String tipoConexion) {
        this.conexion = ConexionFactory.getConexion(tipoConexion);
        this.conexion.conectar();
        this.coleccion = conexion.getDatabase().getCollection("propiedades");
    }

    // Método para registrar una propiedad
    public void registrarPropiedad(String direccion, double precio, String tipo, String propietario) {
        Document propiedad = new Document("direccion", direccion)
                .append("precio", precio)
                .append("tipo", tipo)
                .append("propietario", propietario);
        coleccion.insertOne(propiedad);
        System.out.println("Propiedad registrada exitosamente.");
    }

    // Método para buscar propiedades por filtro
    public List<Document> buscarPropiedadesPorFiltro(String campo, Object valor) {
        List<Document> resultados = new ArrayList<>();
        coleccion.find(new Document(campo, valor)).into(resultados);
        return resultados;
    }

    // Método para actualizar una propiedad
    public void actualizarPropiedad(String id, String campo, Object nuevoValor) {
        Document filtro = new Document("_id", id);
        Document actualizacion = new Document("$set", new Document(campo, nuevoValor));
        coleccion.updateOne(filtro, actualizacion);
        System.out.println("Propiedad actualizada exitosamente.");
    }

    // Método para eliminar una propiedad
    public void eliminarPropiedad(String id) {
        coleccion.deleteOne(new Document("_id", id));
        System.out.println("Propiedad eliminada exitosamente.");
    }

    // Método para cerrar la conexión
    public void cerrarConexion() {
        conexion.cerrarConexion();
    }
}
