/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upb.tresenraya.server;

import edu.upb.tresenraya.bl.Comando;
import edu.upb.tresenraya.bl.RechazarSolicitud;
import edu.upb.tresenraya.bl.SolicitudConexion;
import edu.upb.tresenraya.exception.CommandoIncorrectoException;
import edu.upb.tresenraya.mediador.Mediador;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
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
        System.out.println("IP: " + this.ip);
        dout = new DataOutputStream(socket.getOutputStream());
        br = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
    }

    @Override
    public void run() {
        try {
            String message;
            while ((message = br.readLine()) != null) {
                if (message.equals("cerrar")) {
                    Mediador.onClose();
                    return;
                } else {
                    Mediador.sendMessage(message);
                }
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
                        c = new RechazarSolicitud();
                        c.parsear(message);
                    }
                    
                    Mediador.sendMessage(c);
                } catch (CommandoIncorrectoException e) {
                    System.out.println("Error en la intepretacion del comando: " + message);
                } catch (Exception ex) {
                    Logger.getLogger(SocketClient.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
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

    public static void main(String[] args) throws IOException {
        SocketClient socketClient = new SocketClient(new Socket("localhost", 1825));
        socketClient.start();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Escriba un mensaje: ");
            socketClient.send((br.readLine() + System.lineSeparator()).getBytes());
        }
    }
}
