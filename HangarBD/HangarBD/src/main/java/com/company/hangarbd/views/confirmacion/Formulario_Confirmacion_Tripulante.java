package com.company.hangarbd.views.confirmacion;

import com.company.hangarbd.controller.CargoController;
import com.company.hangarbd.controller.PersonaController;
import com.company.hangarbd.controller.TripulanteController;
import com.company.hangarbd.controller.VueloController;
import com.company.hangarbd.models.Cargo;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Formulario_Confirmacion_Tripulante extends javax.swing.JFrame {

    Long ID;
    String Vuelo;
    Cargo.cargos Cargo;
    String Persona;

    TripulanteController tripulanteController;
    VueloController vueloController;
    CargoController cargoController;
    PersonaController personaController;

    boolean isUpdate = false;

    public Formulario_Confirmacion_Tripulante(boolean isUpdate, Long ID, String Vuelo, Cargo.cargos Cargo, String Persona) {
        initComponents();
        this.ID = ID;
        this.Vuelo = Vuelo;
        this.Cargo = Cargo;
        this.Persona = Persona;
        this.getAttributes();
        this.isUpdate = true;
        this.Button_Enviar.setText("Actualizar");
    }

    public Formulario_Confirmacion_Tripulante(Long ID, String Vuelo, Cargo.cargos Cargo, String Persona) {
        initComponents();
        this.ID = ID;
        this.Vuelo = Vuelo;
        this.Cargo = Cargo;
        this.Persona = Persona;
        this.getAttributes();
    }

    public void getAttributes() {
        this.id_tripulante.setText(this.ID.toString());
        this.tri_vuelo.setText(this.Vuelo.toString());
        this.tri_cargo.setText(this.Cargo.toString());
        this.tri_persona.setText(this.Persona);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Button_Cancelar = new javax.swing.JButton();
        Button_Enviar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        id_tripulante = new javax.swing.JLabel();
        tri_vuelo = new javax.swing.JLabel();
        tri_cargo = new javax.swing.JLabel();
        tri_persona = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Button_Cancelar.setText("Cancelar");

        Button_Enviar.setText("Enviar");
        Button_Enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_EnviarActionPerformed(evt);
            }
        });

        jLabel5.setText("Persona:");

        jLabel4.setText("Cargo:");

        jLabel3.setText("Vuelo:");

        jLabel2.setText("ID_Tripulante:");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("TRIPULANTE");

        id_tripulante.setText("jLabel6");

        tri_vuelo.setText("jLabel6");

        tri_cargo.setText("jLabel6");

        tri_persona.setText("jLabel6");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(142, 142, 142))
            .addGroup(layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(id_tripulante, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                    .addComponent(tri_vuelo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tri_cargo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tri_persona, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(88, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(Button_Enviar)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(189, 189, 189))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5))
                                .addGap(153, 153, 153))))
                    .addGap(38, 38, 38)
                    .addComponent(Button_Cancelar)
                    .addContainerGap(30, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addComponent(id_tripulante)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tri_vuelo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tri_cargo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tri_persona)
                .addContainerGap(125, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(73, 73, 73)
                    .addComponent(jLabel2)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jLabel3)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jLabel4)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jLabel5)
                    .addGap(44, 44, 44)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Button_Enviar)
                        .addComponent(Button_Cancelar))
                    .addContainerGap(60, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_EnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_EnviarActionPerformed
        EntityManagerFactory emf = null;
        try {
            emf = Persistence.createEntityManagerFactory("hangar");
            tripulanteController = new TripulanteController(emf);
            cargoController = new CargoController(emf);
            vueloController = new VueloController(emf);
            personaController = new PersonaController(emf);

            Long ID_Cargo = cargoController.getIdByColumn("car_nombre", this.Cargo);
            Long ID_Vuelo = vueloController.getIdByColumn("vue_codigo", this.Vuelo);
            Long ID_Persona = personaController.getIdByColumn("per_nombre", this.Persona);
            if (!isUpdate) {
                System.out.println("No es act");
                tripulanteController.createTripulante(ID_Vuelo, ID_Cargo, ID_Persona);
            } else {
                System.out.println(ID);
                tripulanteController.updateTripulante(ID, ID_Vuelo, ID_Cargo, ID_Persona);
            }
            this.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_Button_EnviarActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Formulario_Confirmacion_Tripulante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Formulario_Confirmacion_Tripulante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Formulario_Confirmacion_Tripulante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Formulario_Confirmacion_Tripulante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Cancelar;
    private javax.swing.JButton Button_Enviar;
    private javax.swing.JLabel id_tripulante;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel tri_cargo;
    private javax.swing.JLabel tri_persona;
    private javax.swing.JLabel tri_vuelo;
    // End of variables declaration//GEN-END:variables
}
