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
public class CamasHabitacionData {

    private Connection connection = null;
    private Conexion conexion;

    public CamasHabitacionData(Conexion conexion) {
        try {
            this.conexion = conexion;
            connection = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error al obtener la conexion");
        }
    }

    public void guardarCamasHabitacion(Habitacion habitacion, TipoCama tipoCama) {

        try {

            String sql = "INSERT INTO camashabitacion (habitacionId, tipoCamaId) VALUES ( ? , ?);";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.setInt(1, habitacion.getHabitacionId());
            statement.setInt(2, tipoCama.getTipoCamaId());

            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();

            statement.close();

        } catch (SQLException ex) {
            System.out.println("Error al insertar una habitacion y/o un tipo de cama: " + ex.getMessage());
        }
    }

    public List<CamasHabitacion> obtenerCamasporHabitacion(int tipoCamaId) {
        List<CamasHabitacion> camasEnHabitacion = new ArrayList<CamasHabitacion>();

        try {
            String sql = "SELECT * FROM camashabitacion WHERE tipoCamaId = ?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, tipoCamaId);

            ResultSet resultSet = statement.executeQuery();
            CamasHabitacion camasHabitacion;
            Habitacion habitacion;
            TipoCama tipoCama;

            while (resultSet.next()) {
                camasHabitacion = new CamasHabitacion();
                tipoCama = new TipoCama();
                habitacion = new Habitacion();

                camasHabitacion.setCamasHabitacionId(resultSet.getInt("camasHabitacionId"));
                habitacion.setHabitacionId(resultSet.getInt("habitacionId"));
                camasHabitacion.setHabitacionId(habitacion);
                tipoCama.setTipoCamaId(resultSet.getInt("tipoCamaId"));
                camasHabitacion.setTipoCamaId(tipoCama);
               

                camasEnHabitacion.add(camasHabitacion);
            }
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener las camas por habitacion: " + ex.getMessage());
        }

        return camasEnHabitacion;
    }

    public List<CamasHabitacion> obtenerCamasPorHabitacionId(int habitacionId) {
        List<CamasHabitacion> camasEnHabitacion = new ArrayList<CamasHabitacion>();

        try {
            String sql = "SELECT * FROM camashabitacion WHERE habitacionId = ?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, habitacionId);

            ResultSet resultSet = statement.executeQuery();

            CamasHabitacion camasHabitacion;
            Habitacion habitacion;
            TipoCama tipoCama;

            while (resultSet.next()) {
                camasHabitacion = new CamasHabitacion();
                habitacion = new Habitacion();
                tipoCama = new TipoCama();

                camasHabitacion.setCamasHabitacionId(resultSet.getInt("camasHabitacionId"));
                habitacion.setHabitacionId(resultSet.getInt("habitacionId"));
                camasHabitacion.setHabitacionId(habitacion);
                tipoCama.setTipoCamaId(resultSet.getInt("tipoCamaId"));
                camasHabitacion.setTipoCamaId(tipoCama);

                camasEnHabitacion.add(camasHabitacion);
            }
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener las camas por habitacion: " + ex.getMessage());
        }

        return camasEnHabitacion;
    }
}
