package Controladores;

import Conexion.ConexionBaseSingleton;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class GestionPropiedades {
    private MongoCollection<Document> coleccion;

    public GestionPropiedades(String atlas) {
        // Usamos la conexión centralizada
        this.coleccion = ConexionBaseSingleton.getDatabase().getCollection("propiedades");
    }

    // Método para registrar una propiedad
    public void registrarPropiedad(String direccion, double precio, String tipo, String propietario) {
        try {
            Document propiedad = new Document("direccion", direccion)
                    .append("precio", precio)
                    .append("tipo", tipo)
                    .append("propietario", propietario);
            coleccion.insertOne(propiedad);
            System.out.println("Propiedad registrada exitosamente.");
        } catch (Exception e) {
            System.err.println("Error al registrar propiedad: " + e.getMessage());
        }
    }

    // Método para buscar propiedades por filtro
    public List<Document> buscarPropiedadesPorFiltro(String campo, Object valor) {
        List<Document> resultados = new ArrayList<>();
        try {
            coleccion.find(new Document(campo, valor)).into(resultados);
        } catch (Exception e) {
            System.err.println("Error al buscar propiedades: " + e.getMessage());
        }
        return resultados;
    }

    // Método para actualizar una propiedad
    public void actualizarPropiedad(String id, String campo, Object nuevoValor) {
        try {
            Document filtro = new Document("_id", id);
            Document actualizacion = new Document("$set", new Document(campo, nuevoValor));
            coleccion.updateOne(filtro, actualizacion);
            System.out.println("Propiedad actualizada exitosamente.");
        } catch (Exception e) {
            System.err.println("Error al actualizar propiedad: " + e.getMessage());
        }
    }

    // Método para eliminar una propiedad
    public void eliminarPropiedad(String id) {
        try {
            coleccion.deleteOne(new Document("_id", id));
            System.out.println("Propiedad eliminada exitosamente.");
        } catch (Exception e) {
            System.err.println("Error al eliminar propiedad: " + e.getMessage());
        }
    }

    // Método para cerrar la conexión
    public void cerrarConexion() {
        ConexionBaseSingleton.cerrarConexion();
    }
}
