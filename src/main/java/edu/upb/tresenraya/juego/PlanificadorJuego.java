/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upb.tresenraya.juego;

/**
 *
 * @author Usuario
 */
public class PlanificadorJuego {
    private char [][] tablero;
    
    public PlanificadorJuego(){
        tablero = new char[3][3];
    }
    private void inicializar(){
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < 10; j++) {
                tablero[i][j]= Character.MIN_VALUE;
            }
        }
    }
    public void marcar(int i, int j, char simbolo){
        
    }
    
}
