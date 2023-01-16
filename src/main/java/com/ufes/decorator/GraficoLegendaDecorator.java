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
public class GraficoLegendaDecorator extends GraficoDecorator {

    public GraficoLegendaDecorator(GraficoComponente graficoComponente) {
        super(graficoComponente);
        var grafico = graficoComponente.getGrafico();
        grafico.getLegend().setVisible(true);
    }

    @Override
    public GraficoComponente desfazer() {
        var grafico = graficoComponente.getGrafico();
        grafico.getLegend().setVisible(false);
        
        return graficoComponente;
    }
}
