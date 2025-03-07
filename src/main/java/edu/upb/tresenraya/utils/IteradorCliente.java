/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upb.tresenraya.utils;

/**
 *
 * @author Usuario
 */
public class IteradorCliente {
    public static void main(String[] args) {
        MyCollection<String> myColeccion = new MyCollection<>();
        myColeccion.add("1");
        myColeccion.add("2");
        myColeccion.add("3");
        myColeccion.add("4");
        myColeccion.add("5");
        myColeccion.add("6");
        myColeccion.add("7");
        myColeccion.add("8");
        myColeccion.add("9");
        myColeccion.add("10");
        while (myColeccion.hasNext()) {
            String next = myColeccion.getNext();
            System.out.println(next);
        }
    }
}
