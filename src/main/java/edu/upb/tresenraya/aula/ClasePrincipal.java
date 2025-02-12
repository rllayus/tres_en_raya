/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upb.tresenraya.aula;

import edu.upb.tresenraya.db.ConexionDb;

/**
 *
 * @author Usuario
 */
public class ClasePrincipal {
    public static void main(String[] args) {
        Persona p = new PersonaNatural();
        p.caminar();
        
        Persona pn = new PersonaJuridica();
       
        Hombre h = new Hombre();
        h.generarTelaAraña();
       ConexionDb.intance().getConnection();
    }
}
