/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name = "funcionarios")
public class Funcionario extends Pessoa implements Serializable{
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "funcionario_id")
    private int id;
    
    @Column(name = "funcionario_salario", columnDefinition = "numeric(12,2)")
    private double salario;
    
    @Column(name = "funcionario_cargo", columnDefinition = "numeric(5,2)")
    private double cargo;
    
    public Funcionario(){
        compras = new ArrayList<>();
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getCargo() {
        return cargo;
    }

    public void setCargo(double cargo) {
        this.cargo = cargo;
    }

    public String exibirDados(){
        String aux = super.exibirDados()+"\n";
        aux += "Salário" + salario + "\n";
        aux += "Cargo:" + cargo + "\n";
    
        return aux;
    }

    @OneToMany(mappedBy = "funcionario")
    private List<Compra> compras;
    
    public List<Compra> getCompras() { return compras; }
    public void setCompras(List<Compra> compras) { this.compras = compras; }

}
