package com.company.hangarbd.views.interfaz;

import com.company.hangarbd.paneles.VerTabla;

public class FramePrincipal extends javax.swing.JFrame {

    boolean isBuscarActive = false;
    boolean isInsert = false;
    boolean isUpdate = false;
    String SelectedEntity;

    public FramePrincipal() {
        initComponents();
        this.setVisible(true);
        this.Buscar_JPanel.setVisible(false);
        this.initializeCBEntidades();
    }

    public void initializeCBEntidades() {
        String[] Entidades = {"Cargo", "Empresa", "Hangar", "Modelo",
            "Nave", "Persona", "Piloto", "Servicio",
            "Taller", "Tripulante", "Vuelo"
        };
        for (String entidad : Entidades) {
            this.CB_Entidades.addItem(entidad);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jToggleButton4 = new javax.swing.JToggleButton();
        Buscar_JPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        CB_Entidades = new javax.swing.JComboBox<>();
        B_Buscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Humnst777 Cn BT", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Sistema de Gestión de Hangares");

        jToggleButton1.setText("Insertar Datos");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jToggleButton2.setText("Ver Datos");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        jToggleButton3.setText("Actualizar Datos");
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });

        jToggleButton4.setText("Borrar Datos");
        jToggleButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton4ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Selecciona la Entidad:");

        CB_Entidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_EntidadesActionPerformed(evt);
            }
        });

        B_Buscar.setText("Buscar");
        B_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_BuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Buscar_JPanelLayout = new javax.swing.GroupLayout(Buscar_JPanel);
        Buscar_JPanel.setLayout(Buscar_JPanelLayout);
        Buscar_JPanelLayout.setHorizontalGroup(
            Buscar_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Buscar_JPanelLayout.createSequentialGroup()
                .addContainerGap(103, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(26, 26, 26)
                .addComponent(CB_Entidades, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
            .addGroup(Buscar_JPanelLayout.createSequentialGroup()
                .addGap(206, 206, 206)
                .addComponent(B_Buscar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Buscar_JPanelLayout.setVerticalGroup(
            Buscar_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Buscar_JPanelLayout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(Buscar_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(CB_Entidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(B_Buscar)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Buscar_JPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jToggleButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jToggleButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jToggleButton3)
                                .addGap(18, 18, 18)
                                .addComponent(jToggleButton4))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jLabel1)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton1)
                    .addComponent(jToggleButton2)
                    .addComponent(jToggleButton3)
                    .addComponent(jToggleButton4))
                .addGap(18, 18, 18)
                .addComponent(Buscar_JPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        if (!isBuscarActive) {
            this.Buscar_JPanel.setVisible(true);
            isInsert = true;
        } else {
            this.Buscar_JPanel.setVisible(false);
            isInsert = false;
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void CB_EntidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_EntidadesActionPerformed
        this.SelectedEntity = CB_Entidades.getSelectedItem().toString();
    }//GEN-LAST:event_CB_EntidadesActionPerformed

    private void B_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_BuscarActionPerformed
        switch (SelectedEntity) {
            case "Cargo":
                if (isInsert) {
                    Formulario_Insert_Cargo FIC = new Formulario_Insert_Cargo();
                    FIC.setVisible(true);
                }
                break;
            case "Empresa":
                if (isInsert) {
                    Formulario_Insert_Empresa FIE = new Formulario_Insert_Empresa();
                    FIE.setVisible(true);
                }
                break;
            case "Hangar":
                if (isInsert) {
                    Formulario_Insert_Hangar FIH = new Formulario_Insert_Hangar();
                    FIH.setVisible(true);
                }
                break;
            case "Modelo":
                if (isInsert) {
                    Formulario_Insert_Modelo FIM = new Formulario_Insert_Modelo();
                    FIM.setVisible(true);
                }
                break;
            case "Nave":
                if (isInsert) {
                    Formulario_Insert_Nave FIN = new Formulario_Insert_Nave();
                    FIN.setVisible(true);
                }
                break;
            case "Persona":
                if (isInsert) {
                    Formulario_Insert_Persona FIP = new Formulario_Insert_Persona();
                    FIP.setVisible(true);
                }
                break;
            case "Piloto":
                if (isInsert) {
                    Formulario_Insert_Piloto FIPi = new Formulario_Insert_Piloto();
                    FIPi.setVisible(true);
                }
                break;
            case "Servicio":
                if (isInsert) {
                    Formulario_Insert_Servicio FIS = new Formulario_Insert_Servicio();
                    FIS.setVisible(true);
                }
                break;
            case "Taller":
                if (isInsert) {
                    Formulario_Insert_Taller FIT = new Formulario_Insert_Taller();
                    FIT.setVisible(true);
                }
                break;
            case "Tripulante":
                if (isInsert) {
                    Formulario_Insert_Tripulante FITr = new Formulario_Insert_Tripulante();
                    FITr.setVisible(true);
                }
                break;
            case "Vuelo":
                Formulario_Insert_Nave FIN = new Formulario_Insert_Nave();
                FIN.setVisible(true);
                break;
        }
    }//GEN-LAST:event_B_BuscarActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        VerTabla tabla = new VerTabla();
        tabla.setVisible(true);
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        this.isUpdate = true;
        VerTabla tabla = new VerTabla(this.isUpdate);
        tabla.setVisible(true);
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    private void jToggleButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton4ActionPerformed
        VerTabla tabla = new VerTabla("isDelete");
        tabla.setVisible(true);
    }//GEN-LAST:event_jToggleButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FramePrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B_Buscar;
    private javax.swing.JPanel Buscar_JPanel;
    private javax.swing.JComboBox<String> CB_Entidades;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    // End of variables declaration//GEN-END:variables
}
