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
public class GraficoCorGrupoDecorator extends GraficoDecorator{
    public static String[] nomesGrupos = {
        "Azul - Vermelho",
        "Azul - Verde",
        "Vermelho - Azul",
        "Vermelho - Verde",
        "Verde - Azul",
        "Verde - Vermelho"
    };
    
    private static Paint[] colors = {
        new Color(0, 172, 178),      // blue
        new Color(239, 70, 55),      // red
        new Color(85, 177, 69)       // green
    };
    
    private static int[][] grupos = {
        {0,1}, {0, 2},
        {1,0}, {1,2},
        {2,0}, {2,1},
    };
    
    private Paint paintUm;
    private Paint paintDois;
    
    public GraficoCorGrupoDecorator(GraficoComponente graficoComponente, int grupo) {
        super(graficoComponente);
        
        if(grupo < 0 && grupo >= colors.length){            
            grupo = 0;
        }
        
        var grafico = graficoComponente.getGrafico();
        paintUm = grafico.getCategoryPlot().getRenderer().getSeriesPaint(0);
        paintDois = grafico.getCategoryPlot().getRenderer().getSeriesPaint(1);
        grafico.getCategoryPlot().getRenderer().setSeriesPaint(0, colors[grupos[grupo][0]]);
        grafico.getCategoryPlot().getRenderer().setSeriesPaint(1, colors[grupos[grupo][1]]);
        
    }

    @Override
    public GraficoComponente desfazer() {
        var grafico = graficoComponente.getGrafico();
        grafico.getCategoryPlot().getRenderer().setSeriesPaint(0, paintUm);
        grafico.getCategoryPlot().getRenderer().setSeriesPaint(1, paintDois);
        return graficoComponente;
    }
    
}
