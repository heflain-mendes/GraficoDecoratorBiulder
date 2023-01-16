/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ufes.biulder;

import com.ufes.decorator.GraficoBase;
import com.ufes.model.DadosJFreeChart;
import java.util.List;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author heflainrmendes
 */
public abstract class GraficoBuilder {

    public abstract GraficoBase criarGrafico(List<DadosJFreeChart> listDados);

    protected DefaultCategoryDataset criarDataset(List<DadosJFreeChart> listDados) {
        DefaultCategoryDataset categoryDataset = new DefaultCategoryDataset();

        for (DadosJFreeChart d : listDados) {
            categoryDataset.addValue(d.getValor(), d.getNomeEixoX(), d.getNomeEixoY());
        }
        
        return categoryDataset;
    }
}
