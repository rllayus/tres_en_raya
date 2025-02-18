/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upb.tresenraya.builder;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 *
 * @author Usuario
 */
@Builder
@ToString
@Data
public class Universidad {
    private String nombre;
    private int cantidadAulas; 
   
}
