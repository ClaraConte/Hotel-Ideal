/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    private String url;
    private String usuario;
    private String password;

    private Connection conexion;
    
    public Conexion(String url, String usuario, String password) throws ClassNotFoundException {
        this.url = url;
        this.usuario = usuario;
        this.password = password;

        Class.forName("org.mariadb.jdbc.Driver");
    }

    public Conexion() throws ClassNotFoundException {
        this.url = "jdbc:mysql://192.168.64.2/Hotel";
        this.usuario = "propietario";
        this.password = "1234";
        
        Class.forName("org.mariadb.jdbc.Driver");
    }

    public Connection getConexion() throws SQLException{
        if(conexion == null){
            conexion = DriverManager
                .getConnection(url + "?useLegacyDatetimeCode=false&serverTimezone=UTC"
                        + "&user=" + usuario + "&password=" + password);
        }
        return conexion;
    }
    
}
