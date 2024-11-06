package com.company.hangarbd.models;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.*;

@Generated(value="org.datanucleus.jpa.query.JPACriteriaProcessor")
@StaticMetamodel(Taller.class)
public class Taller_
{
    public static volatile SingularAttribute<Taller, Integer> ID_taller;
    public static volatile SingularAttribute<Taller, java.lang.String> tal_Descripcion;
    public static volatile SetAttribute<Taller, com.company.hangarbd.models.Servicio> tall_ser;
    public static volatile SingularAttribute<Taller, com.company.hangarbd.models.Hangar> tall_han;
}
