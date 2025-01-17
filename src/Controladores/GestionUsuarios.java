package Controladores;

import Conexion.ConexionBase;
import Conexion.ConexionFactory;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class GestionUsuarios {
    private ConexionBase conexion;
    private MongoCollection<Document> coleccion;

    public GestionUsuarios(String tipoConexion) {
        this.conexion = ConexionFactory.getConexion(tipoConexion);
        this.conexion.conectar();
        this.coleccion = conexion.getDatabase().getCollection("usuarios");
    }

    // Método para registrar un usuario
    public void registrarUsuario(String nombre, String email, String contrasena) {
        Document usuario = new Document("nombre", nombre)
                .append("email", email)
                .append("contrasena", contrasena);
        coleccion.insertOne(usuario);
        System.out.println("Usuario registrado exitosamente.");
    }

    // Método para verificar credenciales
    public boolean verificarCredenciales(String email, String contrasena) {
        Document usuario = coleccion.find(new Document("email", email).append("contrasena", contrasena)).first();
        return usuario != null;
    }

    // Método para cerrar la conexión
    public void cerrarConexion() {
        conexion.cerrarConexion();
    }
}
