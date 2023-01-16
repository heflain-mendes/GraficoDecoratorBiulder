/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.biulder;

import com.ufes.decorator.GraficoBase;
import com.ufes.model.DadosJFreeChart;
import java.awt.Color;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;

/**
 *
 * @author heflainrmendes
 */
public class GraficoVerticalBuilder extends GraficoBuilder {

    @Override
    public GraficoBase criarGrafico(List<DadosJFreeChart> listDados) {
        var dataset = super.criarDataset(listDados);

        var grafico = ChartFactory.createBarChart(
                "",
                "",
                "",
                dataset,
                PlotOrientation.VERTICAL,
                true, false, false);
        grafico.getLegend().setVisible(false);
        grafico.getCategoryPlot().setBackgroundPaint(Color.white);
        grafico.getCategoryPlot().setDomainGridlinePaint(Color.white);
        grafico.getCategoryPlot().setRangeGridlinePaint(Color.white);
        grafico.getCategoryPlot().setOutlineVisible(false);

        return new GraficoBase(grafico);
    }

}
