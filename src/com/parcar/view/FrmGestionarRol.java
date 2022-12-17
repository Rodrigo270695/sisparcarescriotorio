
package com.parcar.view;

import com.parcar.controller.RolController;
import com.parcar.model.Rol;
import com.parcar.properties.RenderTable;
import com.parcar.view.modal.MdGestionarRol;
import com.parcar.view.modal.MdPermisos;
import com.parcar.view.modal.alert.*;
import java.awt.Color;
import java.awt.Image;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FrmGestionarRol extends javax.swing.JInternalFrame {

    public static RolController rolC = new RolController();
    
    public FrmGestionarRol() {
        initComponents();
        listar("");
    }
    
    public static void listar(String texto){
        
        String columnas[] = {"#","Descripcion","","","",""};
        DefaultTableModel modelo = new DefaultTableModel();
        
        for (String columna : columnas) {
            modelo.addColumn(columna);
        }
        
        Rol rol;
        List lista;
        
        if (txtBuscar.getText().length() == 0) {
            lista = rolC.listar();
        } else {
            lista = rolC.listar(texto);
        }
        
        for (Object obj : lista) {
            
            rol = (Rol) obj;
            ImageIcon iconoModi = new ImageIcon("src/com/parcar/image/editar.png");
            Icon btnModificar = new ImageIcon(iconoModi.getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT));
            JButton botonModificar = new JButton("", btnModificar);
            botonModificar.setName("btnModificar");
            botonModificar.setToolTipText("modificar");
            botonModificar.setBorder(null);
            botonModificar.setBackground(new Color(255, 198, 26));

            ImageIcon icono = new ImageIcon("src/com/parcar/image/eliminar.png");
            Icon btnEliminar = new ImageIcon(icono.getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT));
            JButton botonEliminar = new JButton("", btnEliminar);
            botonEliminar.setName("btnEliminar");
            botonEliminar.setToolTipText("eliminar");
            botonEliminar.setBorder(null);
            botonEliminar.setBackground(new Color(223, 68, 83));
            
            ImageIcon iconoPerm = new ImageIcon("src/com/parcar/image/check.png");
            Icon btnPermiso = new ImageIcon(iconoPerm.getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT));
            JButton botonPermiso = new JButton("", btnPermiso);
            botonPermiso.setName("btnPermiso");
            botonPermiso.setToolTipText("Permisos");
            botonPermiso.setBorder(null);
            botonPermiso.setBackground(new Color(120, 128, 135));

            ImageIcon iconoVer = new ImageIcon("src/com/parcar/image/ver.png");
            Icon btnVer = new ImageIcon(iconoVer.getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT));
            JButton botonVer = new JButton("", btnVer);
            botonVer.setName("btnVer");
            botonVer.setToolTipText("vista del registro");
            botonVer.setBorder(null);
            botonVer.setBackground(new Color(41, 143, 96));
            
            modelo.addRow(new Object[]{
                rol.getRolId(),
                rol.getDescripcion(),
                botonModificar,
                botonEliminar,
                botonPermiso,
                botonVer
            });
        }
        
        tblListado.setRowHeight(30);
        tblListado.setModel(modelo);
        tblListado.setBackground(Color.WHITE);
        tblListado.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblListado.getColumnModel().getColumn(0).setMaxWidth(0);
        tblListado.getColumnModel().getColumn(0).setMinWidth(0);
        tblListado.getColumnModel().getColumn(0).setPreferredWidth(0);
        tblListado.getColumnModel().getColumn(1).setPreferredWidth(475);
        tblListado.getColumnModel().getColumn(2).setPreferredWidth(30);
        tblListado.getColumnModel().getColumn(3).setPreferredWidth(30);
        tblListado.getColumnModel().getColumn(4).setPreferredWidth(30);
        tblListado.getColumnModel().getColumn(5).setPreferredWidth(30);
        lblTotal.setText(String.valueOf(tblListado.getRowCount()));
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        txtBuscar = new org.edisoncor.gui.textField.TextFieldRectBackground();
        btnAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListado = new javax.swing.JTable();
        lblTotal = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Gestionar Rol");

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

        btnAdd.setBackground(new java.awt.Color(27, 118, 253));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/parcar/image/mas20.png"))); // NOI18N
        btnAdd.setBorder(null);
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd.setOpaque(true);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
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
        tblListado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListadoMouseClicked(evt);
            }
        });
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTotal)
                        .addGap(0, 562, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        MdGestionarRol frm = new MdGestionarRol();
        FrmMenuPrincipal.centrarVentana(frm);
    }//GEN-LAST:event_btnAddActionPerformed

    private void tblListadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListadoMouseClicked

        int fila = tblListado.getSelectedRow();
        int id = Integer.parseInt(tblListado.getValueAt(fila, 0).toString());

        int colum = tblListado.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / tblListado.getRowHeight();

        if (row < tblListado.getRowCount() && row >= 0 && colum < tblListado.getColumnCount() && colum >= 0) {
            Object value = tblListado.getValueAt(row, colum);

            if (value instanceof JButton jButton) {
                jButton.doClick();
                JButton boton = jButton;
                int filas = tblListado.getSelectedRowCount();

                switch (boton.getName()) {
                    case "btnEliminar" -> {
                        if (filas == 0) {//si no elije ninguna fila
                            Alerta alerta = new Alerta("Alerta", "Debe seleccionar un tipo");
                        } else {
                            String valor = String.valueOf(tblListado.getValueAt(fila, 1));

                            int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar al tipo " + valor + "?", "Confirmar", 2);
                            if (opcion == 0) {

                                try {
                                    rolC.eliminar(id);
                                    AlertaBien alertaBien = new AlertaBien("Mensaje", "tipo eliminado correctamente!");
                                    listar("");
                                } catch (Exception ex) {
                                    AlertaError err = new AlertaError("ERROR", ex.getMessage());
                                }

                            } else {
                                Alerta alerta = new Alerta("Alerta", "Operación cancelada!");
                            }

                        }
                    }
                    case "btnModificar" -> {
                        if (filas == 0) {//si no elije ninguna fila
                            Alerta alerta = new Alerta("Alerta", "Debe seleccionar un tipo");
                        } else {

                            MdGestionarRol.idRol = id;
                            FrmMenuPrincipal.centrarVentana(new MdGestionarRol());
                            MdGestionarRol.btnGrabar.setText("Modificar");

                        }
                    }
                    case "btnPermiso" -> {
                        MdPermisos.idRol = id;
                        FrmMenuPrincipal.centrarVentana(new MdPermisos());
                    }
                    case "btnVer" -> {
                        if (filas == 0) {
                            Alerta alerta = new Alerta("Alerta", "Debe seleccionar un tipo");
                        } else {
                            MdGestionarRol.vista = true;
                            MdGestionarRol.idRol = id;
                            FrmMenuPrincipal.centrarVentana(new MdGestionarRol());
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_tblListadoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel lblTotal;
    public static javax.swing.JTable tblListado;
    public static org.edisoncor.gui.textField.TextFieldRectBackground txtBuscar;
    // End of variables declaration//GEN-END:variables
}
