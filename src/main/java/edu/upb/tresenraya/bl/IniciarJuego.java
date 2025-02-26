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
public class IniciarJuego extends Comando {
    private String simbolo;

    public IniciarJuego() {
        super();
        super.setCodigoComando("0004");
    }
    public IniciarJuego(String simbolo){
        super.setCodigoComando("0004");
        this.simbolo = simbolo;
    }

    @Override
    public void parsear(String mensaje) throws Exception {
        String[] s = mensaje.split(Pattern.quote("|"));
        if (s.length != 2) {
            throw new CommandoIncorrectoException("Comando inválido");
        }
        super.setCodigoComando(s[0]);
        simbolo = s[1];

    }

    @Override
    public String getComando() {
        return super.getCodigoComando() + "|"+ simbolo+ System.lineSeparator();
    }

    @Override
    public String toString() {
        return super.getCodigoComando() + "|"+ simbolo+ System.lineSeparator();
    }

}
