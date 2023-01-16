/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.processadados;

import com.ufes.model.DadosArquivo;
import com.ufes.model.DadosJFreeChart;
import java.util.List;

/**
 *
 * @author heflainrmendes
 */
public class ProcessaDadosGenericoStrategy implements ProcessaDadosStrategy{
    private String estadoCivil;
    private String sexo;

    public ProcessaDadosGenericoStrategy(String estadoCivil, String sexo) {
        this.estadoCivil = estadoCivil;
        this.sexo = sexo;
    }
    
    @Override
    public DadosJFreeChart processar(List<DadosArquivo> listaDados) {
        int qtd = 0;
        
        for(var d : listaDados){
            if(d.getEstadoCivil().equals(estadoCivil) && d.getSexo().equals(sexo)){
                qtd++;
            }
        }
        
        return new DadosJFreeChart(qtd, estadoCivil , sexo);
    }
}
