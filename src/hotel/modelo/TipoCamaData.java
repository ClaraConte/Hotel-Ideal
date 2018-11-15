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
public class TipoCamaData {

    private Connection connection = null;
    private Conexion conexion;

    public TipoCamaData(Conexion conexion) {
        try {
            this.conexion = conexion;
            connection = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error al abrir al obtener la conexion");
        }
    }

    public void guardarTipoCama(TipoCama tipoCama) {

        try {

            String sql = "INSERT INTO tipoCama (tipoCamaId, tipoCamaNombre) VALUES ( ? , ?);";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.setInt(1, tipoCama.getTipoCamaId());
            statement.setString(2, tipoCama.getTipoCamaNombre());

            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();

            statement.close();

        } catch (SQLException ex) {
            System.out.println("Error al insertar un tipo de cama: " + ex.getMessage());
        }
    }

    public TipoCama buscarTipoCamaPorId(int tipoCamaId) {
        TipoCama tipoCama = new TipoCama();
        try {

            String sql = "SELECT * FROM tipocama WHERE tipoCamaId =?;";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, tipoCamaId);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                tipoCama = new TipoCama();
                tipoCama.setTipoCamaId(resultSet.getInt("tipoCamaId"));
                tipoCama.setTipoCamaNombre(resultSet.getString("tipoCamaNombre"));
            }
            statement.close();

        } catch (SQLException ex) {
            System.out.println("Error al insertar una cama: " + ex.getMessage());
        }

        return tipoCama;
    }

}
