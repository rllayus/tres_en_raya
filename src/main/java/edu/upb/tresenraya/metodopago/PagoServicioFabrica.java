/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upb.tresenraya.metodopago;

/**
 *
 * @author Usuario
 */
public class PagoServicioFabrica {
    public PagoServicio create(String codigo){
        if(codigo.equals("100")) return new PagoCre();
        
        if(codigo.equals("101")) return new PagoSaguapac();
        return null;
    }
    
}
