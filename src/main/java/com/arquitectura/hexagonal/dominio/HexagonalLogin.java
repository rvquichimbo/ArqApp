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
public class HexagonalLogin {

    //Declaración de variables
    private LoginValidacion loginInterace;
    private Display display;
    private String entUser;
    private String entPass;

    //Constructor para validar los datos ingresados por el usuario con la base de datos
    public HexagonalLogin(LoginValidacion loginInterface, Display display) {
        this.loginInterace = loginInterface;
        this.display = display;
    }

    //Método que permite realizar una consulta a la base de datos para ver si 
    //coinciden los datos ingresados por el usuario con los registrados en la base de datos.
    public boolean ingresoDato() throws SQLException {
        int numeroIntento = 1;
        int ingresoDatos_1 = 1;
        boolean correcto = false;
        while (numeroIntento <= 3) {
            while (ingresoDatos_1 <= 2) {
                presentarMensaje(ingresoDatos_1);
                ingresoDatos_1++;
            }
            //Conexion con la base de datos
            Conexion conectar = new Conexion();
            Connection reg = conectar.datos();

            Statement st = reg.createStatement();
            //consulta select a la base de datos
            ResultSet rs = st.executeQuery("SELECT username, contrasena FROM sismos.usuario where username='" + entUser + "' and contrasena ='" + entPass + "'");
            //comprueba si los datos ingresados consta en la base de datos
            while (rs.next()) {
                correcto = true;
                numeroIntento = 4;
            }
            //permite 3 intentos en caso de los datos ingresados sean incorrectos.
            if (!correcto) {
                datosIncorrectos();
                numeroIntento++;
                ingresoDatos_1 = 1;
                correcto = false;
            }
        }
        return correcto;
    }

    //Permite presentar mensajes para obtener el usuario y contraseña
    public void presentarMensaje(int intentos) {
        if (intentos == 1) {
            display.show("Usuario: ");
            entUser = loginInterace.ingresoDatos();
        } else {
            display.show("Contraseña: ");
            entPass = loginInterace.ingresoDatos();
        }

    }

    //Presenta mensaje en caso que los datos sean incorrectos.
    public void datosIncorrectos() {
        display.show("\n---- USUARIO Y/O CONTRASEÑA INCORRECTOS. ----\n");
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
