/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upb.tresenraya.mediador;

import edu.upb.tresenraya.bl.Comando;

/**
 *
 * @author Usuario
 */
public interface OnMessageListener {
    void onMessage(String msg);
    void onMessage(Comando c);
    void onClose();
}
