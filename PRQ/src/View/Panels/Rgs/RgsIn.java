/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Panels.Rgs;

import Control.ProyectHandler;
import Model.Imp.RgsImp;
import Model.Ticket.InTicket;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import org.joda.time.DateTime;

/**
 *
 * @author luisf
 */
public final class RgsIn extends javax.swing.JPanel {

    public RgsIn(int type) {
        this.type = type;
        initComponents();
        errMsg.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jL1 = new javax.swing.JLabel();
        jL2 = new javax.swing.JLabel();
        comboTypes = new javax.swing.JComboBox<>();
        matricula = new javax.swing.JFormattedTextField();
        register = new javax.swing.JButton();
        errMsg = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setToolTipText("");
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jL1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jL1.setText("Placa");
        jPanel1.add(jL1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 106, 33));

        jL2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jL2.setText("Tipo de Vehiculo");
        jPanel1.add(jL2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 106, 33));

        comboTypes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Automóvil Act", "Automóvil", "Motocicleta", "Discapacitado", "Otro" }));
        comboTypes.setSelectedIndex(this.type);
        comboTypes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        comboTypes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTypesActionPerformed(evt);
            }
        });
        jPanel1.add(comboTypes, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 220, 30));

        try {
            matricula.setFormatterFactory(this.setFormatter());
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        matricula.setToolTipText("");
        jPanel1.add(matricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 220, 30));

        register.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        register.setText("Registrar Vehículo");
        register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RgsIn.this.actionPerformed(evt);
            }
        });
        jPanel1.add(register, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 360, 40));

        errMsg.setBackground(new java.awt.Color(204, 204, 204));
        errMsg.setForeground(new java.awt.Color(255, 0, 0));
        errMsg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errMsg.setText("Error: Ya se ingreso dicha matrícula");
        errMsg.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        errMsg.setOpaque(true);
        jPanel1.add(errMsg, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 360, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 603, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 407, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void actionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actionPerformed
        if (matricula.getText().charAt(0) != ' ') {
            try {
                RgsImp db = new RgsImp();

                DateTime dt = db.inRgs(
                        this.matricula.getText().replace(this.formatReplace(), ""),
                        getType()
                );

                if (dt != null) {
                    new InTicket(
                            this.matricula.getText().replace(this.formatReplace(), ""),
                            dt.toString("HH:mm")
                    ).print();

                    ProyectHandler.window().panelList();
                } else {
                    this.errMsg.setText("Error: Ya se ingreso dicha matrícula.");
                    this.errMsg.setVisible(true);
                }
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(RgsIn.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            this.errMsg.setText("Error: Matrícula no cumple con el formato.");
            this.errMsg.setVisible(true);
        }
    }//GEN-LAST:event_actionPerformed

    private void comboTypesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTypesActionPerformed
        ProyectHandler.window().panelIn(this.comboTypes.getSelectedIndex());
    }//GEN-LAST:event_comboTypesActionPerformed

    private int getType() {
        switch (this.comboTypes.getSelectedItem().toString()) {
            case "Automóvil":
            case "Automóvil Act":
                return 1;
            case "Motocicleta":
                return 2;
            case "Discapacitado":
                return 3;
            case "Otro":
                return 4;
            default:
                return 0;
        }
    }

    private DefaultFormatterFactory setFormatter() throws ParseException {
        switch (this.type) {
            case 0: {
                return new DefaultFormatterFactory(new MaskFormatter("UUU-###"));
            }
            case 1: {
                return new DefaultFormatterFactory(new MaskFormatter("###-###"));
            }
            case 2: {
                return new DefaultFormatterFactory(new MaskFormatter("###-###"));
            }
            case 3: {
                return new DefaultFormatterFactory(new MaskFormatter("####"));
            }
            case 4: {
                return new DefaultFormatterFactory(new MaskFormatter("**********"));
            }
        }
        return null;
    }

    private String formatReplace() {
        switch (this.type) {
            case 0:
            case 1:
            case 2:
                return "-";
            case 3:
            case 4:
            default:
                return "";
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboTypes;
    private javax.swing.JLabel errMsg;
    private javax.swing.JLabel jL1;
    private javax.swing.JLabel jL2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JFormattedTextField matricula;
    private javax.swing.JButton register;
    // End of variables declaration//GEN-END:variables
    private final int type;

}
