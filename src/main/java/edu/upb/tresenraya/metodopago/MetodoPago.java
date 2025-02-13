/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upb.tresenraya.metodopago;

import java.math.BigDecimal;

/**
 *
 * @author Usuario
 */
public abstract class MetodoPago {
    private BigDecimal monto;
    private String nombre;

    public MetodoPago( String nombre) {
        this.nombre = nombre;
    }
    
    public static MetodoPago create(String name){
        if(name.equals("QR")){
            return new MetodoPagoQr();
        }
        
        if(name.equals("Tarjeta")){
            return new MetodoPagoQr();
        }
        return null;
    }
    
    protected abstract String cobrar(BigDecimal monto);
  
    
}
