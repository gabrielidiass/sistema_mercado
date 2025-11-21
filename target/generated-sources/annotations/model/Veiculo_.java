package model;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Marca;
import model.Modelo;
import model.Venda;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-11-19T17:56:11", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Veiculo.class)
public class Veiculo_ { 

    public static volatile SingularAttribute<Veiculo, Marca> marca;
    public static volatile SingularAttribute<Veiculo, String> cor;
    public static volatile SingularAttribute<Veiculo, Double> valor;
    public static volatile SingularAttribute<Veiculo, Integer> anoFabricacao;
    public static volatile ListAttribute<Veiculo, Venda> vendas;
    public static volatile SingularAttribute<Veiculo, Integer> id;
    public static volatile SingularAttribute<Veiculo, Integer> anoModelo;
    public static volatile SingularAttribute<Veiculo, Modelo> modelo;
    public static volatile SingularAttribute<Veiculo, String> placa;

}