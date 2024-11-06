package com.mycompany.hangarbd;

import com.company.hangarbd.models.Empresa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class HangarBD {

    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("hangar"); // Verifica que el nombre coincide
            em = emf.createEntityManager();
            Query q = em.createQuery("SELECT p FROM empresa p");
            List<Empresa> resultados = q.getResultList(); 
            System.out.println("Conexión establecida exitosamente.");
            System.out.println(resultados.get(0).toString());
            EntityTransaction xt = em.getTransaction();
            xt.begin();

            xt.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
