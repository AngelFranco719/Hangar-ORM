package com.company.hangarbd.models;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.*;

@Generated(value="org.datanucleus.jpa.query.JPACriteriaProcessor")
@StaticMetamodel(Cargo.class)
public class Cargo_
{
    public static volatile SingularAttribute<Cargo, java.lang.Long> ID_Cargo;
    public static volatile SingularAttribute<Cargo, com.company.hangarbd.models.Cargo.cargos> car_nombre;
    public static volatile SingularAttribute<Cargo, java.lang.String> car_descripcion;
    public static volatile SetAttribute<Cargo, com.company.hangarbd.models.Tripulante> car_tri;
}
