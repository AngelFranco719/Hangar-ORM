package com.mycompany.hangarbd;

import com.company.hangarbd.controller.CargoController;
import com.company.hangarbd.controller.EmpresaController;
import com.company.hangarbd.models.Cargo;
import com.company.hangarbd.models.Empresa;
import com.company.hangarbd.views.interfaz.Formulario_Insert_Hangar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class HangarBD {

    public static void main(String[] args) {
//        EntityManagerFactory emf = null;
//        EntityManager em = null;
//        try {
//            emf = Persistence.createEntityManagerFactory("hangar"); // Verifica que el nombre coincide
//            em = emf.createEntityManager();
//            Query query=em.createQuery("SELECT p FROM empresa p");
//            List <Empresa> resultados =query.getResultList(); 
//            
//            System.out.println("Conexión establecida exitosamente.");
//            
//            ///cargoController.createCargo(Cargo.cargos.INGENIERO, "Ingeniero de Vuelo");
//            
//            System.out.println(resultados.toString());
//            
//            
//            
//            
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        Formulario_Insert_Hangar FIH = new Formulario_Insert_Hangar(); 
        FIH.setVisible(true);
        
    }

}
