package hotel.modelo;

import java.time.LocalDate;

public class Reservas {

    private int reservasId;

    private LocalDate reservasFechaCheckin;

    private LocalDate reservasfechaCheckout;

    private LocalDate reservasFechaCreacion;

    private int reservasDias;

    private double reservasMonto;

    private boolean reservasEstado;

    private Huesped huespedId;

    private Habitacion habitacionId;

    public Reservas() {
    }

    public Reservas(int reservasId, LocalDate reservasFechaCheckin, LocalDate reservasfechaCheckout, LocalDate reservasFechaCreacion, int reservasDias, double reservasMonto, boolean reservasEstado, Huesped huespedId, Habitacion habitacionId) {
        this.reservasId = reservasId;
        this.reservasFechaCheckin = reservasFechaCheckin;
        this.reservasfechaCheckout = reservasfechaCheckout;
        this.reservasFechaCreacion = reservasFechaCreacion;
        this.reservasDias = reservasDias;
        this.reservasMonto = reservasMonto;
        this.reservasEstado = reservasEstado;
        this.huespedId = huespedId;
        this.habitacionId = habitacionId;
    }

    public Reservas(LocalDate reservasFechaCheckin, LocalDate reservasfechaCheckout, LocalDate reservasFechaCreacion, int reservasDias, double reservasMonto, boolean reservasEstado, Huesped huespedId, Habitacion habitacionId) {
        this.reservasId = -1;
        this.reservasFechaCheckin = reservasFechaCheckin;
        this.reservasfechaCheckout = reservasfechaCheckout;
        this.reservasFechaCreacion = reservasFechaCreacion;
        this.reservasDias = reservasDias;
        this.reservasMonto = reservasMonto;
        this.reservasEstado = reservasEstado;
        this.huespedId = huespedId;
        this.habitacionId = habitacionId;
    }

    public int getReservasId() {
        return reservasId;
    }

    public void setReservasId(int reservasId) {
        this.reservasId = reservasId;
    }

    public LocalDate getReservasFechaCheckin() {
        return reservasFechaCheckin;
    }

    public void setReservasFechaCheckin(LocalDate reservasFechaCheckin) {
        this.reservasFechaCheckin = reservasFechaCheckin;
    }

    public LocalDate getReservasfechaCheckout() {
        return reservasfechaCheckout;
    }

    public void setReservasfechaCheckout(LocalDate reservasfechaCheckout) {
        this.reservasfechaCheckout = reservasfechaCheckout;
    }

    public LocalDate getReservasFechaCreacion() {
        return reservasFechaCreacion;
    }

    public void setReservasFechaCreacion(LocalDate reservasFechaCreacion) {
        this.reservasFechaCreacion = reservasFechaCreacion;
    }

    public int getReservasDias() {
        return reservasDias;
    }

    public void setReservasDias(int reservasDias) {
        this.reservasDias = reservasDias;
    }

    public double getReservasMonto() {
        return reservasMonto;
    }

    public void setReservasMonto(double reservasMonto) {
        this.reservasMonto = reservasMonto;
    }

    public boolean isReservasEstado() {
        return reservasEstado;
    }

    public void setReservasEstado(boolean reservasEstado) {
        this.reservasEstado = reservasEstado;
    }

    public Huesped getHuespedId() {
        return huespedId;
    }

    public void setHuespedId(Huesped huespedId) {
        this.huespedId = huespedId;
    }

    public Habitacion getHabitacionId() {
        return habitacionId;
    }

    public void setHabitacionId(Habitacion habitacionId) {
        this.habitacionId = habitacionId;
    }
    
    
}
