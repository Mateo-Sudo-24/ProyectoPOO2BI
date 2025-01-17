package Modelos;

public class Contrato {
    private String id;
    private String propiedadId;
    private String usuarioId;
    private String fechaInicio;
    private String fechaFin;

    public Contrato(String id, String propiedadId, String usuarioId, String fechaInicio, String fechaFin) {
        this.id = id;
        this.propiedadId = propiedadId;
        this.usuarioId = usuarioId;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPropiedadId() {
        return propiedadId;
    }

    public void setPropiedadId(String propiedadId) {
        this.propiedadId = propiedadId;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public String toString() {
        return "Contrato{" +
                "id='" + id + '\'' +
                ", propiedadId='" + propiedadId + '\'' +
                ", usuarioId='" + usuarioId + '\'' +
                ", fechaInicio='" + fechaInicio + '\'' +
                ", fechaFin='" + fechaFin + '\'' +
                '}';
    }
}
