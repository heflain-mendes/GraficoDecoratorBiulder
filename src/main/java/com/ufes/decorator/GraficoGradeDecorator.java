/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.decorator;

import java.awt.Color;

/**
 *
 * @author Heflain
 */
public class GraficoGradeDecorator extends GraficoDecorator{

    public GraficoGradeDecorator(GraficoComponente graficoComponente) {
        super(graficoComponente);
        var grafico = graficoComponente.getGrafico();
        grafico.getCategoryPlot().setRangeGridlinePaint(Color.black);
    }

    @Override
    public GraficoComponente desfazer() {
        var grafico = graficoComponente.getGrafico();
        grafico.getCategoryPlot().setRangeGridlinePaint(Color.white);
        return graficoComponente;
    }
    
}
