/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.processadados;

import com.ufes.model.DadosArquivo;
import com.ufes.model.DadosJFreeChart;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author heflainrmendes
 */
public class ProcessadoraService {
    List<ProcessaDadosStrategy> listaProcessamento;

    public ProcessadoraService() {
        listaProcessamento = new ArrayList();
        
        listaProcessamento.add(new ProcessaDadosGenericoStrategy("Casado(a)", "Masculino"));
        listaProcessamento.add(new ProcessaDadosGenericoStrategy("Casado(a)", "Feminino"));
        listaProcessamento.add(new ProcessaDadosGenericoStrategy("Solteiro(a)", "Masculino"));
        listaProcessamento.add(new ProcessaDadosGenericoStrategy("Solteiro(a)", "Feminino"));
    }
    
    public List<DadosJFreeChart> processar(List<DadosArquivo> listaDados){
        List<DadosJFreeChart> listaRetorno = new ArrayList();
        
        for(var proc : listaProcessamento){
            listaRetorno.add(proc.processar(listaDados));
        }
        
        
        
        return listaRetorno;
    }
    
}
