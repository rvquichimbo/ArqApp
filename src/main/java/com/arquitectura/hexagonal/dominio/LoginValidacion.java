package com.arquitectura.hexagonal.dominio;

/**
 *
 * @author rober
 */
public interface LoginValidacion {

    //Metodo abstracto para la comprobación de los datos ingresados.
    String ingresoDatos();
    //Metodo abstracto para ingresar usuarios
    String nuevoUsuario();
}
