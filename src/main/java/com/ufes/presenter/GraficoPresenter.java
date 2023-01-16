/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.presenter;

import com.ufes.decorator.GraficoRotuloPorcentagemDecorator;
import com.ufes.adapter.DadosCSVAdapter;
import com.ufes.biulder.GraficoHorizontalBuilder;
import com.ufes.biulder.GraficoVerticalBuilder;
import com.ufes.decorator.GraficoComponente;
import com.ufes.decorator.GraficoCorDecorator;
import com.ufes.decorator.GraficoCorGrupoDecorator;
import com.ufes.decorator.GraficoGradeDecorator;
import com.ufes.decorator.GraficoLegendaDecorator;
import com.ufes.decorator.GraficoRotuloValorDecorator;
import com.ufes.decorator.GraficoRotulosDadosPorcentagemValor;
import com.ufes.decorator.GraficoTituloDecoration;
import com.ufes.decorator.GraficoTituloEixosDecorator;
import com.ufes.model.DadosArquivo;
import com.ufes.model.DadosJFreeChart;
import com.ufes.processadados.ProcessadoraService;
import com.ufes.view.GraficoView;
import com.ufes.zelador.Zelador;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartPanel;

/**
 *
 * @author heflainrmendes
 */
public class GraficoPresenter {

    private List<DadosArquivo> listaDados;
    private List<DadosJFreeChart> listaDadosGrafico;

    private String[] orientacao = {"horizontal", "vertical"};
    private GraficoView graficoView;
    private GraficoComponente grafico;
    private ChartPanel chartPanel;
    private int indexSelecionado;
    
    private Zelador zelador;

    public GraficoPresenter() {
        this.graficoView = new GraficoView();
        configureView();
        addEventView();
        zelador = new Zelador();
    }

