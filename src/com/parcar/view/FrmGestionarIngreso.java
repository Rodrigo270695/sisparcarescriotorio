package com.parcar.view;

import com.parcar.controller.IngresoController;
import com.parcar.controller.TarifaController;
import com.parcar.controller.UsuarioController;
import com.parcar.model.Ingreso;
import com.parcar.model.Tarifa;
import com.parcar.model.Usuario;
import com.parcar.view.modal.alert.AlertaBien;
import com.parcar.view.modal.alert.AlertaError;
import java.util.List;
import java.util.Random;

public class FrmGestionarIngreso extends javax.swing.JInternalFrame {

    public static IngresoController ingresoC = new IngresoController();
    TarifaController tarifaC = new TarifaController();
    UsuarioController usuarioC = new UsuarioController();

    public FrmGestionarIngreso() {
        initComponents();
        cargarTipoVehiculo();
    }

    private void cargarTipoVehiculo() {

        cbxTipoVehiculo.removeAllItems();

        Tarifa tarifa;
        List lista = tarifaC.listar();

        for (int i = 0; i < lista.size(); i++) {
            tarifa = (Tarifa) lista.get(i);
            cbxTipoVehiculo.addItem(tarifa.getTipoVehiculo().getDescripcion());
        }

    }

    private String generarCodigo() {

        Random aleatorio = new Random();
        String alfa = "ABCDEFGHIJKLMNOPQRSTVWXYZ";
        String cadena = "";
        int forma;

        for (int i = 0; i < 10; i++) {
            forma = (int) (aleatorio.nextDouble() * alfa.length() - 1 + 0);
            cadena += ""+alfa.charAt(forma) + ((int) (aleatorio.nextDouble() * 9 + 1));
        }

        return cadena;
    }
    
    private void registrarIngreso(){
        
        Ingreso ingreso = new Ingreso(
                generarCodigo(),
                txtPlaca.getText().toUpperCase(),
                (Tarifa) tarifaC.obtenerObjecto(cbxTipoVehiculo.getSelectedItem().toString()), 
                (Usuario) usuarioC.obtenerObjecto(FrmMenuPrincipal.usuario.getUsuarioId())
        );
        
        try {
            
            ingresoC.registrar(ingreso);
            AlertaBien alertaB = new AlertaBien("MENSAJE", "Se registro correctamente el ingreso");
            txtPlaca.setText("");
            cbxTipoVehiculo.setSelectedIndex(0);
            
        } catch (Exception e) {
            e.printStackTrace(System.err);
            AlertaError alertaE = new AlertaError("ERROR", "Ocurrio un error comuníquese con Administración");
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtPlaca = new org.edisoncor.gui.textField.TextFieldRectBackground();
        jLabel3 = new javax.swing.JLabel();
        cbxTipoVehiculo = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Registrar Ingreso");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnRegistrar.setBackground(new java.awt.Color(27, 118, 253));
        btnRegistrar.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setMnemonic('N');
        btnRegistrar.setText("Registrar");
        btnRegistrar.setToolTipText("Realizar Nuevo Registro");
        btnRegistrar.setBorder(null);
        btnRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Placa:");

        txtPlaca.setDescripcion("ej. abc-345");
        txtPlaca.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Tarifa");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxTipoVehiculo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(12, 12, 12))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxTipoVehiculo)))
                .addGap(30, 30, 30)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed

        registrarIngreso();
        
    }//GEN-LAST:event_btnRegistrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cbxTipoVehiculo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtPlaca;
    // End of variables declaration//GEN-END:variables
}
