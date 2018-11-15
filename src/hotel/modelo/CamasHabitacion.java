package hotel.modelo;

public class CamasHabitacion {

    private int camasHabitacionId;

    private Habitacion habitacionId;

    private TipoCama tipoCamaId;

    public CamasHabitacion() {
    }

    public CamasHabitacion(int camasHabitacionId, Habitacion habitacionId, TipoCama tipoCamaId) {
        this.camasHabitacionId = camasHabitacionId;
        this.habitacionId = habitacionId;
        this.tipoCamaId = tipoCamaId;
    }

    public CamasHabitacion(Habitacion habitacionId, TipoCama tipoCamaId) {
        this.habitacionId = habitacionId;
        this.tipoCamaId = tipoCamaId;
    }

    public int getCamasHabitacionId() {
        return camasHabitacionId;
    }

    public void setCamasHabitacionId(int camasHabitacionId) {
        this.camasHabitacionId = camasHabitacionId;
    }

    public Habitacion getHabitacionId() {
        return habitacionId;
    }

    public void setHabitacionId(Habitacion habitacionId) {
        this.habitacionId = habitacionId;
    }

    public TipoCama getTipoCamaId() {
        return tipoCamaId;
    }

    public void setTipoCamaId(TipoCama tipoCamaId) {
        this.tipoCamaId = tipoCamaId;
    }

}
