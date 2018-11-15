package hotel.modelo;

public class Habitacion {

    private int habitacionId;

    private int habitacionCantidadDeCamas;

    private boolean habitacionEstado;

    private TipoHabitacion tipoHabitacionId;

    public Habitacion() {
    }

    public Habitacion(int habitacionId, int habitacionCantidadDeCamas, boolean habitacionEstado, TipoHabitacion tipoHabitacionId) {
        this.habitacionId = habitacionId;
        this.habitacionCantidadDeCamas = habitacionCantidadDeCamas;
        this.habitacionEstado = habitacionEstado;
        this.tipoHabitacionId = tipoHabitacionId;
    }

    public Habitacion(int habitacionCantidadDeCamas, boolean habitacionEstado, TipoHabitacion tipoHabitacionId) {
        this.habitacionCantidadDeCamas = habitacionCantidadDeCamas;
        this.habitacionEstado = habitacionEstado;
        this.tipoHabitacionId = tipoHabitacionId;

    }

    public int getHabitacionId() {
        return habitacionId;
    }

    public void setHabitacionId(int habitacionId) {
        this.habitacionId = habitacionId;
    }

    public int getHabitacionCantidadDeCamas() {
        return habitacionCantidadDeCamas;
    }

    public void setHabitacionCantidadDeCamas(int habitacionCantidadDeCamas) {
        this.habitacionCantidadDeCamas = habitacionCantidadDeCamas;
    }

    public boolean isHabitacionEstado() {
        return habitacionEstado;
    }

    public void setHabitacionEstado(boolean habitacionEstado) {
        this.habitacionEstado = habitacionEstado;
    }

    public TipoHabitacion getTipoHabitacionId() {
        return tipoHabitacionId;
    }

    public void setTipoHabitacionId(TipoHabitacion tipoHabitacionId) {
        this.tipoHabitacionId = tipoHabitacionId;
    }
    public String toString(){
    
        return "Num - "+habitacionId;
    }

}
