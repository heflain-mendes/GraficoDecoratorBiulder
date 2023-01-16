/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.decorator;


import org.jfree.chart.JFreeChart;

/**
 *
 * @author heflainrmendes
 */
public class GraficoBase implements GraficoComponente{
    private JFreeChart grafico;

    public GraficoBase(JFreeChart grafico) {
        this.grafico = grafico;
    }
    
    @Override
    public JFreeChart getGrafico() {
        return this.grafico;
    }

    @Override
    public GraficoComponente desfazer() {
        return this;
    }

    @Override
    public GraficoComponente obterGraficoBase() {
        return desfazer();
    }
}
