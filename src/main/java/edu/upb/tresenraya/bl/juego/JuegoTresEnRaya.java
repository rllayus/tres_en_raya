/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upb.tresenraya.bl.juego;

/**
 *
 * @author rlaredo
 */
public class JuegoTresEnRaya {
    private SimboloType turno;
    private SimboloType[][] tablero;

    public JuegoTresEnRaya() {
        iniciar();
    }

    public void iniciar() {
        tablero = new SimboloType[3][3];
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                tablero[i][j] = SimboloType.EMPTY;
            }
        }
    }
    
    public SimboloType[][] getTablero(){
        return tablero;
    }

    public SimboloType marcar(SimboloType simbolo, int posicionX, int posicionY) {
        if(!turno.equals(simbolo)){
            System.out.println("No es turno del jugador");
            return SimboloType.EMPTY;
        }
        if (posicionX < 0 && posicionX > 2) {
            System.out.println("Posicion fuera de lugar");
            return SimboloType.EMPTY;
        }
        if (posicionY < 0 && posicionY > 2) {
            System.out.println("Posicion fuera de lugar");
            return SimboloType.EMPTY;
        }

        if (!tablero[posicionX][posicionY].equals(SimboloType.EMPTY)) {
            System.out.println("La posición ya está ocupada");
            return SimboloType.EMPTY;
        }
        tablero[posicionX][posicionY] = simbolo;
        turno = turno == SimboloType.O? SimboloType.X: SimboloType.O;
        if(finPartida()){
            return mostrarGanador();
        }
        return SimboloType.EMPTY;
    }
    
    public SimboloType mostrarTurno(){
        return turno;
    }

    private SimboloType coincidenciaLinea() {
        SimboloType simbolo;
        boolean coincidencia;
        for (int i = 0; i < tablero.length; i++) {
            //Reiniciamos la coincidencia
            coincidencia = true;
            //Cogemos el simbolo de la fila
            simbolo = tablero[i][0];
            if (simbolo != SimboloType.EMPTY) {
                for (int j = 1; j < tablero[0].length; j++) {
                    //sino coincide ya no habra ganadro en esta fila
                    if (simbolo != tablero[i][j]) {
                        coincidencia = false;
                    }
                }
                //Si no se mete en el if, devuelvo el simbolo ganador
                if (coincidencia) {
                    return simbolo;
                }
            }
        }
        //Si no hay ganador, devuelvo el simbolo por defecto
        return SimboloType.EMPTY;
    }

    private SimboloType coincidenciaColumna() {
        SimboloType simbolo;
        boolean coincidencia;
        for (int j = 0; j < tablero.length; j++) {
            //Reiniciamos la coincidencia
            coincidencia = true;
            //Cogemos el simbolo de la columna
            simbolo = tablero[0][j];
            if (simbolo != SimboloType.EMPTY) {
                for (int i = 1; i < tablero[0].length; i++) {
                    //sino coincide ya no habra ganadro en esta fila
                    if (simbolo != tablero[i][j]) {
                        coincidencia = false;
                    }
                }
                //Si no se mete en el if, devuelvo el simbolo ganador
                if (coincidencia) {
                    return simbolo;
                }
            }
        }
        //Si no hay ganador, devuelvo el simbolo por defecto
        return SimboloType.EMPTY;
    }

    
    private SimboloType coincidenciaDiagonal() {

        SimboloType simbolo;
        boolean coincidencia = true;
        //Diagonal principal
        simbolo = tablero[0][0];
        if (simbolo != SimboloType.EMPTY) {
            for (int i = 1; i < tablero.length; i++) {
                //sino coincide ya no habra ganadro en esta fila
                if (simbolo != tablero[i][i]) {
                    coincidencia = false;
                }
            }
            //Si no se mete en el if, devuelvo el simbolo ganador
            if (coincidencia) {
                return simbolo;
            }
        }

        coincidencia = true;
        //Diagonal inversa
        simbolo = tablero[0][2];
        if (simbolo != SimboloType.EMPTY) {
            for (int i = 1, j = 1; i < tablero.length; i++, j--) {
                //sino coincide ya no habra ganadro en esta fila
                if (simbolo != tablero[i][j]) {
                    coincidencia = false;
                }
            }

            //Si no se mete en el if, devuelvo el simbolo ganador
            if (coincidencia) {
                return simbolo;
            }
        }
        //Si no hay ganador, devuelvo el simbolo por defecto
        return SimboloType.EMPTY;
    }

    public boolean tableroLleno() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if (tablero[i][j] == SimboloType.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }



public SimboloType mostrarGanador() {
        SimboloType simbolo = coincidenciaLinea();
        if (simbolo != SimboloType.EMPTY) {   
            return simbolo;
        }
        simbolo = coincidenciaColumna();

        if (simbolo != SimboloType.EMPTY) {
          
            return simbolo;
        }
        simbolo = coincidenciaDiagonal();
        if (simbolo != SimboloType.EMPTY) {
            return simbolo;
        }
        
        return SimboloType.EMPATE;
    }

    public boolean finPartida() {
        if (tableroLleno()
                || coincidenciaLinea() != SimboloType.EMPTY
                || coincidenciaColumna() != SimboloType.EMPTY
                || coincidenciaDiagonal() != SimboloType.EMPTY) {
            return true;
        }
        return false;
    }
}
