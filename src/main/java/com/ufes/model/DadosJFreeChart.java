/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.model;

/**
 *
 * @author heflainrmendes
 */
public class DadosJFreeChart {
    private double valor;
    private String nomeEixoX;
    private String nomeEixoY;

    public DadosJFreeChart(double valor, String nomeEixoX, String nomeEixoY) {
        this.valor = valor;
        this.nomeEixoX = nomeEixoX;
        this.nomeEixoY = nomeEixoY;
    }

    public double getValor() {
        return valor;
    }

    public String getNomeEixoX() {
        return nomeEixoX;
    }

    public String getNomeEixoY() {
        return nomeEixoY;
    }
    
    
}
