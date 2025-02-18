/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upb.tresenraya.builder;

/**
 *
 * @author Usuario
 */
public class MainBuilder {
    public static void main(String[] args) {
        
        Persona p = Persona.builder()
                .nombre("Ricardo")
                .apellido("Laredo")
       
                .build();
        
        Estudiante.builder().nombre("AMINA").codigo("1234").build();
        
        Universidad u = Universidad.builder().nombre("UPB").build();
        System.out.println(u);
        
    }
}
