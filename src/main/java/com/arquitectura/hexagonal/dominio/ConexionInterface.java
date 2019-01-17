package com.arquitectura.hexagonal.dominio;

import java.sql.Connection;

/**
 *
 * @author rober
 */
public interface ConexionInterface {
    //Método abstracto para la conexión a la base de datos.
    Connection datos();
}
