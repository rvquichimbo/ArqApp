package com.arquitectura.hexagonal.adapter;

import com.arquitectura.hexagonal.dominio.ConexionInterface;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rober
 */
public class Conexion implements ConexionInterface {

    public static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";

    @Override
    //conexión a la base de datos
    public Connection datos() {
        Connection con = null;
        String serviceURL = "jdbc:mysql://localhost:3306/sismos";
        try {
            con = DriverManager.getConnection(serviceURL, "root", "ticowrc2017");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return con;
    }

}
