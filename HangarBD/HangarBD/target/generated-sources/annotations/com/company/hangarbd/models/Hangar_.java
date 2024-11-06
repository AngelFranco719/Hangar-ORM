package com.company.hangarbd.models;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.*;

@Generated(value="org.datanucleus.jpa.query.JPACriteriaProcessor")
@StaticMetamodel(Hangar.class)
public class Hangar_
{
    public static volatile SingularAttribute<Hangar, java.lang.Long> ID_Hangar;
    public static volatile SingularAttribute<Hangar, Integer> han_Capacidad;
    public static volatile SingularAttribute<Hangar, java.lang.String> han_Nombre;
    public static volatile SingularAttribute<Hangar, java.lang.String> han_Ubicacion;
    public static volatile SingularAttribute<Hangar, java.lang.String> han_Descripcion;
    public static volatile SingularAttribute<Hangar, java.lang.String> han_Codigo;
    public static volatile SetAttribute<Hangar, com.company.hangarbd.models.Nave> han_nav;
    public static volatile SingularAttribute<Hangar, com.company.hangarbd.models.Taller> han_tal;
}
