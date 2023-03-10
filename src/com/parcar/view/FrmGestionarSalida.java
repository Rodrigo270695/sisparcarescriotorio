package com.parcar.view;

import com.parcar.controller.IngresoController;
import com.parcar.model.Ingreso;
import com.parcar.properties.RenderTable;
import com.parcar.view.modal.alert.*;
import java.awt.Color;
import java.awt.Image;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FrmGestionarSalida extends javax.swing.JInternalFrame {

    public static IngresoController ingresoC = new IngresoController();
    public static SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyy HH:mm");

    public FrmGestionarSalida() {
        initComponents();
        listar("");
    }

    public static void listar(String texto) {

        String columnas[] = {"Código", "placa", "Fecha - Hora", "Precio", "Vehículo", "", ""};
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

            ImageIcon iconoDa = new ImageIcon("src/com/parcar/image/darSalida.png");
            Icon btnSalida = new ImageIcon(iconoDa.getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT));
            JButton botonSalida = new JButton("", btnSalida);
            botonSalida.setName("btnSalida");
            botonSalida.setToolTipText("Dar Salida");
            botonSalida.setBorder(null);
            botonSalida.setBackground(new Color(27, 70, 69));

            ImageIcon icono = new ImageIcon("src/com/parcar/image/eliminar.png");
            Icon btnEliminar = new ImageIcon(icono.getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT));
            JButton botonEliminar = new JButton("", btnEliminar);
            botonEliminar.setName("btnEliminar");
            botonEliminar.setToolTipText("eliminar");
            botonEliminar.setBorder(null);
            botonEliminar.setBackground(new Color(223, 68, 83));

            if (ingreso.getMonto() == 0.0) {

                modelo.addRow(new Object[]{
                    ingreso.getCodigo(),
                    ingreso.getPlaca(),
                    formato.format(ingreso.getFechaIngreso()),
                    ingreso.getTarifa().getMontohora(),
                    ingreso.getTarifa().getTipoVehiculo().getDescripcion(),
                    botonSalida,
                    botonEliminar
                });

            }

        }

        tblListado.setRowHeight(30);
        tblListado.setModel(modelo);
        tblListado.setBackground(Color.WHITE);
        tblListado.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblListado.getColumnModel().getColumn(0).setPreferredWidth(177);
        tblListado.getColumnModel().getColumn(1).setPreferredWidth(80);
        tblListado.getColumnModel().getColumn(2).setPreferredWidth(150);
        tblListado.getColumnModel().getColumn(3).setPreferredWidth(80);
        tblListado.getColumnModel().getColumn(4).setPreferredWidth(120);
        tblListado.getColumnModel().getColumn(5).setPreferredWidth(30);
        tblListado.getColumnModel().getColumn(6).setPreferredWidth(30);
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
        setTitle("Gestionar Tarifa");
        setPreferredSize(new java.awt.Dimension(705, 457));

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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE)
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

    private void tblListadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListadoMouseClicked

        int fila = tblListado.getSelectedRow();
        String id = tblListado.getValueAt(fila, 0).toString();

        int colum = tblListado.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / tblListado.getRowHeight();

        if (row < tblListado.getRowCount() && row >= 0 && colum < tblListado.getColumnCount() && colum >= 0) {
            Object value = tblListado.getValueAt(row, colum);

            if (value instanceof JButton jButton) {
                jButton.doClick();
                JButton boton = jButton;
                int filas = tblListado.getSelectedRowCount();

                switch (boton.getName()) {
                    case "btnSalida" -> {

                        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm");
                        SimpleDateFormat format2 = new SimpleDateFormat("MM-dd-yyyy HH:mm");

                        try {

                            Date date1 = format.parse(format.format(new Date()));
                            Date date2 = format.parse(tblListado.getValueAt(fila, 2).toString());
                            long elapsedms = date1.getTime() - date2.getTime();
                            long horas = TimeUnit.HOURS.convert(elapsedms, TimeUnit.MILLISECONDS);
                            long dias = TimeUnit.DAYS.convert(elapsedms, TimeUnit.MILLISECONDS);
                            double monto = 0.0;

                            Ingreso ingresoA = (Ingreso) ingresoC.obtenerObjecto(id);

                            if (dias > 0) {
                                monto = ingresoA.getTarifa().getMontoDía() * dias;
                                monto += ingresoA.getTarifa().getMontohora() * (horas + 1);
                            } else {
                                monto += ingresoA.getTarifa().getMontohora() * (horas + 1);
                            }

                            Ingreso ingresoU = new Ingreso(id, monto);

                            try {
                                ingresoC.editar(ingresoU);
                                JOptionPane.showMessageDialog(this, "El monto a pagar es: "+monto+" Soles");
                                AlertaBien alertaBien = new AlertaBien("Mensaje", "Se registro la Salida corerctamente");
                                listar("");

                            } catch (Exception e) {
                            }

                        } catch (ParseException e) {
                        }

                    }
                    case "btnEliminar" -> {
                        if (filas == 0) {//si no elije ninguna fila
                            Alerta alerta = new Alerta("Alerta", "Debe seleccionar una placa");
                        } else {
                            String valor = String.valueOf(tblListado.getValueAt(fila, 1));

                            int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar el Auto con placa " + valor + "?", "Confirmar", 2);
                            if (opcion == 0) {

                                try {
                                    ingresoC.eliminar(id);
                                    AlertaBien alertaBien = new AlertaBien("Mensaje", "Ingreso eliminado correctamente!");
                                    listar("");
                                } catch (Exception ex) {
                                    AlertaError err = new AlertaError("ERROR", ex.getMessage());
                                }

                            } else {
                                Alerta alerta = new Alerta("Alerta", "Operación cancelada!");
                            }

                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_tblListadoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel lblTotal;
    public static javax.swing.JTable tblListado;
    public static org.edisoncor.gui.textField.TextFieldRectBackground txtBuscar;
    // End of variables declaration//GEN-END:variables
}