    private void configureView() {
        this.graficoView.setLayout(new BorderLayout());

        this.graficoView.getCbxGraficoPadrao().addItem(orientacao[0]);
        this.graficoView.getCbxGraficoPadrao().addItem(orientacao[1]);
        this.graficoView.getCbxGraficoPadrao().setSelectedIndex(0);
        indexSelecionado = 0;

        try {
            listaDados = new DadosCSVAdapter().obter("./arquivos/pessoas.csv");
            listaDadosGrafico = new ProcessadoraService().processar(listaDados);
            grafico = new GraficoHorizontalBuilder().criarGrafico(listaDadosGrafico);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        this.chartPanel = new ChartPanel(grafico.getGrafico());
        chartPanel.setSize(this.graficoView.getPnlGrafico().getSize());

        this.graficoView.getPnlGrafico().add(chartPanel);
        this.graficoView.setVisible(true);
        this.graficoView.getPnlGrafico().setVisible(true);
        chartPanel.setVisible(true);
    }

    private void addEventView() {
        this.graficoView.getCbxGraficoPadrao().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alterarEstiloGrafico();
            }
        });

        this.graficoView.getCbLegenda().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarLegenda();
            }
        });

        this.graficoView.getCbRotulosDeDadosPorcentagem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarRotulosDeDadosPorcentagem();
            }
        });

        this.graficoView.getCbRotulosDeDadosPorcentagemValor().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarRotulosDeDadosPorcentagemValor();
            }
        });

        this.graficoView.getCbRotulosDeDadosValor().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarRotulosDeDadosValor();
            }
        });

        this.graficoView.getCbTitulo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarTitulo();
            }
        });

        this.graficoView.getCbTituloEixo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarTituloEixo();
            }
        });

        this.graficoView.getCbCorDasBarras().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarCorDasBarras();
            }
        });

        this.graficoView.getCbCorDasBarrasPorGrupo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarCorDasBarrasPorGrupo();
            }
        });

        this.graficoView.getCbGrade().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarGrade();
            }
        });

        this.graficoView.getBtnFechar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fechar();
            }
        });

        this.graficoView.getBtnDesfazer().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                desfazer();
            }
        });

        this.graficoView.getBtnRestaurarPadrao().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restaurarPadrao();
            }
        });
    }

    private void adicionarLegenda() {
        zelador.add(salvar());
        grafico = new GraficoLegendaDecorator(
                grafico
        );

        this.graficoView.getCbLegenda().setEnabled(false);
    }

    private void adicionarRotulosDeDadosPorcentagem() {
        zelador.add(salvar());
        grafico = new GraficoRotuloPorcentagemDecorator(grafico);
        this.graficoView.getCbRotulosDeDadosPorcentagem().setEnabled(false);
        this.graficoView.getCbRotulosDeDadosValor().setEnabled(false);
        this.graficoView.getCbRotulosDeDadosPorcentagemValor().setEnabled(false);
        this.graficoView.getCbRotulosDeDadosValor().setSelected(true);
        this.graficoView.getCbRotulosDeDadosPorcentagemValor().setSelected(true);
    }

    private void adicionarRotulosDeDadosPorcentagemValor() {
        zelador.add(salvar());
        grafico = new GraficoRotulosDadosPorcentagemValor(grafico);
        this.graficoView.getCbRotulosDeDadosPorcentagemValor().setEnabled(false);
        this.graficoView.getCbRotulosDeDadosPorcentagem().setEnabled(false);
        this.graficoView.getCbRotulosDeDadosValor().setEnabled(false);
        this.graficoView.getCbRotulosDeDadosPorcentagem().setSelected(true);
        this.graficoView.getCbRotulosDeDadosValor().setSelected(true);
    }

    private void adicionarRotulosDeDadosValor() {
        zelador.add(salvar());
        grafico = new GraficoRotuloValorDecorator(grafico);
        this.graficoView.getCbRotulosDeDadosPorcentagem().setEnabled(false);
        this.graficoView.getCbRotulosDeDadosValor().setEnabled(false);
        this.graficoView.getCbRotulosDeDadosPorcentagem().setSelected(true);
        this.graficoView.getCbRotulosDeDadosValor().setSelected(true);
        this.graficoView.getCbRotulosDeDadosPorcentagemValor().setEnabled(false);
    }

    private void adicionarTitulo() {
        zelador.add(salvar());
        String titulo = JOptionPane.showInputDialog(
                "Digite o título do gráfico:");

        grafico = new GraficoTituloDecoration(titulo, grafico);
        this.graficoView.getCbTitulo().setEnabled(false);
    }

    private void adicionarTituloEixo() {
        zelador.add(salvar());
        String tituloEixoX = JOptionPane.showInputDialog(
                "Digite o título do eixo x do gráfico:");
        String tituloEixoY = JOptionPane.showInputDialog(
                "Digite o título do eixo y do gráfico:");

        grafico = new GraficoTituloEixosDecorator(
                tituloEixoX,
                tituloEixoY,
                grafico
        );
        this.graficoView.getCbTituloEixo().setEnabled(false);
    }

    private void alterarEstiloGrafico() {
        
        if (this.graficoView.getCbxGraficoPadrao().getSelectedIndex() != indexSelecionado) {
            indexSelecionado = this.graficoView.getCbxGraficoPadrao().getSelectedIndex();
            if (indexSelecionado == 0) {
                grafico = new GraficoHorizontalBuilder().criarGrafico(listaDadosGrafico);
            } else {
                grafico = new GraficoVerticalBuilder().criarGrafico(listaDadosGrafico);
            }
            this.chartPanel.setChart(grafico.getGrafico());
        }
        restaurar(zelador.getPrimeiro());
    }

    private void adicionarCorDasBarras() {
        zelador.add(salvar());
        this.graficoView.getCbCorDasBarras();
        int cor1 = getCor();
        int cor2 = getCor();
        grafico = new GraficoCorDecorator(grafico, cor1, cor2);
        this.graficoView.getCbCorDasBarras().setEnabled(false);
        this.graficoView.getCbCorDasBarrasPorGrupo().setEnabled(false);
        this.graficoView.getCbCorDasBarrasPorGrupo().setSelected(true);
    }

    private int getCor() {
        boolean continua = true;
        int retorno = 0;
        do {
            String cor = JOptionPane.showInputDialog(
                    "Digite a cor desejada:\n"
                    + "1. Azul\n"
                    + "2. Vermelho\n"
                    + "3. Verde"
            );

            try {
                retorno = Integer.parseInt(cor) - 1;
                continua = false;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Digite um numero");
            }
        } while (continua);

        return retorno;
    }

    private void adicionarCorDasBarrasPorGrupo() {
        zelador.add(salvar());
        int i = getGrupoCor();
        grafico = new GraficoCorGrupoDecorator(grafico, i);
        this.graficoView.getCbCorDasBarras().setEnabled(false);
        this.graficoView.getCbCorDasBarrasPorGrupo().setEnabled(false);
        this.graficoView.getCbCorDasBarras().setSelected(true);
    }

    private int getGrupoCor() {
        String msg = "Digite o numero do grupo de cor\n";
        int i = 1;
        for (var s : GraficoCorGrupoDecorator.nomesGrupos) {
            msg += i++ + ". " + s + "\n";
        }

        boolean continua = true;
        int retorno = 0;
        do {
            String cor = JOptionPane.showInputDialog(
                    msg
            );

            try {
                retorno = Integer.parseInt(cor) - 1;
                continua = false;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Digite um numero");
            }
        } while (continua);

        return retorno;
    }

    private void adicionarGrade() {
        zelador.add(salvar());
        grafico = new GraficoGradeDecorator(grafico);
        this.graficoView.getCbGrade().setEnabled(false);
    }

    private void fechar() {
        graficoView.dispose();
        System.exit(0);
    }

    private void desfazer() {
        grafico = grafico.desfazer();
        restaurar(zelador.getUltimo());
    }

    private void restaurarPadrao() {
        grafico = grafico.obterGraficoBase();
        restaurar(zelador.getPrimeiro());
    }

    private Memento salvar() {
        return new Memento()
                .setCorBarras(graficoView.getCbCorDasBarras().isEnabled())
                .setCorBarrasGrupo(graficoView.getCbCorDasBarrasPorGrupo().isEnabled())
                .setGradeHabilitada(graficoView.getCbGrade().isEnabled())
                .setLegendaHabilitado(graficoView.getCbLegenda().isEnabled())
                .setRotuloPorcentagem(graficoView.getCbRotulosDeDadosPorcentagem().isEnabled())
                .setRotuloPorcentagemValor(graficoView.getCbRotulosDeDadosPorcentagemValor().isEnabled())
                .setRotuloValor(graficoView.getCbRotulosDeDadosValor().isEnabled())
                .setTituloHabilitado(graficoView.getCbTitulo().isEnabled())
                .setTitulosEixosHabilidado(graficoView.getCbTituloEixo().isEnabled());
    }

    private void restaurar(Memento m) {
        if(m == null){
            return;
        }
        graficoView.getCbCorDasBarras().setEnabled(m.isCorBarras());
        graficoView.getCbCorDasBarras().setSelected(!m.isCorBarras());
        graficoView.getCbCorDasBarrasPorGrupo().setEnabled(m.isCorBarrasGrupo());
        graficoView.getCbCorDasBarrasPorGrupo().setSelected(!m.isCorBarrasGrupo());
        graficoView.getCbGrade().setEnabled(m.isGradeHabilitada());
        graficoView.getCbGrade().setSelected(!m.isGradeHabilitada());
        graficoView.getCbLegenda().setEnabled(m.isLegendaHabilitado());
        graficoView.getCbLegenda().setSelected(!m.isLegendaHabilitado());
        graficoView.getCbRotulosDeDadosPorcentagem().setEnabled(m.isRotuloPorcentagem());
        graficoView.getCbRotulosDeDadosPorcentagem().setSelected(!m.isRotuloPorcentagem());
        graficoView.getCbRotulosDeDadosPorcentagemValor().setEnabled(m.isRotuloPorcentagemValor());
        graficoView.getCbRotulosDeDadosPorcentagemValor().setSelected(!m.isRotuloPorcentagemValor());
        graficoView.getCbRotulosDeDadosValor().setEnabled(m.isRotuloValor());
        graficoView.getCbRotulosDeDadosValor().setSelected(!m.isRotuloValor());
        graficoView.getCbTitulo().setEnabled(m.isRotuloValor());
        graficoView.getCbTitulo().setSelected(!m.isRotuloValor());
        graficoView.getCbTituloEixo().setEnabled(m.isTituloHabilitado());
        graficoView.getCbTituloEixo().setSelected(!m.isTituloHabilitado());
        graficoView.getCbTituloEixo().setEnabled(m.isTitulosEixosHabilidado());
        graficoView.getCbTituloEixo().setSelected(!m.isTitulosEixosHabilidado());
    }
}
