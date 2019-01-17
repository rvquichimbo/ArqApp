package com.arquitectura.hexagonal.dominio;

/**
 *
 * @author rober
 */
public interface Display {

    //Metodo abstracto para mostrar texto por consola.
    void show(String texto);
    //Metodo abstracto para mostrar texto de ingreso de usuario.
    void showNew(String texto);
    
}
