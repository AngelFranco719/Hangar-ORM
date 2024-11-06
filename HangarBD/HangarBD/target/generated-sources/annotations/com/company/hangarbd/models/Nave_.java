package com.company.hangarbd.models;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.*;

@Generated(value="org.datanucleus.jpa.query.JPACriteriaProcessor")
@StaticMetamodel(Nave.class)
public class Nave_
{
    public static volatile SingularAttribute<Nave, java.lang.Long> ID_Nave;
    public static volatile SingularAttribute<Nave, Float> nav_peso;
    public static volatile SingularAttribute<Nave, java.lang.String> nav_estado;
    public static volatile SingularAttribute<Nave, java.lang.String> nav_descripcion;
    public static volatile SingularAttribute<Nave, Integer> nav_capacidad;
    public static volatile SingularAttribute<Nave, com.company.hangarbd.models.Empresa> nav_emp;
    public static volatile SingularAttribute<Nave, com.company.hangarbd.models.Hangar> nav_han;
    public static volatile SingularAttribute<Nave, com.company.hangarbd.models.Modelo> nav_mod;
    public static volatile SetAttribute<Nave, com.company.hangarbd.models.Servicio> nav_ser;
    public static volatile SetAttribute<Nave, com.company.hangarbd.models.Vuelo> nav_vue;
}
