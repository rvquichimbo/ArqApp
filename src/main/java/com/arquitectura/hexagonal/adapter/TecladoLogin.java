package com.arquitectura.hexagonal.adapter;

import com.arquitectura.hexagonal.dominio.LoginValidacion;
import java.util.Scanner;

/**
 *
 * @author rober
 */
public class TecladoLogin implements LoginValidacion {

    @Override
    //Permite obtener los datos ingresados por teclado.
    public String ingresoDatos() {
        Scanner teclado = new Scanner(System.in);
        return teclado.nextLine();
    }

    @Override
    public String nuevoUsuario() {
        Scanner teclado = new Scanner(System.in);
        return teclado.nextLine();
    }
}
