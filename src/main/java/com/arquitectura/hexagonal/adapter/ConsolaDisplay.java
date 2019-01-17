package com.arquitectura.hexagonal.adapter;

import com.arquitectura.hexagonal.dominio.Display;

/**
 *
 * @author rober
 */
public class ConsolaDisplay implements Display {

    //permite mostrar texto por consola.
    @Override
    public void show(String texto) {
        System.out.println(texto);
    }

    @Override
    public void showNew(String texto) {
        System.out.println(texto);
    }
}
