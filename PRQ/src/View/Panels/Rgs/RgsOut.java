/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Panels.Rgs;

import Control.ProyectHandler;
import Model.Entities.Rgs;
import Model.Imp.RgsImp;
import Model.Ticket.OutTicket;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.joda.time.DateTime;
import org.joda.time.Period;

/**
 *
 * @author luisf
 */
public class RgsOut extends javax.swing.JPanel {

    /**
     * Creates new form RgsOut
     *
     * @param rgs
     */
    public RgsOut(Rgs rgs) {
        this.rgs = rgs;
        out = new DateTime();
        this.valHours = 800;//base de datos
        this.valMinutes = 400;//base de datos
        period = new Period(rgs.getIn(), out);
        this.initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        IH = new javax.swing.JTextField();
        save = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pays = new javax.swing.JSpinner();
        Efectivo = new javax.swing.JRadioButton();
        Tarjeta = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        tiempo = new javax.swing.JFormattedTextField();
        OH = new javax.swing.JTextField();
        this.getTotal();
        total = new javax.swing.JSpinner();
        change = new javax.swing.JFormattedTextField();
        atras = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Entrada");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 80, 30));

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Vuelto");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 400, 80, 30));

        IH.setEditable(false);
        IH.setBackground(new java.awt.Color(255, 255, 255));
        IH.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        IH.setText(this.rgs.getIn().toString("HH:mm"));
        jPanel3.add(IH, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 170, 30));

        save.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        save.setText("Guardar");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        jPanel3.add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 460, 270, 30));
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 320, 10));

        jLabel5.setBackground(new java.awt.Color(204, 204, 204));
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Tiempo");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 80, 30));

        jLabel6.setBackground(new java.awt.Color(204, 204, 204));
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Total");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 80, 30));

        jLabel4.setBackground(new java.awt.Color(204, 204, 204));
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Paga Con");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, 80, 30));

        pays.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pays.setModel(new javax.swing.SpinnerNumberModel(ttl,ttl,null,25));
        pays.setValue(ttl);
        pays.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                paysStateChanged(evt);
            }
        });
        jPanel3.add(pays, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 340, 170, 30));

        Efectivo.setSelected(true);
        Efectivo.setText("Efectivo");
        Efectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EfectivoActionPerformed(evt);
            }
        });
        jPanel3.add(Efectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, 140, 30));

        Tarjeta.setText("Tarjeta");
        Tarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TarjetaActionPerformed(evt);
            }
        });
        jPanel3.add(Tarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 140, 30));

        jLabel7.setBackground(new java.awt.Color(204, 204, 204));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Salida");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 80, 30));

        tiempo.setEditable(false);
        tiempo.setBackground(new java.awt.Color(255, 255, 255));
        tiempo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tiempo.setText(new StringBuilder("Horas: ")
            .append(period.getHours())
            .append(", Minutos: ")
            .append(period.getMinutes())
            .toString()
        );
        jPanel3.add(tiempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 170, 30));

        OH.setEditable(false);
        OH.setBackground(new java.awt.Color(255, 255, 255));
        OH.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        OH.setText(this.out.toString("HH:mm"));
        jPanel3.add(OH, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 170, 30));

        total.setModel(new javax.swing.SpinnerNumberModel(ttl, 0, ttl, 25));
        total.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                totalStateChanged(evt);
            }
        });
        jPanel3.add(total, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 170, 30));

        change.setEditable(false);
        change.setBackground(new java.awt.Color(255, 255, 255));
        change.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        change.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        change.setValue(0
        );
        jPanel3.add(change, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 400, 170, 30));

        atras.setText("Atras");
        atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(602, Short.MAX_VALUE)
                .addComponent(atras)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(atras)
                .addContainerGap(579, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasActionPerformed
        ProyectHandler.window().panelList();
    }//GEN-LAST:event_atrasActionPerformed

    private void paysStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_paysStateChanged
        change.setValue((int) pays.getValue() - ttl);
        revalidate();
    }//GEN-LAST:event_paysStateChanged

    private void totalStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_totalStateChanged
        ttl = (int) total.getValue();
        if (Efectivo.isSelected()) {
            pays.setModel(new javax.swing.SpinnerNumberModel(ttl, ttl, null, 25));
        } else {
            pays.setModel(new javax.swing.SpinnerNumberModel(ttl, ttl, ttl, 0));
        }

        change.setValue((int) pays.getValue() - ttl);

    }//GEN-LAST:event_totalStateChanged

    private void EfectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EfectivoActionPerformed
        Tarjeta.setSelected(false);
        pays.setModel(new javax.swing.SpinnerNumberModel(ttl, ttl, null, 25));
    }//GEN-LAST:event_EfectivoActionPerformed

    private void TarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TarjetaActionPerformed
        Efectivo.setSelected(false);
        pays.setModel(new javax.swing.SpinnerNumberModel(ttl, ttl, ttl, 0));
        change.setValue(0);
    }//GEN-LAST:event_TarjetaActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        try {
            RgsImp db = new RgsImp();
            String bh = db.billHeader();
            db.outRgs(rgs.getMatricula(), out, ttl, bh.replace(" - ", ""));

            String per = new StringBuilder()
                    .append(period.getHours())
                    .append(" h ")
                    .append(period.getMinutes())
                    .append(" m")
                    .toString();

            new OutTicket(
                    bh.replace(" ", ""),
                    rgs.getIn().toString("HH:mm"),
                    out.toString("HH:mm"),
                    per,
                    ttl
            ).print();
            
            ProyectHandler.window().panelList();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(RgsOut.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_saveActionPerformed

    private void getTotal() {
        int day = period.getDays();
        int hrs = period.getHours();
        int min = period.getMinutes();

        if(rgs.getType().equals("Motocicleta")){
            valHours = 400;
            valMinutes = 200;
        }
        
        ttl = 0;
        ttl += day * 24 * valHours;
        ttl += hrs * valHours;
        ttl += (ttl == 0) ? valHours : ((valMinutes > 30) ? valHours : valMinutes);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Efectivo;
    private javax.swing.JTextField IH;
    private javax.swing.JTextField OH;
    private javax.swing.JRadioButton Tarjeta;
    private javax.swing.JButton atras;
    private javax.swing.JFormattedTextField change;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSpinner pays;
    private javax.swing.JButton save;
    private javax.swing.JFormattedTextField tiempo;
    private javax.swing.JSpinner total;
    // End of variables declaration//GEN-END:variables
    private final Rgs rgs;
    private final DateTime out;
    private final Period period;
    private int ttl;
    private int ttl2;
    private int valHours;
    private int valMinutes;
}
