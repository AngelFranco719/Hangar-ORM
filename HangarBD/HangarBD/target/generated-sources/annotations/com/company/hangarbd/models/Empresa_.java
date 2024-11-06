package com.company.hangarbd.models;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.*;

@Generated(value="org.datanucleus.jpa.query.JPACriteriaProcessor")
@StaticMetamodel(Empresa.class)
public class Empresa_
{
    public static volatile SingularAttribute<Empresa, java.lang.Long> ID_Empresa;
    public static volatile SingularAttribute<Empresa, java.lang.String> emp_nombre;
    public static volatile SingularAttribute<Empresa, java.lang.String> emp_ubicacion;
    public static volatile SetAttribute<Empresa, com.company.hangarbd.models.Nave> emp_nav;
}
