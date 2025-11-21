package model;

import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Cliente;
import model.FormaContrato;
import model.FormaPgto;
import model.Veiculo;
import model.Vendedor;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-11-19T17:56:11", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Venda.class)
public class Venda_ { 

    public static volatile SingularAttribute<Venda, Veiculo> veiculo;
    public static volatile SingularAttribute<Venda, Cliente> cliente;
    public static volatile SingularAttribute<Venda, Vendedor> vendedor;
    public static volatile SingularAttribute<Venda, LocalDateTime> dataVenda;
    public static volatile SingularAttribute<Venda, FormaPgto> formaPgto;
    public static volatile SingularAttribute<Venda, Double> valorVenda;
    public static volatile SingularAttribute<Venda, Integer> id;
    public static volatile SingularAttribute<Venda, FormaContrato> formaContrato;

}