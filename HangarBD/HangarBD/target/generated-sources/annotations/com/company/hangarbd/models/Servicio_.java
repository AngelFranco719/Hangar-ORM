package com.company.hangarbd.models;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.*;

@Generated(value="org.datanucleus.jpa.query.JPACriteriaProcessor")
@StaticMetamodel(Servicio.class)
public class Servicio_
{
    public static volatile SingularAttribute<Servicio, Integer> ID_servicio;
    public static volatile SingularAttribute<Servicio, java.lang.String> ser_Diagnostico;
    public static volatile SingularAttribute<Servicio, java.lang.String> ser_Acciones;
    public static volatile SingularAttribute<Servicio, java.lang.String> Responsable;
    public static volatile SingularAttribute<Servicio, com.company.hangarbd.models.Taller> ser_tall;
    public static volatile SingularAttribute<Servicio, com.company.hangarbd.models.Nave> ser_nav;
}
