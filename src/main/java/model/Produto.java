package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "produtos")
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "produto_id")
    private int id;

    @Column(name = "produto_nome", nullable = false)
    private String nome;

    @Column(name = "produto_quantidade")
    private int quantidade;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @Column(name = "produto_valor", columnDefinition = "numeric(12,2)")
    private double valor;

    @OneToMany(mappedBy = "produto")
    private List<Compra> compras;

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor){
        this.valor = valor;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public void setCompras(List<Compra> compras) {
        this.compras = compras;
    }

    @Override
    public String toString() {
        return nome;
    }

    public String exibirDados() {
        String aux = "Produto cadastrado:\n";
        aux += "Nome: " + nome + "\n";
        aux += "Categoria: " + categoria + "\n";
        aux += "Quantidade: " + quantidade + "\n";
        aux += "Valor: R$ " + valor + "\n";
        return aux;
    }
}

