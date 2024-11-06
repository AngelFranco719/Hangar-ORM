package com.company.hangarbd.models;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.*;

@Generated(value="org.datanucleus.jpa.query.JPACriteriaProcessor")
@StaticMetamodel(Modelo.class)
public class Modelo_
{
    public static volatile SingularAttribute<Modelo, java.lang.Long> ID_Modelo;
    public static volatile SingularAttribute<Modelo, java.lang.String> mod_nombre;
    public static volatile SingularAttribute<Modelo, java.lang.String> mod_fabricante;
    public static volatile SingularAttribute<Modelo, java.lang.String> mod_anio;
    public static volatile SetAttribute<Modelo, com.company.hangarbd.models.Nave> mod_nav;
    public static volatile SetAttribute<Modelo, com.company.hangarbd.models.Piloto> mod_pil;
}
