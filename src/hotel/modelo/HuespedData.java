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
 * @author Marcelo
 */
public class HuespedData {

    private Connection connection = null;

    public HuespedData(Conexion conexion) {
        try {
            connection = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error al abrir al obtener la conexion");
        }
    }

    /* @author Jesica*/
    public void guardarHuesped(Huesped huesped) {
        try {

            String sql = "INSERT INTO huesped (huespedDni, huespedNombre, huespedDomicilio, huespedEmail, huespedCelular) VALUES ( ? , ? , ?, ?, ? );";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, huesped.getHuespedDni());
            statement.setString(2, huesped.getHuespedNombre());
            statement.setString(3, huesped.getHuespedDomicilio());
            statement.setString(4, huesped.getHuespedEmail());
            statement.setString(5, huesped.getHuespedCelular());

            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                huesped.setHuespedId(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id luego de insertar un huesped");
            }
            statement.close();

        } catch (SQLException ex) {
            System.out.println("Error al insertar un huesped: " + ex.getMessage());
        }
    }

    public void editarHuesped(Huesped huesped) {
        try {

            String sql = "UPDATE huesped SET huespedDni = ?, huespedNombre = ? , huespedDomicilio = ? , huespedEmail = ? , huespedCelular = ? WHERE huespedDni = ?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, huesped.getHuespedDni());
            statement.setString(2, huesped.getHuespedNombre());
            statement.setString(3, huesped.getHuespedDomicilio());
            statement.setString(4, huesped.getHuespedEmail());
            statement.setString(5, huesped.getHuespedCelular());

            statement.setInt(6, huesped.getHuespedDni());

            statement.executeUpdate();
            statement.close();

        } catch (SQLException ex) {
            System.out.println("Error al editar un huesped: " + ex.getMessage());
        }
    }

    public Huesped buscarHuesped(int huespedDni) {
        Huesped huesped = null;
        try {

            String sql = "SELECT * FROM huesped WHERE huespedDni = ?;";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, huespedDni);

            //System.out.printnl(Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                huesped = new Huesped();
                huesped.setHuespedId(resultSet.getInt("huespedId"));
                huesped.setHuespedDni(resultSet.getInt("huespedDni"));
                huesped.setHuespedNombre(resultSet.getString("huespedNombre"));
                huesped.setHuespedDomicilio(resultSet.getString("huespedDomicilio"));
                huesped.setHuespedEmail(resultSet.getString("huespedEmail"));
                huesped.setHuespedCelular(resultSet.getString("huespedCelular"));

            }
            statement.close();

        } catch (SQLException ex) {
            System.out.println("Error al mostrar huesped por ID: " + ex.getMessage());
        }

        return huesped;
    }
        public boolean isHuespedDni(int huespedDni) {
        Huesped huesped = null;
        boolean data = false;
        try {

            String sql = "SELECT * FROM huesped WHERE huespedDni = ?;";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, huespedDni);
            ResultSet resultSet = statement.executeQuery();

            data = resultSet.first();
            statement.close();

        } catch (SQLException ex) {
            System.out.println("Error al mostrar huesped por ID: " + ex.getMessage());
        }
        return data;
    }

    public void borrarHuesped(int huespedDni) {
        try {

            String sql = "DELETE FROM huesped WHERE huespedDni =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, huespedDni);

            statement.executeUpdate();

            statement.close();

        } catch (SQLException ex) {
            System.out.println("Error al borrar un huesped: " + ex.getMessage());
        }
    }

    public List<Huesped> obtenerHuespedes() {
        List<Huesped> huespedes = new ArrayList<Huesped>();

        try {
            String sql = "SELECT * FROM  huesped;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Huesped huesped;

            while (resultSet.next()) {
                huesped = new Huesped();
                huesped.setHuespedId(resultSet.getInt("huespedId"));
                huesped.setHuespedDni(resultSet.getInt("huespedDni"));
                huesped.setHuespedNombre(resultSet.getString("huespedNombre"));
                huesped.setHuespedDomicilio(resultSet.getString("huespedDomicilio"));
                huesped.setHuespedEmail(resultSet.getString("huespedEmail"));
                huesped.setHuespedCelular(resultSet.getString("huespedCelular"));

                huespedes.add(huesped);
            }
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los huespedes " + ex.getMessage());
        }
        return huespedes;

    }
}
