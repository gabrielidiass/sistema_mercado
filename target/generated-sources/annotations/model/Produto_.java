package model;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Categoria;
import model.Compra;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-12-04T21:00:52", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Produto.class)
public class Produto_ { 

    public static volatile ListAttribute<Produto, Compra> compras;
    public static volatile SingularAttribute<Produto, Categoria> categoria;
    public static volatile SingularAttribute<Produto, Double> valor;
    public static volatile SingularAttribute<Produto, String> nome;
    public static volatile SingularAttribute<Produto, Integer> id;
    public static volatile SingularAttribute<Produto, Integer> quantidade;

}