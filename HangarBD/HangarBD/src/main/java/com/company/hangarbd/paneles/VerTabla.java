package com.company.hangarbd.paneles;

import com.company.hangarbd.controller.CargoController;
import com.company.hangarbd.controller.Controller;
import com.company.hangarbd.controller.EmpresaController;
import com.company.hangarbd.controller.HangarController;
import com.company.hangarbd.controller.NaveController;
import com.company.hangarbd.controller.PersonaController;
import com.company.hangarbd.controller.TripulanteController;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.table.DefaultTableModel;

public class VerTabla extends javax.swing.JFrame {

    EntityManagerFactory emf = null;
    Controller controller = new Controller();
    String OpcionSeleccionada;
    DefaultTableModel modeloTabla;

    public VerTabla() {
        initComponents();
        this.Tabla.setVisible(false);
        this.InicializarCombos();
    }

    private void InicializarCombos() {
        String[] Entidades = {"Cargo", "Empresa", "Hangar", "Persona", "Tripulante",
            "Taller", "Servicio", "Vuelo", "Nave", "Modelo", "Piloto"};
        for (String entidad : Entidades) {
            this.Cb_Tablas.addItem(entidad);
        }

    }

    private void getColumns(List<String> Columnas) {
        System.out.println(Columnas);
        for (String columna : Columnas) {
            modeloTabla.addColumn(columna);
        }
    }

    private void getRows(List<List<String>> Tuplas) {
        System.out.println(Tuplas);
        for (List<String> tupla : Tuplas) {
            modeloTabla.addRow(tupla.toArray());
        }
    }

    private void getTable(List<String> Columnas, String Entidad, int atributos) {
        try {
            List<List<String>> Tuplas = this.controller.mapEntitiesToString(Entidad, emf, atributos);
            this.getColumns(Columnas);
            this.getRows(Tuplas);
            this.Tabla.setModel(modeloTabla);
            this.Tabla.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TablaPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        Cb_Tablas = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        B_Buscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Cb_Tablas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cb_TablasActionPerformed(evt);
            }
        });

        jLabel1.setText("Seleccionar Tabla:");

        B_Buscar.setText("Buscar");
        B_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_BuscarActionPerformed(evt);
            }
        });

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(Tabla);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Cb_Tablas, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(B_Buscar)))
                .addGap(39, 39, 39))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Cb_Tablas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B_Buscar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout TablaPanelLayout = new javax.swing.GroupLayout(TablaPanel);
        TablaPanel.setLayout(TablaPanelLayout);
        TablaPanelLayout.setHorizontalGroup(
            TablaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TablaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        TablaPanelLayout.setVerticalGroup(
            TablaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TablaPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(358, 358, 358))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TablaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 593, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TablaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Cb_TablasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cb_TablasActionPerformed
        this.OpcionSeleccionada = this.Cb_Tablas.getSelectedItem().toString();
    }//GEN-LAST:event_Cb_TablasActionPerformed

    private void B_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_BuscarActionPerformed
        modeloTabla = new DefaultTableModel();
        emf = Persistence.createEntityManagerFactory("hangar");
        List<String> Columnas;
        switch (OpcionSeleccionada) {
            case "Hangar":
                HangarController hangarController = new HangarController(emf);
                Columnas = hangarController.getColumnsFromHangar();
                this.getTable(Columnas, OpcionSeleccionada, Columnas.size());
                break;
            case "Cargo":
                CargoController cargoController = new CargoController(emf);
                Columnas = cargoController.getColumnsFromCargo();
                this.getTable(Columnas, OpcionSeleccionada, Columnas.size());
                break;
            case "Empresa":
                EmpresaController empresaController = new EmpresaController(emf);
                Columnas = empresaController.getColumnsFromEmpresa();
                this.getTable(Columnas, OpcionSeleccionada, Columnas.size());
                break;
            case "Persona":
                PersonaController personaController = new PersonaController(emf);
                Columnas = personaController.getColumnsFromPersona();
                this.getTable(Columnas, OpcionSeleccionada, Columnas.size());
                break;
            case "Tripulante":
                TripulanteController tripulanteController = new TripulanteController(emf);
                Columnas = tripulanteController.getColumnsFromTripulante();
                this.getTable(Columnas, OpcionSeleccionada, Columnas.size());
                break;
            case "Nave":
                NaveController naveController = new NaveController(emf);
                Columnas = naveController.getColumnsFromNave();
                this.getTable(Columnas, OpcionSeleccionada, Columnas.size());
                break;
        }
    }//GEN-LAST:event_B_BuscarActionPerformed

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
            java.util.logging.Logger.getLogger(VerTabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerTabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerTabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerTabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VerTabla().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B_Buscar;
    private javax.swing.JComboBox<String> Cb_Tablas;
    private javax.swing.JTable Tabla;
    private javax.swing.JPanel TablaPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
