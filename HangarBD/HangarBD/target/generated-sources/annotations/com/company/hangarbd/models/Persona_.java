package com.company.hangarbd.models;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.*;

@Generated(value="org.datanucleus.jpa.query.JPACriteriaProcessor")
@StaticMetamodel(Persona.class)
public class Persona_
{
    public static volatile SingularAttribute<Persona, java.lang.Long> ID_Persona;
    public static volatile SingularAttribute<Persona, java.lang.String> per_nombre;
    public static volatile SingularAttribute<Persona, java.lang.String> per_fabricante;
    public static volatile SingularAttribute<Persona, java.lang.String> per_anio;
    public static volatile SetAttribute<Persona, com.company.hangarbd.models.Tripulante> per_tri;
    public static volatile SetAttribute<Persona, com.company.hangarbd.models.Piloto> per_pil;
}
