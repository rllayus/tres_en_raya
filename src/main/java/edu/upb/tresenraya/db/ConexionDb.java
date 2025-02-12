/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upb.tresenraya.db;

import java.sql.Connection;

/**
 * Es una clase Singleton, 
 * @author Usuario
 */
public class ConexionDb {
    private String url;
    private String user;
    private String contraseña;
    private int puerto;
    // variable estatica de la misma clase
    private static final ConexionDb db ;
    
    static{
        db = new ConexionDb();
    }

    // constructor privado
    private ConexionDb() {
        System.out.println("Iniciando Singletton");
    }
    // metodo para obtener la instancia del singleton
    public static ConexionDb intance() {
        return db;
    }

    public Connection getConnection() {
        // conexion a la base de datos
        return null;
    }

}
