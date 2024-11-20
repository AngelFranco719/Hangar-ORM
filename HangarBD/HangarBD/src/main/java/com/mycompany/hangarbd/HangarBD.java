package com.mycompany.hangarbd;

import com.company.hangarbd.controller.CargoController;
import com.company.hangarbd.controller.EmpresaController;
import com.company.hangarbd.controller.ModeloController;
import com.company.hangarbd.controller.ServicioController;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HangarBD {

    public static void main(String[] args) {

        EntityManagerFactory emf = null;
        ServicioController servicioController;
        List<List<String>> Empresas;
        try {
            emf = Persistence.createEntityManagerFactory("hangar");
            servicioController = new ServicioController(emf);
                    
            Empresas = servicioController.getAllFromServicio();
            System.out.println(Empresas);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
