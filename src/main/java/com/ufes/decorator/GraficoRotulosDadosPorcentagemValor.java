/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.decorator;

import java.text.NumberFormat;
import java.util.Locale;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;

/**
 *
 * @author Heflain
 */
public class GraficoRotulosDadosPorcentagemValor extends GraficoDecorator{

    public GraficoRotulosDadosPorcentagemValor(GraficoComponente graficoComponente) {
        super(graficoComponente);
        var grafico = graficoComponente.getGrafico();
        grafico.getCategoryPlot()
                .getRenderer()
                .setSeriesItemLabelGenerator(
                        0,
                        new StandardCategoryItemLabelGenerator(
                                "{2}",
                                NumberFormat.
                                        getPercentInstance(
                                                Locale.getDefault()
                                        )
                        )
                );
        grafico.getCategoryPlot()
                .getRenderer()
                .setSeriesItemLabelGenerator(
                        1,
                        new StandardCategoryItemLabelGenerator()
                );
        grafico.getCategoryPlot().getRenderer().setDefaultItemLabelsVisible(true);
    }

    @Override
    public GraficoComponente desfazer() {
        var grafico = graficoComponente.getGrafico();
        grafico.getCategoryPlot()
                .getRenderer()
                .setSeriesItemLabelGenerator(
                        0,
                        null
                );
        grafico.getCategoryPlot()
                .getRenderer()
                .setSeriesItemLabelGenerator(
                        1,
                        null
                );
        
        return graficoComponente;
    }
    
}
