/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upb.tresenraya.server;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author rlaredo
 */
public class SocketClient extends Thread {
    private final Socket socket;
    private final String ip;
    private final DataOutputStream dout;
    private final BufferedReader br;
    private javax.swing.JLabel jlMessage;
    


    public SocketClient(Socket socket, javax.swing.JLabel jLabel) throws IOException {
        this.socket = socket;
        this.ip = socket.getInetAddress().getHostAddress();
        dout = new DataOutputStream(socket.getOutputStream());
        br = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        this.jlMessage = jLabel;
    }
    
    public void addJLabel(javax.swing.JLabel jLabel){
        this.jlMessage = jLabel;
    }

    @Override
    public void run() {
        try {
            String message;
            while ((message = br.readLine()) != null) {
               if(jlMessage != null){
                   jlMessage.setText(message);
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
        SocketClient socketClient = new SocketClient(new Socket("localhost", 1825), null);
        socketClient.start();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Escriba un mensaje: ");
            socketClient.send((br.readLine()+System.lineSeparator()).getBytes());

        }
    }
}