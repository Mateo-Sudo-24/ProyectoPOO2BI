package Controladores;

import Conexion.ConexionBaseSingleton;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GestionUsuarios {
    private MongoCollection<Document> coleccion;

    public GestionUsuarios(String MongoAtlas) {
        // Usamos la conexión centralizada
        this.coleccion = ConexionBaseSingleton.getDatabase().getCollection("usuarios");
    }

    // Método para registrar un usuario con contraseña cifrada
    public void registrarUsuario(String nombre, String email, String contrasena) {
        try {
            // Hashear la contraseña
            String contrasenaHash = hashPassword(contrasena);
            Document usuario = new Document("nombre", nombre)
                    .append("email", email)
                    .append("contrasena", contrasenaHash);
            coleccion.insertOne(usuario);
            System.out.println("Usuario registrado exitosamente.");
        } catch (Exception e) {
            System.err.println("Error al registrar usuario: " + e.getMessage());
        }
    }

    // Método para verificar las credenciales
    public boolean verificarCredenciales(String email, String contrasena) {
        try {
            String contrasenaHash = hashPassword(contrasena);  // Hash de la contraseña ingresada
            Document usuario = coleccion.find(new Document("email", email).append("contrasena", contrasenaHash)).first();
            return usuario != null;
        } catch (Exception e) {
            System.err.println("Error al verificar credenciales: " + e.getMessage());
            return false;
        }
    }

    // Método para hash de contraseñas
    private String hashPassword(String contrasena) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = md.digest(contrasena.getBytes());
        StringBuilder hexString = new StringBuilder();
        for (byte b : hashBytes) {
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString();  // Devolver el hash en formato hexadecimal
    }

    // Método para cerrar la conexión
    public void cerrarConexion() {
        ConexionBaseSingleton.cerrarConexion();
    }
}
