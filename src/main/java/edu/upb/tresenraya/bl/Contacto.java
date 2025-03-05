/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upb.tresenraya.bl;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author rlaredo
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Contacto  implements Serializable{
    private String name;
    private String ip;
    private boolean stateConnect = false;
    
}
