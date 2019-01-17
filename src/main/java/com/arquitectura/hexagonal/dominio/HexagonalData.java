/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arquitectura.hexagonal.dominio;

import com.arquitectura.hexagonal.adapter.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author rober
 */
public class HexagonalData {

    private LoginValidacion loginInterace;
    private Display display;
    private String entUser;
    private String entPass;

    //Constructor para validar los datos ingresados por el usuario con la base de datos
    public HexagonalData() {
//        this.loginInterace = loginInterface;
//        this.display = display;
    }

    //Método que permite realizar una consulta a la base de datos para ver si 
    //coinciden los datos ingresados por el usuario con los registrados en la base de datos.
    public boolean ingresoDato() throws SQLException {
        boolean correcto = false;

        //Conexion con la base de datos
        Conexion conectar = new Conexion();
        Connection reg = conectar.datos();

        Statement st = reg.createStatement();
        //consulta select a la base de datos
        ResultSet rs = st.executeQuery("SELECT * FROM evento");
        System.out.println(rs);

        //comprueba si los datos ingresados consta en la base de datos
        while (rs.next()) {
            int id = rs.getInt(1);
            String fecha = rs.getString(2);
            String hora = rs.getString(3);
            String estacion = rs.getString(4);
            String longitud = rs.getString(5);
            String latitud = rs.getString(6);
            System.out.println("Evento No "+id+
            "\n Fecha: "+fecha+
            "\n Hora: "+hora+
            "\n Estacion: "+estacion+
            "\n Longitud: "+longitud+
            "\n Latitud: "+latitud);
            System.out.println("====================");
        }
        //permite 3 intentos en caso de los datos ingresados sean incorrectos.
        if (!correcto) {
            correcto = false;
        }

        return correcto;
    }

    //Permite presentar mensajes para obtener el usuario y contraseña
//    public void presentarMensaje(int intentos) {
//        if (intentos == 1) {
//            display.show("Usuario: ");
//            entUser = loginInterace.ingresoDatos();
//        } else {
//            display.show("Contraseña: ");
//            entPass = loginInterace.ingresoDatos();
//        }
//
//    }

    //Presenta mensaje en caso que los datos sean incorrectos.
    public void datosIncorrectos() {
        display.show("\n---- DATOS INGRESADOS NO VÁLIDOS ----\n");
    }

    public void validar() throws SQLException {
        resultado(ingresoDato());
    }

    //metodo para mostrar una introducción de ingreso al sistema
    private void presentarIntroduccion() {
        display.show("\n\n***** BIENVENIDO/A " + entUser.toUpperCase() + " *****\n");
        display.show("** SU INGRESO HA SIDO EXITOSO. **\n");
    }

    //En caso de ser correcto el ingreso presenta la introducción caso contrario 
    //mensaje informativo.
    private void resultado(boolean correctamente) {
        if (correctamente) {
            presentarIntroduccion();
        } else {
            display.show("\n\n---- NO SE HA PODIDO INGRESAR AL SISTEMA. ----");
        }

    }
}
