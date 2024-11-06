package com.company.hangarbd.models;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.*;

@Generated(value="org.datanucleus.jpa.query.JPACriteriaProcessor")
@StaticMetamodel(Tripulante.class)
public class Tripulante_
{
    public static volatile SingularAttribute<Tripulante, java.lang.Long> ID_Tripulante;
    public static volatile SingularAttribute<Tripulante, com.company.hangarbd.models.Vuelo> tri_vue;
    public static volatile SingularAttribute<Tripulante, com.company.hangarbd.models.Cargo> tri_car;
    public static volatile SingularAttribute<Tripulante, com.company.hangarbd.models.Persona> tri_per;
}
