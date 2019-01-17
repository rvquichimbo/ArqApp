package com.arquitectura.hexagonallogin;

import com.arquitectura.hexagonal.adapter.ConsolaDisplay;
import com.arquitectura.hexagonal.dominio.LoginValidacion;
import com.arquitectura.hexagonal.adapter.TecladoLogin;
import com.arquitectura.hexagonal.dominio.Display;
import com.arquitectura.hexagonal.dominio.HexagonalData;
import com.arquitectura.hexagonal.dominio.HexagonalLogin;
import com.arquitectura.hexagonal.dominio.HexagonalSignUp;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author rober
 */
public class Login {

    public static void main(String[] args) throws SQLException {
        int opc;
        Scanner sc = new Scanner(System.in);
        //Declaración de objetos
        Display mensaje = new ConsolaDisplay();
        LoginValidacion datos = new TecladoLogin();
        System.out.println("¿Qué acción desea realizar?\n");
        System.out.println("===========================\n");
        System.out.println("1. Iniciar sesión\n");
        System.out.println("2. Registrarse\n");
        opc = sc.nextInt();
        if(opc == 1){
            new HexagonalLogin(datos, mensaje).validar();
            new HexagonalData().validar();
        } else if(opc == 2){
            new HexagonalSignUp(datos, mensaje).validar();
        }        
    }
}
