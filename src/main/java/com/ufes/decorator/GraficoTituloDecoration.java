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
public class GraficoTituloDecoration extends GraficoDecorator {

    public GraficoTituloDecoration(String titulo, GraficoComponente graficoComponente) {
        super(graficoComponente);
        var grafico = graficoComponente.getGrafico();
        grafico.setTitle(titulo);
    }

    @Override
    public GraficoComponente desfazer() {
        var grafico = graficoComponente.getGrafico();
        grafico.setTitle("");
        
        return graficoComponente;
    }
}
