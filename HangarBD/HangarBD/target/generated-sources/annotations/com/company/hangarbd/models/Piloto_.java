package com.company.hangarbd.models;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.*;

@Generated(value="org.datanucleus.jpa.query.JPACriteriaProcessor")
@StaticMetamodel(Piloto.class)
public class Piloto_
{
    public static volatile SingularAttribute<Piloto, java.lang.Long> ID_Piloto;
    public static volatile SingularAttribute<Piloto, Integer> pil_horasVuelo;
    public static volatile SingularAttribute<Piloto, com.company.hangarbd.models.Persona> pil_per;
    public static volatile SingularAttribute<Piloto, com.company.hangarbd.models.Modelo> pil_mod;
}
