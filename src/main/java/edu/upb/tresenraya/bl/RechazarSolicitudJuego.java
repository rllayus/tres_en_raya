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
public class RechazarSolicitudJuego extends Comando{
    
    public RechazarSolicitudJuego(){
        super();
        super.setCodigoComando("0005");
    }
    
   
    @Override
    public void parsear(String mensaje)throws Exception{
        String [] s = mensaje.split(Pattern.quote("|"));
        if(s.length != 1){
            throw new CommandoIncorrectoException("Comando inválido");
        }
        super.setCodigoComando(s[0]);
     
    }

    @Override
    public String getComando() {
        return super.getCodigoComando()+ "|" + System.lineSeparator();
    }

    @Override
    public String toString() {
        return super.getCodigoComando()+ "|" +  System.lineSeparator();
    }
    
    
}
