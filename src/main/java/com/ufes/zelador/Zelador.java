/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.zelador;

import com.ufes.presenter.Memento;
import java.util.Stack;

/**
 *
 * @author Heflain
 */
public class Zelador {
    private Memento original;
    private final Stack<Memento> pilha;

    public Zelador() {
        pilha = new Stack();
    }
    
    public void add(Memento m){
        if(original == null){
            original = m;
        }else{
            pilha.push(m);
        }
    }
    
    public Memento getUltimo(){
        Memento m;
        
        if(pilha.empty()){
            m = original;
            original = null;
            return m;
        }
        
        return pilha.pop();
    }
    
    public Memento getPrimeiro(){
        pilha.clear();
        var m = original;
        original = null;
        return m;
    }
}
