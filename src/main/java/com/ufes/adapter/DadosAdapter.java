/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ufes.adapter;

import com.ufes.model.DadosArquivo;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author heflainrmendes
 */
public interface DadosAdapter {
    public List<DadosArquivo> obter(String caminho) throws IOException;
}
