package model;

import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Cliente;
import model.FormaPagamento;
import model.Funcionario;
import model.Produto;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-12-04T21:00:52", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Compra.class)
public class Compra_ { 

    public static volatile SingularAttribute<Compra, FormaPagamento> formaPagamento;
    public static volatile SingularAttribute<Compra, Cliente> cliente;
    public static volatile SingularAttribute<Compra, Produto> produto;
    public static volatile SingularAttribute<Compra, Double> valorCompra;
    public static volatile SingularAttribute<Compra, Integer> id;
    public static volatile SingularAttribute<Compra, Funcionario> funcionario;
    public static volatile SingularAttribute<Compra, LocalDateTime> dataCompra;

}