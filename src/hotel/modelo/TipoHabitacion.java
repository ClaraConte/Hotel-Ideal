package hotel.modelo;

public class TipoHabitacion {

    private int tipoHabitacionId;

    private String tipoHabitacionNombre;

    private int tipoHabitacioCapacidadMax;

    private double tipoHabitacionPrecio;

    public TipoHabitacion() {
    }

    public TipoHabitacion(int tipoHabitacionId, String tipoHabitacionNombre, int tipoHabitacioCapacidadMax, double tipoHabitacionPrecio) {
        this.tipoHabitacionId = tipoHabitacionId;
        this.tipoHabitacionNombre = tipoHabitacionNombre;
        this.tipoHabitacioCapacidadMax = tipoHabitacioCapacidadMax;
    }

    public TipoHabitacion(String tipoHabitacionNombre, int tipoHabitacioCapacidadMax, double tipoHabitacionPrecio) {
        this.tipoHabitacionNombre = tipoHabitacionNombre;
        this.tipoHabitacioCapacidadMax = tipoHabitacioCapacidadMax;
        this.tipoHabitacionPrecio = tipoHabitacionPrecio;
    }

    public TipoHabitacion(String tipoHabitacionNombre) {
        this.tipoHabitacionNombre = tipoHabitacionNombre;
    }

    public int getTipoHabitacionId() {
        return tipoHabitacionId;
    }

    public void setTipoHabitacionId(int tipoHabitacionId) {
        this.tipoHabitacionId = tipoHabitacionId;
    }

    public String getTipoHabitacionNombre() {
        return tipoHabitacionNombre;
    }

    public void setTipoHabitacionNombre(String tipoHabitacionNombre) {
        this.tipoHabitacionNombre = tipoHabitacionNombre;
    }

    public int getTipoHabitacioCapacidadMax() {
        return tipoHabitacioCapacidadMax;
    }

    public void setTipoHabitacioCapacidadMax(int tipoHabitacioCapacidadMax) {
        this.tipoHabitacioCapacidadMax = tipoHabitacioCapacidadMax;
    }

    public double getTipoHabitacionPrecio() {
        return tipoHabitacionPrecio;
    }

    public void setTipoHabitacionPrecio(double tipoHabitacionPrecio) {
        this.tipoHabitacionPrecio = tipoHabitacionPrecio;
    }

    @Override
    public String toString() {
        return tipoHabitacionNombre;
    }
    
}
