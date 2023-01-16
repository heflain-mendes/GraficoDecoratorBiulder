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
public abstract class GraficoDecorator implements GraficoComponente{
    protected GraficoComponente graficoComponente;

    public GraficoDecorator(GraficoComponente graficoComponente) {
        this.graficoComponente = graficoComponente;
    }

    @Override
    public JFreeChart getGrafico(){
        return graficoComponente.getGrafico();
    }

    @Override
    public GraficoComponente obterGraficoBase() {
        return desfazer().obterGraficoBase();
    }
}
