/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author clara
 */
public class HabitacionData {

    private Connection connection = null;

    public HabitacionData(Conexion conexion) {
        try {
            connection = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error al obtener la conexion");
        }
    }

    public List<Habitacion> obtenerHabitaciones() {
        List<Habitacion> habitaciones = new ArrayList<Habitacion>();

        try {
            String sql = "SELECT * FROM habitacion;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Habitacion habitacion;
            while (resultSet.next()) {
                habitacion = new Habitacion();
                habitacion.setHabitacionId(resultSet.getInt("habitacionId"));
                habitacion.setHabitacionCantidadDeCamas(resultSet.getInt("habitacionCantidadDeCamas"));
                habitacion.setHabitacionEstado(resultSet.getBoolean("habitacionEstado"));

                //habitacion.setTipoHabitacionId(resultSet.getInt("tipoHabitacionId"));                

                habitaciones.add(habitacion);
            }
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener las habitaciones: " + ex.getMessage());
        }

        return habitaciones;
    }
    
    public List<Habitacion> obtenerHabitacionesPorTipo(int tipoHabitacionId) {
    List<Habitacion> habitaciones = new ArrayList<Habitacion>();    

        try {
            String sql = "SELECT * FROM habitacion WHERE tipoHabitacionId = ?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, tipoHabitacionId);

            ResultSet resultSet = statement.executeQuery();
            Habitacion habitacion;
            TipoHabitacion tipoHabitacion;

            while (resultSet.next()) {
                habitacion = new Habitacion();
                tipoHabitacion = new TipoHabitacion();

                habitacion.setHabitacionId(resultSet.getInt("habitacionId"));
                habitacion.setHabitacionCantidadDeCamas(resultSet.getInt("habitacionCantidadDeCamas"));
                habitacion.setHabitacionEstado(resultSet.getBoolean("habitacionEstado"));
                tipoHabitacion.setTipoHabitacionId(resultSet.getInt("tipoHabitacionId"));
                habitacion.setTipoHabitacionId(tipoHabitacion);

                habitaciones.add(habitacion);
            }
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener las habitaciones: " + ex.getMessage());
        }

        return habitaciones;
    
    }

    public Habitacion buscarHabitacion(int habitacionId) {
        Habitacion habitacion = null;
        TipoHabitacion tipoHabitacion;

        try {

            String sql = "SELECT * FROM habitacion WHERE habitacionId = ?;";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, habitacionId);

            //System.out.printnl(Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                habitacion = new Habitacion();
                tipoHabitacion = new TipoHabitacion();
                habitacion.setHabitacionId(resultSet.getInt("habitacionId"));
                habitacion.setHabitacionCantidadDeCamas(resultSet.getInt("habitacionCantidadDeCamas"));
                habitacion.setHabitacionEstado(resultSet.getBoolean("habitacionEstado"));

                tipoHabitacion.setTipoHabitacionId(resultSet.getInt("tipoHabitacionId"));
                habitacion.setTipoHabitacionId(tipoHabitacion);

            }
            statement.close();

        } catch (SQLException ex) {
            System.out.println("Error al mostrar habitación por ID: " + ex.getMessage());
        }

        return habitacion;

    }

    public void guardarHabitacion(Habitacion habitacion) {
        try {

            String sql = "INSERT INTO habitacion (habitacionCantidadDeCamas, habitacionEstado, tipoHabitacionId) VALUES ( ? , ? , ? );";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, habitacion.getHabitacionCantidadDeCamas());
            statement.setBoolean(2, habitacion.isHabitacionEstado());
            statement.setInt(3, habitacion.getTipoHabitacionId().getTipoHabitacionId());

            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                habitacion.setHabitacionId(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el ID luego de insertar una habitación");
            }
            statement.close();

        } catch (SQLException ex) {
            System.out.println("Error al insertar una habitación: " + ex.getMessage());
        }
    }

    public void editarHabitacion(Habitacion habitacion) {
        try {

            String sql = "UPDATE habitacion SET  habitacionCantidadDeCamas = ? , habitacionEstado = ? , tipoHabitacionId = ? WHERE habitacionId = ?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, habitacion.getHabitacionCantidadDeCamas());
            statement.setBoolean(2, habitacion.isHabitacionEstado());
            statement.setInt(3, habitacion.getTipoHabitacionId().getTipoHabitacionId());

            statement.setInt(4, habitacion.getHabitacionId());

            statement.executeUpdate();
            statement.close();

        } catch (SQLException ex) {
            System.out.println("Error al editar un huesped: " + ex.getMessage());
        }
    }
      public List<Habitacion> obtenerHabitacionesCantCamas(int habitacionCantidadDeCamas) {
    List<Habitacion> camas = new ArrayList<Habitacion>();    

        try {
            String sql = "SELECT * FROM habitacion WHERE habitacionCantidadDeCamas = ?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, habitacionCantidadDeCamas);

            ResultSet resultSet = statement.executeQuery();
            Habitacion habitacion;
            TipoHabitacion tipoHabitacion;

            while (resultSet.next()) {
                habitacion = new Habitacion();
                tipoHabitacion = new TipoHabitacion();

                habitacion.setHabitacionId(resultSet.getInt("habitacionId"));
                habitacion.setHabitacionCantidadDeCamas(resultSet.getInt("habitacionCantidadDeCamas"));
                habitacion.setHabitacionEstado(resultSet.getBoolean("habitacionEstado"));
                tipoHabitacion.setTipoHabitacionId(resultSet.getInt("tipoHabitacionId"));
                habitacion.setTipoHabitacionId(tipoHabitacion);

                camas.add(habitacion);
}
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener las camas: " + ex.getMessage());
        }

        return camas;
    
    }
    
}
