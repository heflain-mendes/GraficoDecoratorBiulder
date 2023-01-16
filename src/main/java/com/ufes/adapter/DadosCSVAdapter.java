/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.adapter;

import com.opencsv.CSVReader;
import com.ufes.model.DadosArquivo;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author heflainrmendes
 */
public class DadosCSVAdapter implements DadosAdapter {

    @Override
    public List<DadosArquivo> obter(String caminho) throws IOException {
        if (caminho == null) {
            throw new RuntimeException("Caminho não pode ser null");
        }

        List<DadosArquivo> listDados = new ArrayList();
        File file = new File(caminho);

        try (Reader reader = Files.newBufferedReader(file.toPath())) {
            try (CSVReader csvReader = new CSVReader(reader)) {
                String line[];
                csvReader.readNext();

                while ((line = csvReader.readNext()) != null) {
                    listDados.add(new DadosArquivo(
                    line[0], line[2], line[1]));
                }
            }
        }
        
        file.exists();
        
        return listDados;
    }
}
