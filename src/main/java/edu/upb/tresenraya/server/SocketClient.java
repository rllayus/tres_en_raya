/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upb.tresenraya.server;

import edu.upb.tresenraya.bl.AceptarSolicitud;
import edu.upb.tresenraya.bl.AceptarSolicitudJuego;
import edu.upb.tresenraya.bl.Comando;
import edu.upb.tresenraya.bl.Contactos;
import edu.upb.tresenraya.bl.IniciarJuego;
import edu.upb.tresenraya.bl.MarcarPartida;
import edu.upb.tresenraya.bl.MediadorContactos;
import edu.upb.tresenraya.bl.NuevaPartida;
import edu.upb.tresenraya.bl.RechazarSolicitud;
import edu.upb.tresenraya.bl.RechazarSolicitudJuego;
import edu.upb.tresenraya.bl.SolicitudConexion;
import edu.upb.tresenraya.exception.CommandoIncorrectoException;
import edu.upb.tresenraya.mediador.Mediador;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.Getter;

/**
 * @author rlaredo
 */
@Getter
public class SocketClient extends Thread {

    private final Socket socket;
    private final String ip;
    private final DataOutputStream dout;
    private final BufferedReader br;

    public SocketClient(Socket socket) throws IOException {
        this.socket = socket;
        this.ip = socket.getInetAddress().getHostAddress();
        dout = new DataOutputStream(socket.getOutputStream());
        br = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
    }

    @Override
    public void run() {
        try {
            String message;
            while ((message = br.readLine()) != null) {
                System.out.println("Comando: " + message);
                try {
                    Comando c = null;
                    if (message.contains("0001")) {
                        c = new SolicitudConexion();
                        c.parsear(message);
                    }
                    if (message.contains("0002")) {
                        c = new RechazarSolicitud();
                        c.parsear(message);
                    }
                    if (message.contains("0003")) {
                        c = new AceptarSolicitud();
                        c.parsear(message);
                    }
                    if (message.contains("0004")) {
                        c = new IniciarJuego();
                        c.parsear(message);
                    }
                    if (message.contains("0005")) {
                        c = new RechazarSolicitudJuego();
                        c.parsear(message);
                    }
                    if (message.contains("0006")) {
                        c = new AceptarSolicitudJuego();
                        c.parsear(message);
                    }
                    if (message.contains("0007")) {
                        c = new NuevaPartida();
                        c.parsear(message);
                    }

                    if (message.contains("0008")) {
                        c = new MarcarPartida();
                        c.parsear(message);
                    }

                    if (c != null) {
                        c.setIp(ip);
                        Mediador.sendMessage(c);
                    }
                } catch (CommandoIncorrectoException e) {
                    System.out.println("Error en la intepretacion del comando: " + message);
                } catch (Exception ex) {
                    Logger.getLogger(SocketClient.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (IOException e) {
            MediadorContactos.geInstance().removeCliente(this);
        }
    }

    public synchronized void send(byte[] buffer) {
        try {
            dout.write(buffer);
            dout.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public synchronized void send(String msg) {
        try {
            dout.write(msg.getBytes(Charset.forName("UTF-8")));
            dout.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
