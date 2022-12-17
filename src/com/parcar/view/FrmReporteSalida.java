package com.parcar.view;

import com.parcar.controller.IngresoController;
import com.parcar.model.Ingreso;
import com.parcar.properties.RenderTable;
import java.awt.Color;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FrmReporteSalida extends javax.swing.JInternalFrame {

    public static IngresoController ingresoC = new IngresoController();
    public static SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyy HH:mm");

    public FrmReporteSalida() {
        initComponents();
        listar("");
    }

    public static void listar(String texto) {

        String columnas[] = {"Código", "placa", "Fecha Ingreso", "Fecha Salida", "Monto", "Vehículo",};
        DefaultTableModel modelo = new DefaultTableModel();

        for (String columna : columnas) {
            modelo.addColumn(columna);
        }

        Ingreso ingreso;
        List lista;

        if (txtBuscar.getText().length() == 0) {
            lista = ingresoC.listar();
        } else {
            lista = ingresoC.listar(texto);
        }

        for (Object obj : lista) {

            ingreso = (Ingreso) obj;

            modelo.addRow(new Object[]{
                ingreso.getCodigo(),
                ingreso.getPlaca(),
                formato.format(ingreso.getFechaIngreso()),
                formato.format(ingreso.getFechaSalida()),
                "S/. "+ingreso.getMonto(),
                ingreso.getTarifa().getTipoVehiculo().getDescripcion()
            });

        }

        tblListado.setRowHeight(30);
        tblListado.setModel(modelo);
        tblListado.setBackground(Color.WHITE);
        tblListado.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblListado.getColumnModel().getColumn(0).setPreferredWidth(170);
        tblListado.getColumnModel().getColumn(1).setPreferredWidth(80);
        tblListado.getColumnModel().getColumn(2).setPreferredWidth(120);
        tblListado.getColumnModel().getColumn(3).setPreferredWidth(120);
        tblListado.getColumnModel().getColumn(4).setPreferredWidth(70);
        tblListado.getColumnModel().getColumn(5).setPreferredWidth(150);
        lblTotal.setText(String.valueOf(tblListado.getRowCount()));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        txtBuscar = new org.edisoncor.gui.textField.TextFieldRectBackground();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListado = new javax.swing.JTable();
        lblTotal = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Reporte de Salidas");
        setPreferredSize(new java.awt.Dimension(745, 457));

        jLabel2.setBackground(new java.awt.Color(27, 118, 253));
        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/parcar/image/buscar20.png"))); // NOI18N
        jLabel2.setOpaque(true);

        txtBuscar.setBackground(new java.awt.Color(223, 235, 254));
        txtBuscar.setDescripcion("Ingrese el nombre");
        txtBuscar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        tblListado = new javax.swing.JTable(){
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        tblListado.setDefaultRenderer(Object.class, new RenderTable());
        tblListado.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        tblListado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblListado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblListado.setFillsViewportHeight(true);
        tblListado.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(tblListado);

        lblTotal.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel1.setText("Total");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 703, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTotal))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblTotal))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased

        if (txtBuscar.getText().length() % 2 == 0) {
            listar(txtBuscar.getText().toUpperCase());
        }
    }//GEN-LAST:event_txtBuscarKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel lblTotal;
    public static javax.swing.JTable tblListado;
    public static org.edisoncor.gui.textField.TextFieldRectBackground txtBuscar;
    // End of variables declaration//GEN-END:variables
}
