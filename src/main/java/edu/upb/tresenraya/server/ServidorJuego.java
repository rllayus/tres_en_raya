/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upb.tresenraya.server;

import edu.upb.tresenraya.TresEnRayaUI;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author rlaredo
 */
public class ServidorJuego extends Thread {

    private final ServerSocket serverSocket;
    private  TresEnRayaUI enRayaUI;

    public ServidorJuego(TresEnRayaUI enRayaUI) throws IOException {
        this.serverSocket = new ServerSocket(1825);
        this.enRayaUI= enRayaUI;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Socket socket = this.serverSocket.accept();
                SocketClient client = new SocketClient(socket, enRayaUI.getLabel());
                //client.addJLabel(enRayaUI.getLabel());
                client.start();
            } catch (IOException e) {
                
            }

        }

    }

}
