package model;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Compra;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-12-04T21:00:52", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Cliente.class)
public class Cliente_ extends Pessoa_ {

    public static volatile ListAttribute<Cliente, Compra> compras;
    public static volatile SingularAttribute<Cliente, Integer> id;

}