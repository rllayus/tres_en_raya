/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upb.tresenraya.builder;

/**
 *
 * @author Usuario
 */
public class EstudianteBuilder {
    private Estudiante estudiante;
    
    public EstudianteBuilder(){
        this.estudiante = new Estudiante();
    }
    
    public EstudianteBuilder nombre(String nombre){
        this.estudiante.setNombre(nombre);
        return this;
    }
    
    public EstudianteBuilder codigo(String codigo){
        this.estudiante.setCodigo(codigo);
        return this;
    }
    
    public Estudiante build(){
        return this.estudiante;
    }
    
}
