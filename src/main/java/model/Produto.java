/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author vanessalagomachado
 */
@Entity
@Table(name = "produtos")
public class Produto implements Serializable {
    
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "produto_id")
    private int id;
    
    @Column(name = "produto_nome" , nullable = false)
    private String nome;
    
    @Column(name = "produto_quantidade")
    private int quantidade;

    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }

    public double getValorProduto() {
        return valorProduto;
    }

    @Column(name = "produto_valor", columnDefinition = "numeric(12,2)")
    private double valorProduto;
    




    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }
    
    public String exibirDados(){
        String aux = "Produto cadastrado:\n";
        aux += "Nome: "+nome+"\n";
        aux += "Quantidade: "+quantidade+"\n";
        aux += "Valor: R$"+valorProduto+"\n";

        return aux;
    }

     // 1 veiculo -> várias compras
    @OneToMany(mappedBy = "produto")
    private List<Compra> compras;
    
    public List<Compra> getCompras() { return compras; }
    public void setCompras(List<Compra> compras) { this.compras = compras; }

}
