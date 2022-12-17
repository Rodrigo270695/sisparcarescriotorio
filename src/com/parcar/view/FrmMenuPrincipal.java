
package com.parcar.view;

import com.parcar.controller.DetallePermisoController;
import com.parcar.model.DetallePermiso;
import com.parcar.model.Permiso;
import com.parcar.model.Usuario;
import java.awt.Dimension;
import javax.swing.JInternalFrame;

public class FrmMenuPrincipal extends javax.swing.JFrame {

    DetallePermisoController dpC = new DetallePermisoController();
    public static Usuario usuario;
    
    public FrmMenuPrincipal() {
        initComponents();
        this.setExtendedState(6);
        this.setTitle("..:: SISTEMA DE PARQUEO - PARCAR ::..");
        deshabilitarControles();
        cargarPermisos();
        cargarUsuario();
    }
    
    private void cargarPermisos(){
        
        DetallePermiso detalleP = dpC.listar(usuario.getDocumento());
        
        for (Permiso permiso : detalleP.getPermisos()) {

            switch (permiso.getDescripcion()) {
                case "mnuMantenimiento" -> {
                    mnuMantenimiento.setVisible(true);
                }
                case "mnuTarifas" -> {
                    mnuTarifas.setVisible(true);
                }
                case "mnuIngreso" -> {
                    mnuIngreso.setVisible(true);
                }
                case "mnuSalida" -> {
                    mnuSalida.setVisible(true);
                }
                case "mnuCaja" -> {
                    mnuCaja.setVisible(true);
                }
                case "mnuReporte" -> {
                    mnuReporte.setVisible(true);
                }
                case "mnuAdmin" -> {
                    mnuAdmin.setVisible(true);
                }
            }
            
        }
        
        
    }
    
    private void deshabilitarControles(){
        mnuAdmin.setVisible(false);
        mnuCaja.setVisible(false);
        mnuIngreso.setVisible(false);
        mnuMantenimiento.setVisible(false);
        mnuReporte.setVisible(false);
        mnuSalida.setVisible(false);
        mnuTarifas.setVisible(false);
    }
    
    private void cargarUsuario(){
        
        String usuarioA = "";
        String nombres = usuario.getNombres().trim();
        String apellidos = usuario.getApellidos().trim();
        int indiceN = nombres.indexOf(" ");
        int indiceA = apellidos.indexOf(" ");
        
        if (indiceN == -1) {
            usuarioA += nombres+" ";
        }else{
            usuarioA += nombres.substring(0, indiceN)+" ";
        }
        
        if (indiceA == -1) {
            usuarioA += apellidos+" ";
        }else{
            usuarioA += apellidos.substring(0, indiceA)+" ";
        }
        
        mnuUsuario.setText(usuarioA);
    }
    
