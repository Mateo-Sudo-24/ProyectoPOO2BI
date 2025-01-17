package Modelos;

public class Propiedad {
    private String id;
    private String direccion;
    private double precio;
    private String tipo;
    private String propietario;

    public Propiedad(String id, String direccion, double precio, String tipo, String propietario) {
        this.id = id;
        this.direccion = direccion;
        this.precio = precio;
        this.tipo = tipo;
        this.propietario = propietario;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    @Override
    public String toString() {
        return "Propiedad{" +
                "id='" + id + '\'' +
                ", direccion='" + direccion + '\'' +
                ", precio=" + precio +
                ", tipo='" + tipo + '\'' +
                ", propietario='" + propietario + '\'' +
                '}';
    }
}
