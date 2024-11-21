package com.company.hangarbd.views.interfaz;

import com.company.hangarbd.controller.CargoController;
import com.company.hangarbd.models.Cargo;
import com.company.hangarbd.views.confirmacion.Formulario_Confirmacion_Cargo;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Formulario_Insert_Cargo extends javax.swing.JFrame {
    
    Long ID;
    Cargo.cargos nombre;
    String Descripcion;
    CargoController cargoController;
    
    public Formulario_Insert_Cargo(List<String> Tupla) {
        initComponents();
        this.id_cargo.setText(Tupla.get(0));
        switch (Tupla.get(1)) {
            case "PILOTO":
                this.car_nombre.setSelectedItem("PILOTO");
                break;
            case "COPILOTO":
                this.car_nombre.setSelectedItem("COPILOTO");
                break;            
            case "INGENIERO":
                this.car_nombre.setSelectedItem("INGENIERO");
                break;
            case "AUXILIAR":
                this.car_nombre.setSelectedItem("AUXILIAR");
                break;
        }
        this.car_descripcion.setText(Tupla.get(2));
        this.Button_Enviar.setText("Actualizar");
    }
    
    public Formulario_Insert_Cargo() {
        initComponents();
        this.getLastID();
    }
    
    public void getAttributes() {
        this.nombre = (Cargo.cargos.valueOf(this.car_nombre.getSelectedItem().toString()));
        this.Descripcion = this.car_descripcion.getText();
    }
    
    public void getLastID() {
        EntityManagerFactory emf = null;
        try {
            emf = Persistence.createEntityManagerFactory("hangar");
            cargoController = new CargoController(emf);
            ID = cargoController.getLastID_Cargo() + 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.id_cargo.setText(String.valueOf(ID));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        id_cargo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        car_descripcion = new javax.swing.JTextField();
        Button_Enviar = new javax.swing.JButton();
        Button_Cancelar = new javax.swing.JButton();
        car_nombre = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("CARGO");

        jLabel2.setText("ID_Cargo:");

        id_cargo.setEditable(false);

        jLabel3.setText("Nombre:");

        jLabel4.setText("Descripcion:");

        Button_Enviar.setText("Enviar");
        Button_Enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_EnviarActionPerformed(evt);
            }
        });

        Button_Cancelar.setText("Cancelar");

        car_nombre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PILOTO", "COPILOTO", "INGENIERO", "AUXILIAR" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(car_descripcion))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(id_cargo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(83, 83, 83))
                            .addComponent(car_nombre, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(171, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Button_Enviar)
                    .addComponent(jLabel1))
                .addGap(30, 30, 30)
                .addComponent(Button_Cancelar)
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(id_cargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(car_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(car_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_Enviar)
                    .addComponent(Button_Cancelar))
                .addContainerGap(83, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_EnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_EnviarActionPerformed
        this.getAttributes();
        Formulario_Confirmacion_Cargo FCC = new Formulario_Confirmacion_Cargo(ID, nombre, Descripcion);
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
            java.util.logging.Logger.getLogger(Formulario_Insert_Cargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Formulario_Insert_Cargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Formulario_Insert_Cargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Formulario_Insert_Cargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Formulario_Insert_Cargo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Cancelar;
    private javax.swing.JButton Button_Enviar;
    private javax.swing.JTextField car_descripcion;
    private javax.swing.JComboBox<String> car_nombre;
    private javax.swing.JTextField id_cargo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
