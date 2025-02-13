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
public class Principal {
    
    public static void main(String[] args) {
        MetodoPago metodoPago = MetodoPago.create("QR");
        metodoPago.cobrar(new BigDecimal(10));
        
        MetodoPago tarjeta = MetodoPago.create("Tarjeta");
        metodoPago.cobrar(new BigDecimal(10));
    }
}
