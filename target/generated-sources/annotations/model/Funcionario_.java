package model;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Compra;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-12-04T21:00:52", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Funcionario.class)
public class Funcionario_ extends Pessoa_ {

    public static volatile ListAttribute<Funcionario, Compra> compras;
    public static volatile SingularAttribute<Funcionario, Double> salario;
    public static volatile SingularAttribute<Funcionario, Integer> id;
    public static volatile SingularAttribute<Funcionario, String> cargo;

}