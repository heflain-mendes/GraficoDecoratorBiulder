/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.presenter;

/**
 *
 * @author Heflain
 */
public class Memento {
    private boolean tituloHabilitado;
    private boolean legendaHabilitado;
    private boolean titulosEixosHabilidado;
    private boolean rotuloPorcentagem;
    private boolean rotuloValor;
    private boolean rotuloPorcentagemValor;
    private boolean corBarras;
    private boolean corBarrasGrupo;
    private boolean gradeHabilitada;

    Memento setTituloHabilitado(boolean tituloHabilitado) {
        this.tituloHabilitado = tituloHabilitado;
        return this;
    }

    Memento setLegendaHabilitado(boolean legendaHabilitado) {
        this.legendaHabilitado = legendaHabilitado;
        return this;
    }

    Memento setTitulosEixosHabilidado(boolean titulosEixosHabilidado) {
        this.titulosEixosHabilidado = titulosEixosHabilidado;
        return this;
    }

    Memento setRotuloPorcentagem(boolean rotuloPorcentagem) {
        this.rotuloPorcentagem = rotuloPorcentagem;
        return this;
    }

    Memento setRotuloValor(boolean rotuloValor) {
        this.rotuloValor = rotuloValor;
        return this;
    }

    Memento setRotuloPorcentagemValor(boolean rotuloPorcentagemValor) {
        this.rotuloPorcentagemValor = rotuloPorcentagemValor;
        return this;
    }

    Memento setCorBarras(boolean corBarras) {
        this.corBarras = corBarras;
        return this;
    }

    Memento setCorBarrasGrupo(boolean corBarrasGrupo) {
        this.corBarrasGrupo = corBarrasGrupo;
        return this;
    }

    Memento setGradeHabilitada(boolean gradeHabilitada) {
        this.gradeHabilitada = gradeHabilitada;
        return this;
    }

    boolean isTituloHabilitado() {
        return tituloHabilitado;
    }

    boolean isLegendaHabilitado() {
        return legendaHabilitado;
    }

    boolean isTitulosEixosHabilidado() {
        return titulosEixosHabilidado;
    }

    boolean isRotuloPorcentagem() {
        return rotuloPorcentagem;
    }

    boolean isRotuloValor() {
        return rotuloValor;
    }

    boolean isRotuloPorcentagemValor() {
        return rotuloPorcentagemValor;
    }

    boolean isCorBarras() {
        return corBarras;
    }

    boolean isCorBarrasGrupo() {
        return corBarrasGrupo;
    }

    boolean isGradeHabilitada() {
        return gradeHabilitada;
    }
}
