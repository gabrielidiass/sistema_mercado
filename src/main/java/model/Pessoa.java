/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author vanessalagomachado
 */
@MappedSuperclass
public class Pessoa {
    private int codigo;
    private String nome;
    private String CPF;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    @Override
    public String toString() {
        return nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String exibirDados(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String aux = "Pessoa cadastrada: \n";
        aux += "Nome: " + nome+ "\n";
        aux += "CPF: " + CPF + "\n";
        return aux;
    }
            
}
