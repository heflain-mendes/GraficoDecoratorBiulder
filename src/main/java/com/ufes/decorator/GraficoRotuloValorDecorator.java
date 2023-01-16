/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.decorator;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;

/**
 *
 * @author heflainrmendes
 */
public class GraficoRotuloValorDecorator extends GraficoDecorator {

    public GraficoRotuloValorDecorator(GraficoComponente graficoComponente) {
        super(graficoComponente);
        var grafico = graficoComponente.getGrafico();
        grafico.getCategoryPlot()
                .getRenderer()
                .setDefaultItemLabelGenerator(
                        new StandardCategoryItemLabelGenerator()
                );
        grafico.getCategoryPlot().getRenderer().setDefaultItemLabelsVisible(true);
    }

    @Override
    public GraficoComponente desfazer() {
        var grafico = graficoComponente.getGrafico();
        grafico.getCategoryPlot().getRenderer().setDefaultItemLabelGenerator(null);
        return graficoComponente;
    }

}
