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
public interface GraficoComponente {
    public JFreeChart getGrafico();
    public GraficoComponente desfazer();
    public GraficoComponente obterGraficoBase();
}
