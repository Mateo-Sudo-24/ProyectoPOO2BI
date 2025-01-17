import Controladores.GestionContratos;
import Controladores.GestionPropiedades;
import Controladores.GestionUsuarios;

public class Main {
    public static void main(String[] args) {
        // Gestionar Propiedades
        GestionPropiedades gestionPropiedades = new GestionPropiedades("local");
        gestionPropiedades.registrarPropiedad("Calle 123", 200000.0, "Casa", "Juan Pérez");
        gestionPropiedades.cerrarConexion();

        // Gestionar Contratos
        GestionContratos gestionContratos = new GestionContratos("atlas");
        gestionContratos.registrarContrato("propiedadId1", "usuarioId1", "2025-01-16", "2025-12-16");
        gestionContratos.cerrarConexion();

        // Gestionar Usuarios
        GestionUsuarios gestionUsuarios = new GestionUsuarios("local");
        gestionUsuarios.registrarUsuario("Pedro", "pedro@mail.com", "12345");
        gestionUsuarios.cerrarConexion();
    }
}
