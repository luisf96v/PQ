/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Panels.Rgs;

import Control.ProyectHandler;
import Model.Entities.Rgs;
import Model.Imp.RgsImp;
import Model.Ticket.InTicket;
import java.awt.Font;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author luisf
 */
public final class RgsList extends javax.swing.JPanel {

    public RgsList() {
        try {
            DB = new RgsImp();
            list = DB.getOutHourNull();
            initComponents();
            setValuesFields();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(RgsList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        d = new javax.swing.JLabel();
        a = new javax.swing.JLabel();
        o = new javax.swing.JLabel();
        m = new javax.swing.JLabel();
        max = new javax.swing.JLabel();
        tot = new javax.swing.JLabel();
        tit7 = new javax.swing.JLabel();
        tit8 = new javax.swing.JLabel();
        tit9 = new javax.swing.JLabel();
        tit10 = new javax.swing.JLabel();
        tit11 = new javax.swing.JLabel();
        tit12 = new javax.swing.JLabel();
        tit13 = new javax.swing.JLabel();
        tit14 = new javax.swing.JLabel();
        tit15 = new javax.swing.JLabel();
        tit18 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        cancel = new javax.swing.JButton();
        mat = new javax.swing.JTextField();
        tp = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ih = new javax.swing.JTextField();
        save = new javax.swing.JButton();
        outRgs = new javax.swing.JButton();
        print = new javax.swing.JButton();
        msg = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setMaximumSize(new java.awt.Dimension(700, 510));
        jPanel2.setMinimumSize(new java.awt.Dimension(700, 510));
        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(700, 510));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(204, 204, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Parqueo Vacío");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153)));
        jLabel1.setOpaque(true);
        jLabel1.setVisible(list.size() == 0);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 570, 40));

        table.setModel(new javax.swing.table.DefaultTableModel(
            createMatrix(),
            new String [] {
                "Entrada", "Tipo de Vehículo", "Matrícula"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        table.setRowHeight(20);
        table.getTableHeader().setResizingAllowed(false);
        table.getTableHeader().setReorderingAllowed(false);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(String.class, centerRenderer);
        table.setFont(new Font("Serif", Font.PLAIN, 14));
        table.getTableHeader().setFont(new Font("Serif", Font.BOLD, 18));

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 570, 450));

        d.setBackground(new java.awt.Color(239, 239, 239));
        d.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        d.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        d.setText("0");
        d.setOpaque(true);
        jPanel1.add(d, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 400, 120, 30));

        a.setBackground(new java.awt.Color(239, 239, 239));
        a.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        a.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a.setText("0");
        a.setOpaque(true);
        jPanel1.add(a, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 340, 120, 30));

