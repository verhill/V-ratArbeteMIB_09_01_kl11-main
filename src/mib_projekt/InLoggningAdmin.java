/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mib_projekt;

import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;


/**
 *
 * @author hillv
 */
public class InLoggningAdmin extends javax.swing.JFrame {

    private InfDB idb;

    /**
     * Creates new form InLoggning
     */
    public InLoggningAdmin() {
        initComponents();
        try {
            idb = new InfDB("mibdb", "3306", "mibdba", "mibkey");
            System.out.println("funka");
        } catch (InfException ettUndantag) {
            JOptionPane.showMessageDialog(null, "Något gick fel!");
            System.out.println("Internt felmeddelande" + ettUndantag.getMessage());
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

        lbEpost = new javax.swing.JLabel();
        txtEpost = new javax.swing.JTextField();
        lbLosenord = new javax.swing.JLabel();
        btnLoggaIn = new javax.swing.JButton();
        lbValkommen = new javax.swing.JLabel();
        btnTillbaka2 = new javax.swing.JButton();
        lsnLosenord = new javax.swing.JPasswordField();
        lbEpost1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbEpost.setText("Epost:");

        lbLosenord.setText("Lösenord:");

        btnLoggaIn.setText("Logga In");
        btnLoggaIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoggaInActionPerformed(evt);
            }
        });

        btnTillbaka2.setText("Tillbaka");
        btnTillbaka2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTillbaka2ActionPerformed(evt);
            }
        });

        lsnLosenord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lsnLosenordActionPerformed(evt);
            }
        });

        lbEpost1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbEpost1.setText("Logga in som Admin");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lbLosenord, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnLoggaIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbValkommen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lsnLosenord)
                        .addComponent(txtEpost)
                        .addComponent(lbEpost, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbEpost1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(btnTillbaka2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbEpost1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnTillbaka2)
                    .addComponent(lbEpost))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEpost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbLosenord)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lsnLosenord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(btnLoggaIn)
                .addGap(18, 18, 18)
                .addComponent(lbValkommen, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoggaInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoggaInActionPerformed

            if(Inmatningsvalidering.emailValidering(txtEpost) && Inmatningsvalidering.textValidering(lsnLosenord)){
            try {
                String epost = txtEpost.getText();
                //Hämtar ut lösenordet
                char[] losenorChar = lsnLosenord.getPassword();
                String losenord = new String(losenorChar);

                // Formatera strängarna korrekt i SQL-frågan
                String fraga = "SELECT EPOST, LOSENORD FROM AGENT WHERE EPOST = '" + epost + "' AND LOSENORD = '" + losenord + "'";

                // Utför frågan och hämta resultatet
                String svar = idb.fetchSingle(fraga);
                // Kontrollera om resultatet är tomt eller null
                if (svar != null && !svar.isEmpty()) {
                    // Uppdatera användargränssnittet eller gör något med resultatet
                    EfterInloggAdmin nytt = new EfterInloggAdmin(epost);
                    InLoggningAdmin.this.setVisible(false);
                    nytt.setVisible(true);
                } else {
                    // Uppdatera användargränssnittet eller gör något annat om inloggningen misslyckades
                    lbValkommen.setText("Inloggning misslyckades. Kontrollera e-post och lösenord.");
                }

            } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "Något gick fel!");
                System.out.println("Internt felmeddelande" + e.getMessage());
            }
        
    }
    }//GEN-LAST:event_btnLoggaInActionPerformed

    private void btnTillbaka2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTillbaka2ActionPerformed
        // TODO add your handling code here:
        HuvudMeny nytt = new HuvudMeny();
        InLoggningAdmin.this.setVisible(false);
        nytt.setVisible(true);
    }//GEN-LAST:event_btnTillbaka2ActionPerformed

    private void lsnLosenordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lsnLosenordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lsnLosenordActionPerformed

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
            java.util.logging.Logger.getLogger(InLoggningAgent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InLoggningAgent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InLoggningAgent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InLoggningAgent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new InLoggningAgent().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoggaIn;
    private javax.swing.JButton btnTillbaka2;
    private javax.swing.JLabel lbEpost;
    private javax.swing.JLabel lbEpost1;
    private javax.swing.JLabel lbLosenord;
    private javax.swing.JLabel lbValkommen;
    private javax.swing.JPasswordField lsnLosenord;
    private javax.swing.JTextField txtEpost;
    // End of variables declaration//GEN-END:variables
}