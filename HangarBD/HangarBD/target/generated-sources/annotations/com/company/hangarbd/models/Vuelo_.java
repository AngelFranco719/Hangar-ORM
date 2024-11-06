package com.company.hangarbd.models;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.*;

@Generated(value="org.datanucleus.jpa.query.JPACriteriaProcessor")
@StaticMetamodel(Vuelo.class)
public class Vuelo_
{
    public static volatile SingularAttribute<Vuelo, java.lang.Long> Id_Vuelo;
    public static volatile SingularAttribute<Vuelo, java.lang.String> vue_Origen;
    public static volatile SingularAttribute<Vuelo, java.lang.String> vue_Destino;
    public static volatile SingularAttribute<Vuelo, java.util.Date> vue_fechaInicio;
    public static volatile SingularAttribute<Vuelo, java.util.Date> vue_fechaFin;
    public static volatile SingularAttribute<Vuelo, Float> vue_Distancia;
    public static volatile SingularAttribute<Vuelo, Float> vue_Duracion;
    public static volatile SingularAttribute<Vuelo, Float> vuel_AltitudPromedio;
    public static volatile SingularAttribute<Vuelo, Integer> vue_Pasajeros;
    public static volatile SingularAttribute<Vuelo, com.company.hangarbd.models.Nave> vue_nav;
    public static volatile SetAttribute<Vuelo, com.company.hangarbd.models.Tripulante> vue_tri;
}
