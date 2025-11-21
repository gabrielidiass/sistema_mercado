/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import model.dao.Util;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.*;

/**
 *
 * @author vanessalagomachado
 */
@Entity
@Table(name = "compras")
public class Compra implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "compra_id")
    private int id;
    
    @Column(name = "compra_data_hora", nullable = false)
    private LocalDateTime dataCompra;
    
    @Column(name = "compra_valor", columnDefinition = "numeric(12,2)")
    private double valorCompra;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "compra_forma_pagamento")
    private FormaPagamento formaPagamento;
    
    @ManyToOne
    @JoinColumn(name = "compra_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "compra_funcionario")
    private Funcionario funcionario;

    @ManyToOne
    @JoinColumn(name = "compra_veiculo")
    private Produto produto;

    public LocalDateTime getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDateTime dataCompra) {
        this.dataCompra = dataCompra;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public FormaPagamento setFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public String toString() {
        return Util.formatarDataHora(dataCompra);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String exibirDados() {
        
        String aux = "Dados da Compra:\n";
        aux += "Data|Hora:"+Util.formatarDataHora(dataCompra)+"\n";
        aux += "Produto"+getProduto().getNome()+"\n";
        aux += "Cliente: "+getCliente().getNome()+"\n";
        aux += "Funcionario: "+getFuncionario().getNome()+"\n";
          aux += "Forma de Pagamento: "+ formaPagamento +"\n";
          return aux;
    }
    
    
}
