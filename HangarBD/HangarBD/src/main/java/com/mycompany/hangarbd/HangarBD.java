package com.mycompany.hangarbd;

import com.company.hangarbd.controller.CargoController;
import com.company.hangarbd.controller.EmpresaController;
import com.company.hangarbd.controller.ModeloController;
import com.company.hangarbd.controller.ServicioController;
import com.company.hangarbd.controller.NaveController;
import com.company.hangarbd.controller.PersonaController;
import com.company.hangarbd.controller.PilotoController;
import com.company.hangarbd.controller.TallerController;
import com.company.hangarbd.controller.TripulanteController;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HangarBD {

    public static void main(String[] args) {

        EntityManagerFactory emf = null;
        TripulanteController tripulanteController;
        List<List<String>> Empresas;
        try {
            emf = Persistence.createEntityManagerFactory("hangar");
            tripulanteController = new TripulanteController(emf);
                    
            Empresas = tripulanteController.getAllFromTripulante();
            System.out.println(Empresas);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
