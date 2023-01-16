/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.decorator;

import java.awt.Color;
import java.awt.Paint;

/**
 *
 * @author Heflain
 */
public class GraficoCorDecorator extends GraficoDecorator{
    private static Paint[] colors = {
        new Color(0, 172, 178),      // blue
        new Color(239, 70, 55),      // red
        new Color(85, 177, 69)       // green
    };
    
    private Paint paintUm;
    private Paint paintDois;
    
    
    public GraficoCorDecorator(GraficoComponente graficoComponente, int i, int j) {
        super(graficoComponente);
        if(i < 0 && i >= colors.length){            
            i = 1;
        }
        if(j < 0 && j >= colors.length){            
            j = 1;
        }
        
        var grafico = graficoComponente.getGrafico();
        paintUm = grafico.getCategoryPlot().getRenderer().getSeriesPaint(0);
        paintDois = grafico.getCategoryPlot().getRenderer().getSeriesPaint(1);
        grafico.getCategoryPlot().getRenderer().setSeriesPaint(0, colors[i]);
        grafico.getCategoryPlot().getRenderer().setSeriesPaint(1, colors[j]);
    }

    @Override
    public GraficoComponente desfazer() {
        var grafico = graficoComponente.getGrafico();
        grafico.getCategoryPlot().getRenderer().setSeriesPaint(0, paintUm);
        grafico.getCategoryPlot().getRenderer().setSeriesPaint(1, paintDois);
        return graficoComponente;
    }
}
