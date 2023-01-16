/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.decorator;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;

/**
 *
 * @author heflainrmendes
 */
public class GraficoTituloEixosDecorator extends GraficoDecorator{

    public GraficoTituloEixosDecorator(String tituloX, String tituloY, GraficoComponente graficoComponente) {
        super(graficoComponente);
        var grafico = graficoComponente.getGrafico();
        grafico.getCategoryPlot().setRangeAxis(1,  new NumberAxis(tituloX));
        grafico.getCategoryPlot().setDomainAxis(0,  new CategoryAxis(tituloY));
    }

    @Override
    public GraficoComponente desfazer() {
        var grafico = graficoComponente.getGrafico();
        grafico.getCategoryPlot().setRangeAxis(1,  new NumberAxis(null));
        grafico.getCategoryPlot().setDomainAxis(0,  new CategoryAxis(null));
        return graficoComponente;
    }
    
}
