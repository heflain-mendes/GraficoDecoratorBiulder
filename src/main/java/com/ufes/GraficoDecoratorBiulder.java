/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.ufes;

import com.ufes.adapter.DadosCSVAdapter;
import com.ufes.presenter.GraficoPresenter;
import java.io.IOException;

/**
 *
 * @author heflainrmendes
 */
public class GraficoDecoratorBiulder {
    public static void main(String[] args) throws IOException {
        new GraficoPresenter();
        //new DadosCSVAdapter().obter("./arquivos/pessoas.csv");
    }
}