    public static void centrarVentana(JInternalFrame frame) {
        escritorio.add(frame);
        Dimension dimension = escritorio.getSize();
        Dimension ventana = frame.getSize();
        frame.setLocation((dimension.width - ventana.width) / 2, (dimension.height - ventana.height) / 2);
        frame.show();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        mnuBar = new javax.swing.JMenuBar();
        mnuMantenimiento = new javax.swing.JMenu();
        subMnuGestionarVehiculo = new javax.swing.JMenuItem();
        mnuTarifas = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        mnuIngreso = new javax.swing.JMenu();
        mnuSalida = new javax.swing.JMenu();
        mnuCaja = new javax.swing.JMenu();
        mnuReporte = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        mnuAdmin = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        mnuUsuario = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        escritorio.setBackground(new java.awt.Color(102, 102, 255));

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1187, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 571, Short.MAX_VALUE)
        );

        mnuMantenimiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/parcar/image/mantenimiento50.png"))); // NOI18N
        mnuMantenimiento.setText("Mantenimiento");
        mnuMantenimiento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mnuMantenimiento.setFont(new java.awt.Font("Segoe UI Symbol", 0, 15)); // NOI18N
        mnuMantenimiento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mnuMantenimiento.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        mnuMantenimiento.setPreferredSize(new java.awt.Dimension(140, 90));
        mnuMantenimiento.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        subMnuGestionarVehiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/parcar/image/car30.png"))); // NOI18N
        subMnuGestionarVehiculo.setText("Gestionar Tipo Vehículo");
        subMnuGestionarVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMnuGestionarVehiculoActionPerformed(evt);
            }
        });
        mnuMantenimiento.add(subMnuGestionarVehiculo);

        mnuBar.add(mnuMantenimiento);

        mnuTarifas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/parcar/image/tarifa50.png"))); // NOI18N
        mnuTarifas.setText("Tarifas");
        mnuTarifas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mnuTarifas.setFont(new java.awt.Font("Segoe UI Symbol", 0, 15)); // NOI18N
        mnuTarifas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mnuTarifas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        mnuTarifas.setPreferredSize(new java.awt.Dimension(140, 90));
        mnuTarifas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/parcar/image/money30.png"))); // NOI18N
        jMenuItem4.setText("Gestionar Tarifa");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        mnuTarifas.add(jMenuItem4);

        mnuBar.add(mnuTarifas);

        mnuIngreso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/parcar/image/ingreso50.png"))); // NOI18N
        mnuIngreso.setText("Ingreso");
        mnuIngreso.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mnuIngreso.setFont(new java.awt.Font("Segoe UI Symbol", 0, 15)); // NOI18N
        mnuIngreso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mnuIngreso.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        mnuIngreso.setPreferredSize(new java.awt.Dimension(140, 90));
        mnuIngreso.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        mnuIngreso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuIngresoMouseClicked(evt);
            }
        });
        mnuBar.add(mnuIngreso);

        mnuSalida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/parcar/image/salida50.png"))); // NOI18N
        mnuSalida.setText("Salida");
        mnuSalida.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mnuSalida.setFont(new java.awt.Font("Segoe UI Symbol", 0, 15)); // NOI18N
        mnuSalida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mnuSalida.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        mnuSalida.setPreferredSize(new java.awt.Dimension(140, 90));
        mnuSalida.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        mnuSalida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuSalidaMouseClicked(evt);
            }
        });
        mnuBar.add(mnuSalida);

        mnuCaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/parcar/image/caja50.png"))); // NOI18N
        mnuCaja.setText("Caja");
        mnuCaja.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mnuCaja.setFont(new java.awt.Font("Segoe UI Symbol", 0, 15)); // NOI18N
        mnuCaja.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mnuCaja.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        mnuCaja.setPreferredSize(new java.awt.Dimension(140, 90));
        mnuCaja.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        mnuBar.add(mnuCaja);

        mnuReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/parcar/image/reporte50.png"))); // NOI18N
        mnuReporte.setText("Reporte");
        mnuReporte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mnuReporte.setFont(new java.awt.Font("Segoe UI Symbol", 0, 15)); // NOI18N
        mnuReporte.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mnuReporte.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        mnuReporte.setPreferredSize(new java.awt.Dimension(140, 90));
        mnuReporte.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/parcar/image/report30.png"))); // NOI18N
        jMenuItem5.setText("Reporte de Salidas");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        mnuReporte.add(jMenuItem5);

        mnuBar.add(mnuReporte);

        mnuAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/parcar/image/admin50.png"))); // NOI18N
        mnuAdmin.setText("Admin");
        mnuAdmin.setFont(new java.awt.Font("Segoe UI Symbol", 0, 15)); // NOI18N
        mnuAdmin.setHideActionText(true);
        mnuAdmin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mnuAdmin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        mnuAdmin.setPreferredSize(new java.awt.Dimension(140, 90));
        mnuAdmin.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/parcar/image/rol30.png"))); // NOI18N
        jMenuItem1.setText("Gestionar Rol");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        mnuAdmin.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/parcar/image/user30.png"))); // NOI18N
        jMenuItem2.setText("Gestionar Usuario");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        mnuAdmin.add(jMenuItem2);

        mnuBar.add(mnuAdmin);

        mnuUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/parcar/image/user50.png"))); // NOI18N
        mnuUsuario.setText("Usuario");
        mnuUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mnuUsuario.setFont(new java.awt.Font("Segoe UI Symbol", 0, 15)); // NOI18N
        mnuUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mnuUsuario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        mnuUsuario.setPreferredSize(new java.awt.Dimension(140, 90));
        mnuUsuario.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/parcar/image/cerrarSesion30.png"))); // NOI18N
        jMenuItem3.setText("Cerrar Sesión");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        mnuUsuario.add(jMenuItem3);

        mnuBar.add(mnuUsuario);

        setJMenuBar(mnuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void subMnuGestionarVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMnuGestionarVehiculoActionPerformed
        
        centrarVentana( new FrmGestionarTipoVehiculo() );
        
    }//GEN-LAST:event_subMnuGestionarVehiculoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        
        centrarVentana( new FrmGestionarRol());
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        
        centrarVentana( new FrmGestionarUsuario());
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        FrmLogin frm = new FrmLogin();
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        
        centrarVentana( new FrmGestionarTarifa());
        
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void mnuIngresoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuIngresoMouseClicked
        
        centrarVentana( new FrmGestionarIngreso());
        
    }//GEN-LAST:event_mnuIngresoMouseClicked

    private void mnuSalidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuSalidaMouseClicked
        
        centrarVentana( new FrmGestionarSalida());
        
    }//GEN-LAST:event_mnuSalidaMouseClicked

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        
        centrarVentana( new FrmReporteSalida());
        
    }//GEN-LAST:event_jMenuItem5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenu mnuAdmin;
    private javax.swing.JMenuBar mnuBar;
    private javax.swing.JMenu mnuCaja;
    private javax.swing.JMenu mnuIngreso;
    private javax.swing.JMenu mnuMantenimiento;
    private javax.swing.JMenu mnuReporte;
    private javax.swing.JMenu mnuSalida;
    private javax.swing.JMenu mnuTarifas;
    private javax.swing.JMenu mnuUsuario;
    private javax.swing.JMenuItem subMnuGestionarVehiculo;
    // End of variables declaration//GEN-END:variables
}
