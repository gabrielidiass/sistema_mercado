/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "clientes")
public class Cliente extends Pessoa implements Serializable{

    @Id
    @Column(name = "cli_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "cliente")
    private List<Compra> compras;
    
    public List<Compra> getVendas() { return compras; }
    public void setVendas(List<Compra> compras) { this.compras = compras; }

   public Cliente(){
        compras = new ArrayList<>();
    }
    
}
