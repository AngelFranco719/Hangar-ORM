package com.company.hangarbd.views.interfaz;

import com.company.hangarbd.controller.CargoController;
import com.company.hangarbd.controller.PersonaController;
import com.company.hangarbd.controller.TripulanteController;
import com.company.hangarbd.controller.VueloController;
import com.company.hangarbd.models.Cargo;
import com.company.hangarbd.views.confirmacion.Formulario_Confirmacion_Tripulante;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Formulario_Insert_Tripulante extends javax.swing.JFrame {

    Long ID;
    String Vuelo;
    Cargo.cargos Cargo;
    String Persona;

    TripulanteController tripulanteController;
    VueloController vueloController;
    CargoController cargoController;
    PersonaController personaController;

    boolean isUpdate = false;

    public Formulario_Insert_Tripulante() {
        initComponents();
        this.getLastID();
        this.getVuelo();
        this.getCargo();
        this.getPersona();
    }

    public Formulario_Insert_Tripulante(List<String> Tupla) {
        initComponents();
        this.getVuelo();
        this.getCargo();
        this.getPersona();
        this.id_tripulante.setText(Tupla.get(0).toString());
        this.tri_vuelo.setSelectedItem(Tupla.get(1));
        this.tri_cargo.setSelectedItem(Tupla.get(2));
        this.tri_persona.setSelectedItem(Tupla.get(3));

        this.ID = Long.valueOf(this.id_tripulante.getText());
        this.isUpdate = true;
        this.Button_Enviar.setText("Actualizar");
    }

    public void getAttributes() {
        this.ID = Long.valueOf(this.id_tripulante.getText());
        this.Vuelo = this.tri_vuelo.getSelectedItem().toString();
        switch (this.tri_cargo.getSelectedItem().toString()) {
            case "INGENIERO":
                this.Cargo = Cargo.INGENIERO;
                break;
            case "PILOTO":
                this.Cargo = Cargo.PILOTO;
                break;
            case "COPILOTO":
                this.Cargo = Cargo.COPILOTO;
                break;
            case "AUXILIAR":
                this.Cargo = Cargo.AUXILIAR;
                break;
        }
        this.Persona = this.tri_persona.getSelectedItem().toString();
    }

    public void getLastID() {
        EntityManagerFactory emf = null;
        try {
            emf = Persistence.createEntityManagerFactory("hangar");
            tripulanteController = new TripulanteController(emf);
            ID = tripulanteController.getLastID_Tripulante() + 1;
            this.id_tripulante.setText(ID.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getVuelo() {
        EntityManagerFactory emf = null;
        try {
            emf = Persistence.createEntityManagerFactory("hangar");
            vueloController = new VueloController(emf);
            List<String> vuelos = vueloController.getColumnsFromVuelo("vue_codigo");
            for (String vuelo : vuelos) {
                this.tri_vuelo.addItem(vuelo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getCargo() {
        EntityManagerFactory emf = null;
        try {
            emf = Persistence.createEntityManagerFactory("hangar");
            cargoController = new CargoController(emf);
            List<Cargo.cargos> cargos = cargoController.getColumnsFromCargo("car_nombre");
            System.out.println(cargos.getFirst().getClass());
            for (Cargo.cargos cargo : cargos) {
                this.tri_cargo.addItem(cargo.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getPersona() {
        EntityManagerFactory emf = null;
        try {
            emf = Persistence.createEntityManagerFactory("hangar");
            personaController = new PersonaController(emf);
            List<String> personas = personaController.getColumnsFromPersona("per_nombre");
            for (String persona : personas) {
                this.tri_persona.addItem(persona);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        id_tripulante = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tri_vuelo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tri_cargo = new javax.swing.JComboBox<>();
        tri_persona = new javax.swing.JComboBox<>();
        Button_Enviar = new javax.swing.JButton();
        Button_Cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("TRIPULANTE");

        jLabel2.setText("ID_Tripulante:");

        id_tripulante.setEditable(false);

        jLabel3.setText("Vuelo:");

        jLabel4.setText("Cargo:");

        jLabel5.setText("Persona:");

        tri_cargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tri_cargoActionPerformed(evt);
            }
        });

        tri_persona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tri_personaActionPerformed(evt);
            }
        });

        Button_Enviar.setText("Enviar");
        Button_Enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_EnviarActionPerformed(evt);
            }
        });

        Button_Cancelar.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(40, 40, 40)
                                .addComponent(tri_persona, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(48, 48, 48)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tri_vuelo, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tri_cargo, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(id_tripulante, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(85, 85, 85)
                                        .addComponent(Button_Enviar)
                                        .addGap(38, 38, 38)
                                        .addComponent(Button_Cancelar)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(jLabel1)))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(id_tripulante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tri_vuelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tri_cargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tri_persona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_Enviar)
                    .addComponent(Button_Cancelar))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tri_personaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tri_personaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tri_personaActionPerformed

    private void tri_cargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tri_cargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tri_cargoActionPerformed

    private void Button_EnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_EnviarActionPerformed
        this.getAttributes();
        if (!isUpdate) {
            System.out.println("No es actu");
            Formulario_Confirmacion_Tripulante FCT = new Formulario_Confirmacion_Tripulante(ID, Vuelo, Cargo, Persona);
            FCT.setVisible(true);
        } else {
            System.out.println("Si es actu");
            Formulario_Confirmacion_Tripulante FCT = new Formulario_Confirmacion_Tripulante(isUpdate, ID, Vuelo, Cargo, Persona);
            FCT.setVisible(true);
        }

    }//GEN-LAST:event_Button_EnviarActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Formulario_Insert_Tripulante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Formulario_Insert_Tripulante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Formulario_Insert_Tripulante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Formulario_Insert_Tripulante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Formulario_Insert_Tripulante().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Cancelar;
    private javax.swing.JButton Button_Enviar;
    private javax.swing.JTextField id_tripulante;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JComboBox<String> tri_cargo;
    private javax.swing.JComboBox<String> tri_persona;
    private javax.swing.JComboBox<String> tri_vuelo;
    // End of variables declaration//GEN-END:variables
}
