/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author clara
 */
public class ReservasData {

    private Connection connection = null;

    public ReservasData(Conexion conexion) {
        try {
            connection = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error al abrir al obtener la conexion");
        }
    }

    public void crearReserva(Reservas reservas) {
        try {

            String sql = "INSERT INTO reservas (reservasFechaCheckin, reservasfechaCheckout, reservasFechaCreacion, reservasDias, reservasMonto, reservasEstado, huespedId, habitacionId) VALUES ( ? , ? , ? , ? , ? , ? , ? , ? );";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setDate(1, Date.valueOf(reservas.getReservasFechaCheckin()));
            statement.setDate(2, Date.valueOf(reservas.getReservasfechaCheckout()));
            statement.setDate(3, Date.valueOf(reservas.getReservasFechaCreacion()));
            statement.setInt(4, reservas.getReservasDias());
            statement.setDouble(5, reservas.getReservasMonto());
            statement.setBoolean(6, reservas.isReservasEstado());
            statement.setInt(7, reservas.getHuespedId().getHuespedId());
            statement.setInt(8, reservas.getHabitacionId().getHabitacionId());

            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                reservas.setReservasId(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id luego de insertar una reserva");
            }
            statement.close();

        } catch (SQLException ex) {
            System.out.println("Error al insertar una reserva: " + ex.getMessage());
        }
    }

    public boolean isDisponibleEntreFecha(LocalDate checkIn, LocalDate checkOut, int habitacionId) {
        boolean result = false;
        try {
            String sql = "SELECT habitacionId FROM reservas WHERE "
                    + "(((? BETWEEN reservasFechaCheckin AND reservasfechaCheckout) OR (? BETWEEN reservasFechaCheckin AND reservasfechaCheckout))"
                    + " OR( ? < reservasFechaCheckin AND ? > reservasfechaCheckout))"
                    + " AND reservasEstado = 1"
                    + " AND habitacionId = ?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDate(1, java.sql.Date.valueOf(checkIn));
            statement.setDate(2, java.sql.Date.valueOf(checkOut));
            statement.setDate(3, java.sql.Date.valueOf(checkIn));
            statement.setDate(4, java.sql.Date.valueOf(checkOut));
            statement.setInt(5, habitacionId);

            ResultSet resultSet = statement.executeQuery();

            result = resultSet.first();
            statement.close();

        } catch (SQLException ex) {
            System.out.println("Error al obtener las habitaciones: " + ex.getMessage());
        }
        return result;
    }

