/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upb.tresenraya.bl;

import edu.upb.tresenraya.exception.CommandoIncorrectoException;
import java.util.regex.Pattern;

/**
 *
 * @author Usuario
 */
public class AceptarSolicitud extends Comando {
    private String nombre;

    public AceptarSolicitud() {
        super();
        super.setCodigoComando("0003");
    }
     public AceptarSolicitud(String nombre) {
        super();
        super.setCodigoComando("0003");
        this.nombre = nombre;
    }

    @Override
    public void parsear(String mensaje) throws Exception {
        String[] s = mensaje.split(Pattern.quote("|"));
        if (s.length != 2) {
            throw new CommandoIncorrectoException("Comando inválido");
        }
        super.setCodigoComando(s[0]);
        this.nombre = s[1];

    }

    @Override
    public String getComando() {
        return super.getCodigoComando() +"|"+ nombre +System.lineSeparator();
    }

    @Override
    public String toString() {
        return super.getCodigoComando() +"|"+ nombre +System.lineSeparator();
    }

}
