/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upb.tresenraya.bl;

import edu.upb.tresenraya.server.SocketClient;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class MediadorContactos {
    private final List<SocketListener> lister = new ArrayList<>();
    private static MediadorContactos instance = new MediadorContactos();
    private MediadorContactos(){
    }
    
    public static MediadorContactos  geInstance(){
        return instance;   
    }
    
    public void addListener(SocketListener sl){
        synchronized (lister) {
            lister.add(sl);
        }
    }
    
     public  void newClient(SocketClient msg){
        for (SocketListener listener : lister) {
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                listener.onNewClient(msg);
            }
        });
        
        }
    }
}
