package com.ufes.decorator;


import java.text.NumberFormat;
import java.util.Locale;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author heflainrmendes
 */
public class GraficoRotuloPorcentagemDecorator extends GraficoDecorator {

    public GraficoRotuloPorcentagemDecorator(GraficoComponente graficoComponente) {
        super(graficoComponente);
        var grafico = graficoComponente.getGrafico();
        grafico.getCategoryPlot()
                .getRenderer()
                .setDefaultItemLabelGenerator(
                        new StandardCategoryItemLabelGenerator(
                                "{2}",
                                NumberFormat.
                                        getPercentInstance(
                                                Locale.getDefault()
                                        )
                        )
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