    public List<Reservas> buscaReservasAFinalizar() {
        List<Reservas> reservado = new ArrayList<Reservas>();
        Reservas reserva = null;
        Habitacion habitacion;
        Huesped huesped;
        try {
            String sql = "SELECT * FROM reservas WHERE reservasfechaCheckout <= NOW() AND reservasEstado != 0 ;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                reserva = new Reservas();
                 habitacion = new Habitacion();
                 huesped = new Huesped();

                reserva.setReservasId(resultSet.getInt("reservasId"));

                habitacion.setHabitacionId(resultSet.getInt("habitacionId"));
                reserva.setHabitacionId(habitacion);

                huesped.setHuespedId(resultSet.getInt("huespedId"));
                reserva.setHuespedId(huesped);

                reserva.setReservasEstado(resultSet.getBoolean("reservasEstado"));
                reservado.add(reserva);

            }
            statement.close();

        } catch (SQLException ex) {
            System.out.println("Error al obtener las habitaciones: " + ex.getMessage());
        }
        return reservado;
    }

    public void finReserva(Habitacion habitacion, Huesped huesped) {
        try {
            String sql = "UPDATE reservas INNER JOIN habitacion "
                    + "ON reservas.habitacionId = ? "
                    + "SET reservas.reservasEstado = ?, habitacion.habitacionEstado = ? "
                    + "WHERE reservas.huespedId = ? AND reservas.habitacionId = ?;";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, habitacion.getHabitacionId());
            statement.setBoolean(2, false);
            statement.setBoolean(3, true);
            statement.setInt(4, huesped.getHuespedId());
            statement.setInt(5, habitacion.getHabitacionId());

            statement.executeUpdate();
            statement.close();

        } catch (SQLException ex) {
            System.out.println("Error al obtener las habitaciones: " + ex.getMessage());
        }

    }
    
    public List<Reservas> listadoDeReservas() {
    List<Reservas> reservas = new ArrayList<Reservas>();    

        try {
            String sql = "SELECT * FROM reservas "
                    + "INNER JOIN habitacion ON reservas.habitacionId = habitacion.habitacionId "
                    + "INNER JOIN huesped ON reservas.huespedId = huesped.huespedId;";
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();
            Habitacion habitacion;
            Reservas reserva;
            Huesped huesped;

            while (resultSet.next()) {
                reserva = new Reservas();
                habitacion = new Habitacion();
                huesped = new Huesped();
                
                habitacion.setHabitacionId(resultSet.getInt("habitacion.habitacionId"));
                habitacion.setHabitacionCantidadDeCamas(resultSet.getInt("habitacion.habitacionCantidadDeCamas"));
                habitacion.setHabitacionEstado(resultSet.getBoolean("habitacion.habitacionEstado"));

                reserva.setHabitacionId(habitacion);
                
                huesped.setHuespedId(resultSet.getInt("huesped.huespedId"));
                huesped.setHuespedDni(resultSet.getInt("huesped.huespedDni"));
                huesped.setHuespedNombre(resultSet.getString("huesped.huespedNombre"));
                huesped.setHuespedDomicilio(resultSet.getString("huesped.huespedDomicilio"));
                
                reserva.setHuespedId(huesped);

                reserva.setReservasId(resultSet.getInt("reservas.reservasId"));
                reserva.setReservasFechaCheckin(resultSet.getDate("reservas.reservasFechaCheckin").toLocalDate());
                reserva.setReservasfechaCheckout(resultSet.getDate("reservas.reservasfechaCheckout").toLocalDate());
                reserva.setReservasDias(resultSet.getInt("reservas.reservasDias"));
                reserva.setReservasFechaCreacion(resultSet.getDate("reservas.reservasFechaCreacion").toLocalDate());
                reserva.setReservasEstado(resultSet.getBoolean("reservas.reservasEstado"));
                reserva.setReservasMonto(resultSet.getDouble("reservas.reservasMonto"));
                
                reservas.add(reserva);
            }
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener las habitaciones: " + ex.getMessage());
        }

        return reservas;
    }

    public List<Reservas> listadoDeReservas(Huesped huespedId) {
    List<Reservas> reservas = new ArrayList<Reservas>();    

        try {
            String sql = "SELECT * FROM reservas "
                    + "INNER JOIN habitacion ON reservas.habitacionId = habitacion.habitacionId "
                    + "INNER JOIN huesped ON reservas.huespedId = huesped.huespedId "
                    + "WHERE reservas.huespedId = ?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,huespedId.getHuespedId());
            
            ResultSet resultSet = statement.executeQuery();
            Habitacion habitacion;
            Reservas reserva;
            Huesped huesped;

            while (resultSet.next()) {
                reserva = new Reservas();
                habitacion = new Habitacion();
                huesped = new Huesped();
                
                habitacion.setHabitacionId(resultSet.getInt("habitacion.habitacionId"));
                habitacion.setHabitacionCantidadDeCamas(resultSet.getInt("habitacion.habitacionCantidadDeCamas"));
                habitacion.setHabitacionEstado(resultSet.getBoolean("habitacion.habitacionEstado"));

                reserva.setHabitacionId(habitacion);
                
                huesped.setHuespedId(resultSet.getInt("huesped.huespedId"));
                huesped.setHuespedDni(resultSet.getInt("huesped.huespedDni"));
                huesped.setHuespedNombre(resultSet.getString("huesped.huespedNombre"));
                huesped.setHuespedDomicilio(resultSet.getString("huesped.huespedDomicilio"));
                
                reserva.setHuespedId(huesped);

                reserva.setReservasId(resultSet.getInt("reservas.reservasId"));
                reserva.setReservasFechaCheckin(resultSet.getDate("reservas.reservasFechaCheckin").toLocalDate());
                reserva.setReservasfechaCheckout(resultSet.getDate("reservas.reservasfechaCheckout").toLocalDate());
                reserva.setReservasDias(resultSet.getInt("reservas.reservasDias"));
                reserva.setReservasFechaCreacion(resultSet.getDate("reservas.reservasFechaCreacion").toLocalDate());
                reserva.setReservasEstado(resultSet.getBoolean("reservas.reservasEstado"));
                reserva.setReservasMonto(resultSet.getDouble("reservas.reservasMonto"));
                
                reservas.add(reserva);
            }
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener las habitaciones: " + ex.getMessage());
        }

        return reservas;
    }
 
    public void eliminarReserva(Reservas reserva) {

        try {
            String sql = "DELETE FROM reservas "
                    + "WHERE  reservasId = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, reserva.getReservasId());
            ResultSet resultSet = statement.executeQuery();
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener las habitaciones: " + ex.getMessage());
        }
    }

}   
