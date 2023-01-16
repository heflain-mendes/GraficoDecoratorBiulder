/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.model;

/**
 *
 * @author heflainrmendes
 */
public class DadosArquivo {
    private String sexo;
    private String estadoCivil;
    private String nome;

    public DadosArquivo(String sexo, String estadoCivil, String nome) {
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public String getNome() {
        return nome;
    }
}
