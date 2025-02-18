/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upb.tresenraya.builder;

/**
 *
 * @author Usuario
 */
public class Persona {
    private String nombre;
    private String apellido;


    public static PersonaBuilder builder() {
        return new PersonaBuilder();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
   

    @Override
    public String toString() {
        return "Persona ["+ nombre +","+ apellido+"]";
    }

}
