/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.vistas;

import hotel.modelo.CamasHabitacion;
import hotel.modelo.CamasHabitacionData;
import hotel.modelo.Conexion;
import hotel.modelo.Habitacion;
import hotel.modelo.HabitacionData;
import hotel.modelo.Huesped;
import hotel.modelo.HuespedData;
import hotel.modelo.Reservas;
import hotel.modelo.ReservasData;
import hotel.modelo.TipoCama;
import hotel.modelo.TipoCamaData;
import hotel.modelo.TipoHabitacion;
import hotel.modelo.TipoHabitacionData;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author clara
 */
public class TestCase {

    private Connection connection = null;
    Conexion conexion;

    public TestCase(Conexion conexion) {
        try {
            this.conexion = conexion;
            connection = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error al abrir la conexion");
        }

    }

    public void testHuespedEditar() {
        Huesped huesped;
        Huesped huespedEditar;
        HuespedData huespedData;
        huespedData = new HuespedData(conexion);
        int DNI = 3017871;
        System.out.println("// Editar huéspedes --");
        huesped = new Huesped(DNI, "Claraconte", "Lapunta", "clara@clara.com", "2616266910");
        huespedData.editarHuesped(huesped);
        System.out.println("***********************************");
    }

    public void testHuespedesListar() {
        HuespedData huespedData;
        huespedData = new HuespedData(conexion);
        System.out.println("// Listar huéspedes --");
        huespedData.obtenerHuespedes().forEach(huespedes -> {
            System.out.println("Nombre : " + huespedes.getHuespedNombre() + "  DNI : " + huespedes.getHuespedDni());
        });
        System.out.println("***********************************");
    }

    public void testIsHuespedDni() {
        HuespedData huespedData;
        huespedData = new HuespedData(conexion);
        System.out.println("// Existe el DNI de Huésped --");
        int dni = 30178;
        System.out.println("Existe el huesped : " + huespedData.isHuespedDni(dni));
        System.out.println("***********************************");
    }

    public void testHabitacionesListar() {
        HabitacionData habitacionData;
        habitacionData = new HabitacionData(conexion);
        Habitacion habitacion;
        habitacion = new Habitacion();

        System.out.println("// Listar habitaciones --");
        habitacionData.obtenerHabitaciones().forEach(habitaciones -> {
            System.out.println("id habitacion: " + habitaciones.getHabitacionId()
                    + " Cantidad de camas: " + habitaciones.getHabitacionCantidadDeCamas());
        });
        System.out.println("***********************************");
    }

    public void testHabitacionesListarPorId() {
        HabitacionData habitacionData;
        habitacionData = new HabitacionData(conexion);
        Habitacion habitacion;
        habitacion = new Habitacion();
        int habitacionId = 5;

        System.out.println("// Listar por ID --");
        habitacion = habitacionData.buscarHabitacion(habitacionId);
        System.out.println("Habitación Número: " + habitacion.getHabitacionId()
                + "  Habitación Tipo Id : " + habitacion.getTipoHabitacionId().getTipoHabitacionId()
        );
        System.out.println("***********************************");
    }

    public void testHabitacionesListarPorTipo() {
        HabitacionData habitacionData;
        habitacionData = new HabitacionData(conexion);
        Habitacion habitacion;
        habitacion = new Habitacion();
        int tipoHabitacionId = 2;
        System.out.println("// Listar por TIPO --");
        habitacionData.obtenerHabitacionesPorTipo(tipoHabitacionId).forEach(habitacionPorTipo -> {
            System.out.println("Habitación Número: " + habitacionPorTipo.getHabitacionId()
                    + "  Habitación precio : " + habitacionPorTipo.getTipoHabitacionId().getTipoHabitacionNombre()
                    + "  Habitación Tipo Id : " + habitacionPorTipo.getTipoHabitacionId().getTipoHabitacionId()
            );
        });
        System.out.println("***********************************");

    }

    public void testHabitacionesGuardar() {
        HabitacionData habitacionData;
        habitacionData = new HabitacionData(conexion);
        TipoHabitacion tipoHabitacion;
        tipoHabitacion = new TipoHabitacion();
        tipoHabitacion.setTipoHabitacionId(2);
        Habitacion habitacionAGuardar;
        System.out.println("// Guardar habitación --");
        habitacionAGuardar = new Habitacion(8, true, tipoHabitacion);
        habitacionData.guardarHabitacion(habitacionAGuardar);
        System.out.println("***********************************");
    }

