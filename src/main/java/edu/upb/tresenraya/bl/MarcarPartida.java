/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upb.tresenraya.bl;

import edu.upb.tresenraya.exception.CommandoIncorrectoException;
import java.util.regex.Pattern;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Usuario
 */
@Getter
@Setter
public class MarcarPartida extends Comando {

    private String simbolo;
    private int posicionX, posicionY;

    public MarcarPartida() {
        super();
        super.setCodigoComando("0008");
    }

    public MarcarPartida(String simbolo, int posicionX, int posicionY) {
        super.setCodigoComando("0008");
        this.simbolo = simbolo;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }

    @Override
    public void parsear(String mensaje) throws Exception {
        String[] s = mensaje.split(Pattern.quote("|"));
        if (s.length != 4) {
            throw new CommandoIncorrectoException("Comando inválido");
        }
        super.setCodigoComando(s[0]);
        this.simbolo = s[1];
        this.posicionX = Integer.parseInt(s[2]);
        this.posicionY = Integer.parseInt(s[3]);
    }

    @Override
    public String getComando() {
        return super.getCodigoComando() + "|" + simbolo + "|" + posicionX + "|" + posicionY + System.lineSeparator();
    }

    @Override
    public String toString() {
        return super.getCodigoComando() + "|" + simbolo + "|" + posicionX + "|" + posicionY + System.lineSeparator();
    }

}
