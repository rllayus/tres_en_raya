/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upb.tresenraya.mediador;

import edu.upb.tresenraya.bl.Comando;
import edu.upb.tresenraya.utils.MyCollection;

/**
 *
 * @author Usuario
 */
public class Mediador {

    public static MyCollection<OnMessageListener> lister = new MyCollection<>();

    public Mediador() {
    }

    public static void addListener(OnMessageListener messageLister) {
        lister.add(messageLister);
    }

    public static void sendMessage(String msg) {
        while (lister.hasNext()) {
            OnMessageListener onMessageLister = lister.getNext();
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    onMessageLister.onMessage(msg);
                }
            });
        }
    }

    public static void sendMessage(Comando msg) {
        while (lister.hasNext()) {
            OnMessageListener onMessageLister = lister.getNext();
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    onMessageLister.onMessage(msg);
                }
            });
        }
    }

    public static void onClose() {
        while (lister.hasNext()) {
            OnMessageListener onMessageLister = lister.getNext();
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    onMessageLister.onClose();
                }
            });
        }
    }

}
