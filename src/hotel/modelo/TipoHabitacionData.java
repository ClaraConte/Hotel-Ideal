/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.modelo;

/**
 *
 * @author clara
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TipoHabitacionData {

    private Connection connection = null;
    private Conexion conexion;

    public TipoHabitacionData(Conexion conexion) {
        try {
            this.conexion = conexion;
            connection = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error al obtener la conexion");
        }
    }

    public void borrarTipoHabitacion(int tipoHabitacionId) {
        try {

            String sql = "DELETE FROM tipohabitacion WHERE tipoHabitacionId =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, tipoHabitacionId);

            statement.executeUpdate();

            statement.close();

        } catch (SQLException ex) {
            System.out.println("Error al borrar un tipo de habitacion: " + ex.getMessage());
        }
    }

    public void editarTipoHabitacion(TipoHabitacion tipoHabitacion) {
        try {

            String sql = "UPDATE tipohabitacion SET tipoHabitacionNombre = ?, tipoHabitacioCapacidadMax = ?, tipoHabitacionPrecio = ? WHERE tipoHabitacionId = ?;";

            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setString(1, tipoHabitacion.getTipoHabitacionNombre());
            statement.setInt(2, tipoHabitacion.getTipoHabitacioCapacidadMax());
            statement.setDouble(3, tipoHabitacion.getTipoHabitacionPrecio());
            statement.setInt(4, tipoHabitacion.getTipoHabitacionId());

            statement.executeUpdate();

            //ResultSet rs = statement.getGeneratedKeys();

            /*if (rs.next()) {
                tipoHabitacion.setTipoHabitacionId(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id luego de insertar un tipoHabitacion");
            }*/

            statement.close();

        } catch (SQLException ex) {
            System.out.println("Error al editar un tipo de habitacion: " + ex.getMessage());
        }
    }

    public void guardarTipoHabitacion(TipoHabitacion tipoHabitacion) {
        try {

            String sql = "INSERT INTO tipohabitacion (tipoHabitacionId, tipoHabitacionNombre, tipoHabitacioCapacidadMax, tipoHabitacionPrecio) VALUES ( ? , ? , ?, ?);";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, tipoHabitacion.getTipoHabitacionId());
            statement.setString(2, tipoHabitacion.getTipoHabitacionNombre());
            statement.setInt(3, tipoHabitacion.getTipoHabitacioCapacidadMax());
            statement.setDouble(4, tipoHabitacion.getTipoHabitacionPrecio());

            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                tipoHabitacion.setTipoHabitacionId(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id luego de insertar un tipoHabitacion");
            }
            statement.close();

        } catch (SQLException ex) {
            System.out.println("Error al insertar un tipoHabitacion: " + ex.getMessage());
        }
    }

    public TipoHabitacion buscarTipoHabitacion(int tipoHabitacionId) {
        TipoHabitacion tipoHabitacion = null;
        try {

            String sql = "SELECT * FROM tipohabitacion WHERE tipoHabitacionId =?;";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, tipoHabitacionId);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                tipoHabitacion = new TipoHabitacion();
                tipoHabitacion.setTipoHabitacionId(resultSet.getInt("tipoHabitacionId"));
                tipoHabitacion.setTipoHabitacionNombre(resultSet.getString("tipoHabitacionNombre"));
                tipoHabitacion.setTipoHabitacionPrecio(resultSet.getDouble("tipoHabitacionPrecio"));
                tipoHabitacion.setTipoHabitacioCapacidadMax(resultSet.getInt("tipoHabitacioCapacidadMax"));
            }
            statement.close();

        } catch (SQLException ex) {
            System.out.println("Error al mostrar tipoHabitacion por ID: " + ex.getMessage());
        }

        return tipoHabitacion;
    }

    public List<TipoHabitacion> obtenerTipoHabitacion() {
        List<TipoHabitacion> tipoHabitaciones = new ArrayList<TipoHabitacion>();

        try {
            String sql = "SELECT * FROM tipohabitacion;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            TipoHabitacion tipoHabitacion;
            while (resultSet.next()) {
                tipoHabitacion = new TipoHabitacion();
                tipoHabitacion.setTipoHabitacionId(resultSet.getInt("tipoHabitacionId"));
                tipoHabitacion.setTipoHabitacionNombre(resultSet.getString("tipoHabitacionNombre"));
                tipoHabitacion.setTipoHabitacioCapacidadMax(resultSet.getInt("tipoHabitacioCapacidadMax"));
                tipoHabitacion.setTipoHabitacionPrecio(resultSet.getDouble("tipoHabitacionPrecio"));

                tipoHabitaciones.add(tipoHabitacion);
            }
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los tipos de habitacion: " + ex.getMessage());
        }

        return tipoHabitaciones;
    }

    public int buscaMaxCapacidadDeHabitacion() {
        int max = 0;
        try {
            String sql = "SELECT MAX(tipoHabitacioCapacidadMax) as capacidad FROM tipohabitacion;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
              max = resultSet.getInt("capacidad");
            }
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los tipos de habitacion: " + ex.getMessage());
        }
        return max;
    }
}
