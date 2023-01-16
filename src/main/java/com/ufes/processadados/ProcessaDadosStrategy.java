/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ufes.processadados;

import com.ufes.model.DadosArquivo;
import com.ufes.model.DadosJFreeChart;
import java.util.List;

/**
 *
 * @author heflainrmendes
 */
public interface ProcessaDadosStrategy {
    public DadosJFreeChart processar(List<DadosArquivo> listaDados);
}
