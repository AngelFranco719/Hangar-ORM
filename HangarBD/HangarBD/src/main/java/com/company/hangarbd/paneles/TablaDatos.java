/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.company.hangarbd.paneles;

import com.company.hangarbd.controller.CargoController;
import com.company.hangarbd.controller.EmpresaController;
import com.company.hangarbd.controller.ModeloController;
import com.company.hangarbd.controller.ServicioController;
import com.company.hangarbd.controller.NaveController;
import com.company.hangarbd.controller.PersonaController;
import com.company.hangarbd.controller.PilotoController;
import com.company.hangarbd.controller.TallerController;
import com.company.hangarbd.controller.HangarController;
import com.company.hangarbd.controller.TripulanteController;
import com.company.hangarbd.controller.VueloController;
import java.util.List;
import javax.swing.table.DefaultTableModel;
public class TablaDatos <T> extends javax.swing.JPanel {
    CargoController Car_Controller;
    EmpresaController Emp_Controller;
    ModeloController Mod_Controller;
    ServicioController Ser_Controller;
    NaveController Nav_Controller;
    PersonaController Per_Controller;
    PilotoController Pil_Controller;
    TallerController Tal_Controller;
    HangarController Han_Controller;
    TripulanteController Tri_Controller;
    VueloController Vue_Controller;
    int cantidad_atributos=0; 
    
   
    public TablaDatos(CargoController Car_Controller, EmpresaController Emp_Controller, ModeloController Mod_Controller, ServicioController Ser_Controller, NaveController Nav_Controller,
            PersonaController Per_Controller, PilotoController Pil_Controller, TallerController Tal_Controller, HangarController Han_Controller, TripulanteController Tri_Controller, VueloController Vue_Controller) {
        initComponents();
        this.Car_Controller=Car_Controller;
        this.Emp_Controller=Emp_Controller;
        this.Mod_Controller=Mod_Controller;
        this.Ser_Controller=Ser_Controller;
        this.Nav_Controller=Nav_Controller;
        this.Per_Controller=Per_Controller;
        this.Pil_Controller=Pil_Controller;
        this.Tal_Controller=Tal_Controller;
        this.Han_Controller=Han_Controller;
        this.Tri_Controller=Tri_Controller;
        this.Vue_Controller=Vue_Controller;
        this.setVisible(true);
        this.InicializarCombos();
    }
    
    private void InicializarCombos(){
        String[] Entidades={"Cargo", "Empresa", "Hangar", "Persona", "Tripulante",
                             "Taller","Servicio", "Vuelo", "Nave", "Modelo", "Piloto"};
        cantidad_atributos=Entidades.length;
        this.Cb_Tablas.removeAllItems();
        for(String entidad : Entidades){
            this.Cb_Tablas.addItem(entidad);
        }
    
     }
        

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        T_Instancias = new javax.swing.JTable();
        Cb_Tablas2 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        B_Buscar = new javax.swing.JButton();

        T_Instancias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(T_Instancias);

        Cb_Tablas2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Cb_Tablas2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cb_Tablas2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Seleccionar Tabla:");

        B_Buscar.setText("Buscar");
        B_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_BuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Cb_Tablas2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(B_Buscar)))
                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Cb_Tablas2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B_Buscar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void Cb_Tablas2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cb_Tablas2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cb_Tablas2ActionPerformed

    private void B_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_BuscarActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_B_BuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B_Buscar;
    private javax.swing.JComboBox<String> Cb_Tablas;
    private javax.swing.JComboBox<String> Cb_Tablas1;
    private javax.swing.JComboBox<String> Cb_Tablas2;
    private javax.swing.JTable T_Instancias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
