/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upb.tresenraya.utils;

import java.util.ArrayList;

/**
 *
 * @author rlaredo
 * @param <T>
 */
public class MyCollection<T> implements Iterator<T>{
    private final ArrayList<T> list = new ArrayList<>();
    private int index = 0;
    
    public void add(T contact){
        list.add(contact);
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    @Override
    public T getNext() {
        if(!hasNext())
            return null;
        T obj = list.get(index);
        index=index +1;
        return obj;
    }   

    @Override
    public void reset() {
        this.index=0;
    }
}
