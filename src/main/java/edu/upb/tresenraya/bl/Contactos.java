/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upb.tresenraya.bl;

import edu.upb.tresenraya.server.SocketClient;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 *
 * @author Usuario
 */
public class Contactos implements SocketListener {

    private final ConcurrentMap<String, SocketClient> contatos = new ConcurrentHashMap<>();
    private static final Contactos instance = new Contactos();
    private BigDecimal pagar;
    private String cuenta;


    private Contactos() {
        System.out.println("Construyendo Contacto");
       MediadorContactos.geInstance().addListener(this);
    }

    public static Contactos getInstance() {
        return instance;
    }

    @Override
    public  void removeClient(SocketClient sc){
       contatos.remove(sc.getIp());
    }
    @Override
    public void onNewClient(SocketClient sc) {
        contatos.put(sc.getIp(), sc);
        System.out.println("Cantidad de contactos: " + contatos.size());
    }

    public void send(String ip, String msg) {
        System.out.println("Enviando: " + msg);
        SocketClient sc = this.contatos.get(ip);
        if (sc != null) {
            sc.send(msg.getBytes());
        }
    }
        public void send(String ip, Comando msg) {
        System.out.println("Enviando: " + msg);
        SocketClient sc = this.contatos.get(ip);
        if (sc != null) {
            sc.send(msg.getComando().getBytes());
        }
    }
    
        public void close(String ip) {
        SocketClient sc = this.contatos.get(ip);
        if (sc != null) {
            sc.detener();
        }
    }

}
