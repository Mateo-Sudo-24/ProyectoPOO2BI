package Conexion;

public class ConexionFactory {
    public static ConexionBase getConexion(String tipo) {
        if (tipo.equalsIgnoreCase("local")) {
            return new ConexionLocal();
        } else if (tipo.equalsIgnoreCase("atlas")) {
            return new ConexionAtlas();
        }
        throw new IllegalArgumentException("Tipo de conexión no soportado: " + tipo);
    }
}