    public void testHabitacionesEditar() {
        int idEditar = 8;
        HabitacionData habitacionData;
        habitacionData = new HabitacionData(conexion);
        TipoHabitacion tipoHabitacion;
        tipoHabitacion = new TipoHabitacion();
        tipoHabitacion.setTipoHabitacionId(3);

        Habitacion habitacionAEditar;
        System.out.println("// Editar habitación --");
        habitacionAEditar = new Habitacion(idEditar, 5, true, tipoHabitacion);
        habitacionData.editarHabitacion(habitacionAEditar);
        System.out.println("***********************************");
    }

    public void testCamasHabitacionGuardar() {
        CamasHabitacion camasHabitacion;
        CamasHabitacionData camasHabitacionData;
        camasHabitacionData = new CamasHabitacionData(conexion);
        TipoHabitacion tipoHabitacion;
        tipoHabitacion = new TipoHabitacion();
        tipoHabitacion.setTipoHabitacionId(3);
        Habitacion habitacion;
        habitacion = new Habitacion(5, false, tipoHabitacion);
        TipoCama tipoCama;
        tipoCama = new TipoCama(2, "simple");
        System.out.println("// Guardar Cama habitación --");
        camasHabitacionData.guardarCamasHabitacion(habitacion, tipoCama);
        System.out.println("La habitacion " + habitacion.getHabitacionId() + " tiene una cama tipo " + tipoCama.getTipoCamaNombre());
        System.out.println("***********************************");
    }

    public void testCamasHabitacionListarPorTipo() {
        CamasHabitacionData camasHabitacionData;
        camasHabitacionData = new CamasHabitacionData(conexion);

        int tipoCamaId = 3;
        System.out.println("// Listar Camas de habitación --");
        camasHabitacionData.obtenerCamasporHabitacion(tipoCamaId).forEach(camasPorHabitacion -> {
            System.out.println("Habitación Número: " + camasPorHabitacion.getCamasHabitacionId()
                    + "  Habitación Tipo Cama : " + camasPorHabitacion.getTipoCamaId().getTipoCamaId()
                    + " Habitacion id " + camasPorHabitacion.getHabitacionId().getHabitacionId());
        });
        System.out.println("***********************************");
    }

    public void testObtenerCamasPorHabitacionId() {
        CamasHabitacionData camasHabitacionData;
        camasHabitacionData = new CamasHabitacionData(conexion);
        int habitacionId = 3;
        System.out.println("// Listar Camas de habitación por ID de habitación --");

        camasHabitacionData.obtenerCamasPorHabitacionId(habitacionId).forEach(camasPorHabitacion -> {
            System.out.println("Habitación Número: " + camasPorHabitacion.getCamasHabitacionId()
                    + " Habitacion id " + camasPorHabitacion.getHabitacionId().getHabitacionId()
                    + "  Habitación Tipo Cama : " + camasPorHabitacion.getTipoCamaId().getTipoCamaId());
        });

        System.out.println("***********************************");

    }

    public void testBuscarTipoCamaPorId() {
        int tipoCamaId = 2;
        TipoCamaData tipoCamaData;
        tipoCamaData = new TipoCamaData(conexion);
        TipoCama tipoCama;
        tipoCama = new TipoCama();
        tipoCama = tipoCamaData.buscarTipoCamaPorId(tipoCamaId);
        System.out.println("// Listar tipos Camas de habitación por tipoCamaId --");
        System.out.println("id: " + tipoCama.getTipoCamaId() + " Nombre: " + tipoCama.getTipoCamaNombre());
        System.out.println("***********************************");

    }

    public void testBuscarTipoHabitacionPorId() {
        int tipoHabitacionId = 2;
        TipoHabitacionData tipoHabitacionData;
        tipoHabitacionData = new TipoHabitacionData(conexion);
        TipoHabitacion tipoHabitacion = null;
        TipoHabitacion TipoHabitacion = tipoHabitacion;
        tipoHabitacion = new TipoHabitacion();
        tipoHabitacion = tipoHabitacionData.buscarTipoHabitacion(tipoHabitacionId);
        System.out.println("// Listar tipos de habitacion por tipoHabitacionId --");
        System.out.println("id: " + tipoHabitacion.getTipoHabitacionId() + "Nombre: " + tipoHabitacion.getTipoHabitacionNombre());
        System.out.println("***********************");
    }