        o.setBackground(new java.awt.Color(239, 239, 239));
        o.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        o.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        o.setText("0");
        o.setOpaque(true);
        jPanel1.add(o, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 430, 120, 30));

        m.setBackground(new java.awt.Color(239, 239, 239));
        m.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        m.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        m.setText("0");
        m.setOpaque(true);
        jPanel1.add(m, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 370, 120, 30));

        max.setBackground(new java.awt.Color(56, 0, 224));
        max.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        max.setForeground(new java.awt.Color(255, 255, 255));
        max.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        max.setText("0");
        max.setOpaque(true);
        jPanel1.add(max, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 490, 120, 30));

        tot.setBackground(new java.awt.Color(216, 216, 216));
        tot.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tot.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tot.setText(String.valueOf(list.size())
        );
        tot.setOpaque(true);
        jPanel1.add(tot, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 460, 120, 30));

        tit7.setBackground(new java.awt.Color(51, 0, 204));
        tit7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        tit7.setForeground(new java.awt.Color(255, 255, 255));
        tit7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tit7.setText("Vehiculos");
        tit7.setOpaque(true);
        jPanel1.add(tit7, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 270, 410, 40));

        tit8.setBackground(new java.awt.Color(204, 204, 255));
        tit8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tit8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tit8.setText("Tipo");
        tit8.setOpaque(true);
        jPanel1.add(tit8, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 310, 290, 30));

        tit9.setBackground(new java.awt.Color(217, 217, 255));
        tit9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tit9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tit9.setText("Cantidad");
        tit9.setOpaque(true);
        jPanel1.add(tit9, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 310, 120, 30));

        tit10.setBackground(new java.awt.Color(234, 234, 234));
        tit10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tit10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tit10.setText("Automóvil");
        tit10.setOpaque(true);
        jPanel1.add(tit10, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 340, 290, 30));

        tit11.setBackground(new java.awt.Color(234, 234, 234));
        tit11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tit11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tit11.setText("Motocicleta");
        tit11.setOpaque(true);
        jPanel1.add(tit11, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 370, 290, 30));

        tit12.setBackground(new java.awt.Color(234, 234, 234));
        tit12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tit12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tit12.setText("Discapacitado");
        tit12.setOpaque(true);
        jPanel1.add(tit12, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 400, 290, 30));

        tit13.setBackground(new java.awt.Color(204, 204, 204));
        tit13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tit13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tit13.setText("Total");
        tit13.setOpaque(true);
        jPanel1.add(tit13, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 460, 290, 30));

        tit14.setBackground(new java.awt.Color(234, 234, 234));
        tit14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tit14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tit14.setText("Otro");
        tit14.setOpaque(true);
        jPanel1.add(tit14, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 430, 290, 30));

        tit15.setBackground(new java.awt.Color(51, 0, 204));
        tit15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tit15.setForeground(new java.awt.Color(255, 255, 255));
        tit15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tit15.setText("Campos Máximos");
        tit15.setOpaque(true);
        jPanel1.add(tit15, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 490, 290, 30));

        tit18.setBackground(new java.awt.Color(51, 0, 204));
        tit18.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        tit18.setForeground(new java.awt.Color(255, 255, 255));
        tit18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tit18.setText("Datos de Vehículos");
        tit18.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tit18.setOpaque(true);
        jPanel1.add(tit18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 570, 50));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Vehículo Seleccionado", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 18))); // NOI18N
        jPanel3.setOpaque(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cancel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/error.png"))); // NOI18N
        cancel.setEnabled(false);
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        jPanel3.add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, 30, 30));

        mat.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        mat.setEnabled(false);
        jPanel3.add(mat, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 150, 30));

        tp.setEditable(false);
        tp.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel3.add(tp, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 150, 30));

        jLabel4.setBackground(new java.awt.Color(204, 204, 204));
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Matrícula");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 70, 30));

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Entrada");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 70, 30));

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Tipo");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 70, 30));

        ih.setEditable(false);
        ih.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel3.add(ih, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 150, 30));

        save.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/save-icon.png"))); // NOI18N
        save.setEnabled(false);
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        jPanel3.add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, 30, 30));

        outRgs.setBackground(new java.awt.Color(204, 204, 255));
        outRgs.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        outRgs.setText("Registra Salida");
        outRgs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outRgsActionPerformed(evt);
            }
        });
        jPanel3.add(outRgs, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 280, 40));

        print.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/printer-.png"))); // NOI18N
        print.setEnabled(false);
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });
        jPanel3.add(print, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, 30, 30));

        msg.setBackground(new java.awt.Color(204, 204, 204));
        msg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        msg.setOpaque(true);
        jPanel3.add(msg, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 280, 20));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, 410, 250));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 530));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1120, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1090, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 576, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        try {
            if (table.getValueAt(table.getSelectedRow(), 0) != null) {
                rgs = DB.findRGS((String) table.getValueAt(table.getSelectedRow(), 2));
                updateInfo();
                mat.setEnabled(true);
                save.setEnabled(true);
                print.setEnabled(true);
                cancel.setEnabled(true);
            }
        } catch (ArrayIndexOutOfBoundsException | SQLException ex) {
            Logger.getLogger(RgsList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tableMouseClicked

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        if (rgs != null) {
            int result = JOptionPane.showConfirmDialog(
                    null,
                    "¿Desea Eliminar? El registro será insertado en otra tabla por motivos de control.",
                    "Confirmación de eliminación.",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.INFORMATION_MESSAGE
            );
            if (result == JOptionPane.YES_OPTION) {
                try {
                    new RgsImp().deleteRGS(this.rgs);
                    ProyectHandler.window().panelList();
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(RgsList.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_cancelActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        if (rgs != null) {
            int result = JOptionPane.showConfirmDialog(
                    null,
                    "Por favor mantenga el formáto, de lo contrario estaría guardando datos erróneos. ¿Desea guardar?",
                    "Confirmación de cambio",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.INFORMATION_MESSAGE
            );
            if (result == JOptionPane.YES_OPTION) {
                try {
                    rgs.setMatricula(this.mat.getText());
                    new RgsImp().updateRGS(rgs);
                    this.msg.setVisible(true);
                    this.msg.setText("Matrícula guardada exitosamente.");
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(RgsList.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                mat.setText(rgs.getMatricula());
            }
        }
    }//GEN-LAST:event_saveActionPerformed

    private void outRgsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outRgsActionPerformed
        ProyectHandler.window().setPanel(new RgsOut(this.rgs), "Salida de Vahículo");
    }//GEN-LAST:event_outRgsActionPerformed

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        if (rgs != null) {
            new InTicket(
                    rgs.getMatricula(),
                    rgs.getIn().toString("HH:mm")
            ).print();

        } else {
            JOptionPane.showMessageDialog(null, "No se puede imprimir.", "Unexpected error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_printActionPerformed

    private void setValuesFields() throws SQLException {
        a.setText(String.valueOf(_a));
        m.setText(String.valueOf(_m));
        d.setText(String.valueOf(_d));
        o.setText(String.valueOf(_o));
        List<String> findValues = DB.findValues("CAMPOS");
        int i = Integer.valueOf(findValues.get(0));
        i += Integer.valueOf(findValues.get(1));
        i += Integer.valueOf(findValues.get(2));
        max.setText(String.valueOf(i));
    }

    private void filtrate(String type) {
        switch (type) {
            case "Automóvil Act":
            case "Automóvil": {
                _a++;
                _go++;
                break;
            }
            case "Motocicleta": {
                _m++;
                _po++;
                break;
            }
            case "Discapacitado": {
                _d++;
                _go++;
                break;
            }
            case "Otro": {
                _o++;
                _go++;
                break;
            }
        }
    }

    private Object[][] createMatrix() {
        if (list.isEmpty()) {
            return new Object[0][0];
        }
        Object[][] mat = new Object[list.size()][3];
        Iterator<Rgs> itr = list.iterator();
        int row = 0;
        while (itr.hasNext()) {
            Rgs aux = itr.next();
            mat[row][0] = aux.getIn().toString("dd / MM   HH : mm");
            mat[row][1] = aux.getType();
            mat[row++][2] = aux.getMatricula();
            filtrate(aux.getType());
        }
        return mat;
    }

    private void updateInfo() {
        mat.setText(rgs.getMatricula());
        ih.setText(rgs.getIn().toString("HH : mm"));
        tp.setText(rgs.getType());
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel a;
    private javax.swing.JButton cancel;
    private javax.swing.JLabel d;
    private javax.swing.JTextField ih;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel m;
    private javax.swing.JTextField mat;
    private javax.swing.JLabel max;
    private javax.swing.JLabel msg;
    private javax.swing.JLabel o;
    private javax.swing.JButton outRgs;
    private javax.swing.JButton print;
    private javax.swing.JButton save;
    private javax.swing.JTable table;
    private javax.swing.JLabel tit10;
    private javax.swing.JLabel tit11;
    private javax.swing.JLabel tit12;
    private javax.swing.JLabel tit13;
    private javax.swing.JLabel tit14;
    private javax.swing.JLabel tit15;
    private javax.swing.JLabel tit18;
    private javax.swing.JLabel tit7;
    private javax.swing.JLabel tit8;
    private javax.swing.JLabel tit9;
    private javax.swing.JLabel tot;
    private javax.swing.JTextField tp;
    // End of variables declaration//GEN-END:variables
    int _a, _m, _d, _o;
    int _po, _go;

    RgsImp DB;
    List<Rgs> list;
    Rgs rgs;
}