    public void testReservaGuardar() {

        //carga huesped    
        Huesped huesped;
        huesped = new Huesped();
        huesped.setHuespedId(1);

        //carga habitación
        Habitacion habitacion;
        habitacion = new Habitacion();
        habitacion.setHabitacionId(2);

        ReservasData reservasData;
        reservasData = new ReservasData(conexion);
        Reservas reservas;
        LocalDate fechaCheckIn = LocalDate.of(2018, 03, 23);
        LocalDate fechaCheckOut = LocalDate.of(2018, 04, 2);
        LocalDate fechaCheckRegistro = LocalDate.of(2018, 03, 23);

        long hora;
        hora = ChronoUnit.DAYS.between(fechaCheckIn, fechaCheckOut);
        Integer reservasDias = (int) (long) hora;

        reservas = new Reservas(fechaCheckIn, fechaCheckOut, fechaCheckRegistro, reservasDias, 3500.45, true, huesped, habitacion);
        reservasData.crearReserva(reservas);

    }
 
    public void testIsDisponibleEntreFecha(){
        ReservasData reservasData;
        reservasData = new ReservasData(conexion);
        LocalDate fechaCheckIn = LocalDate.of(2018, 11, 05);
        LocalDate fechaCheckOut = LocalDate.of(2018, 11, 07);
        int habitacionId = 2;
        boolean val;
        val = reservasData.isDisponibleEntreFecha(fechaCheckIn, fechaCheckOut, habitacionId);
        System.out.println("Habitacion NO está disponible en ese periodo? --> " + val);
    }
    
    public void testBuscaReservasAFinalizar() {
        ReservasData reservasData;
        reservasData = new ReservasData(conexion);
        System.out.println("// Listar reservas con fecha checkOut a finalizar--");

        reservasData.buscaReservasAFinalizar().forEach(reservas -> {
            System.out.println("Reserva Número: " + reservas.getReservasId()
                    + " Habitacion id " + reservas.getHabitacionId().getHabitacionId()
                    + " Huesped : " + reservas.getHuespedId().getHuespedId());
        });

        System.out.println("***********************************");
    }
    
    public void testListaReservas() {
        ReservasData reservasData;
        reservasData = new ReservasData(conexion);
        System.out.println("// Listar reservas  --");

        reservasData.listadoDeReservas().forEach(reservas -> {
            System.out.println("Reserva Número: " + reservas.getReservasId()
                    + " Habitacion id " + reservas.getHabitacionId().getHabitacionId()
                    + " Habitacion camas" + reservas.getHabitacionId().getHabitacionCantidadDeCamas()

                    + " Huesped id: " + reservas.getHuespedId().getHuespedId()
                    + " Huesped nombre: " + reservas.getHuespedId().getHuespedNombre()
                    + " Huesped dni: " + reservas.getHuespedId().getHuespedDni()
            
                    + " Reserva dias: " + reservas.getReservasDias()
                    + " Reserva monto: " + reservas.getReservasMonto()
                    + " Reserva fecha registro: " + reservas.getReservasFechaCreacion()
                    + " Reserva fecha checkOut: " + reservas.getReservasfechaCheckout()
                    + " Reserva fecha Estado: " + reservas.isReservasEstado());

        });

        System.out.println("***********************************");
    }
    
    public void testFinReserva(){
        ReservasData reservasData;
        reservasData = new ReservasData(conexion);
        
        Huesped huesped;
        huesped = new Huesped();
        huesped.setHuespedId(38);

        //carga habitación
        Habitacion habitacion;
        habitacion = new Habitacion();
        habitacion.setHabitacionId(5);

        reservasData.finReserva(habitacion, huesped);
    }
 
    public void testListaReservasPorIdHuesped() {
        ReservasData reservasData;
        reservasData = new ReservasData(conexion);
        Huesped huespedId = new Huesped();
        
        huespedId.setHuespedId(2);
        System.out.println("// Listar reservas por cada huesped --");

        reservasData.listadoDeReservas(huespedId).forEach(reservas -> {
            System.out.println("Reserva Número: " + reservas.getReservasId()
                    + " Habitacion id " + reservas.getHabitacionId().getHabitacionId()
                    + " Habitacion camas" + reservas.getHabitacionId().getHabitacionCantidadDeCamas()

                    + " Huesped id: " + reservas.getHuespedId().getHuespedId()
                    + " Huesped nombre: " + reservas.getHuespedId().getHuespedNombre()
                    + " Huesped dni: " + reservas.getHuespedId().getHuespedDni()
            
                    + " Reserva dias: " + reservas.getReservasDias()
                    + " Reserva monto: " + reservas.getReservasMonto()
                    + " Reserva fecha registro: " + reservas.getReservasFechaCreacion()
                    + " Reserva fecha checkOut: " + reservas.getReservasfechaCheckout()
                    + " Reserva fecha Estado: " + reservas.isReservasEstado());
            });

        System.out.println("***********************************");
    }
    
}
