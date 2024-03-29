/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mib_projekt;

import java.util.HashMap;
import oru.inf.InfDB;
import oru.inf.InfException;

import javax.swing.JOptionPane;

/**
 *
 * @author David
 */
public class AndraKontorsChef extends javax.swing.JFrame {

    private InfDB idb;
    private int valtAgentID;

    /**
     * Creates new form AndraKontorsChef
     */
    public AndraKontorsChef() {
        initComponents();
        try {
            idb = new InfDB("mibdb", "3306", "mibdba", "mibkey");
            System.out.println("funka");
            fyllCbtnAgentNamn();
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

        jlAndraKontorschef = new javax.swing.JLabel();
        jlSkrivIAgentID = new javax.swing.JLabel();
        jbBekraftaAndring = new javax.swing.JButton();
        btnTillbaka3 = new javax.swing.JButton();
        cbtnAgentNamn = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jlAndraKontorschef.setText("Ändra kontorschef");

        jlSkrivIAgentID.setText("Agent som tillträder som ny kontorschef:");

        jbBekraftaAndring.setText("Bekräfta ändring");
        jbBekraftaAndring.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBekraftaAndringActionPerformed(evt);
            }
        });

        btnTillbaka3.setText("Tillbaka");
        btnTillbaka3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTillbaka3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlAndraKontorschef)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
                        .addComponent(btnTillbaka3))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbtnAgentNamn, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlSkrivIAgentID)
                            .addComponent(jbBekraftaAndring))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jlAndraKontorschef, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnTillbaka3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlSkrivIAgentID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbtnAgentNamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jbBekraftaAndring)
                .addContainerGap(157, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbBekraftaAndringActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBekraftaAndringActionPerformed

        String valtAgentNamn = (String) cbtnAgentNamn.getSelectedItem();
        //Klicka på knapp bekfräta ändring
        try {
            
            String fraga = "SELECT Agent_ID FROM Agent WHERE Namn = '" + valtAgentNamn + "'";
            // Utför SQL-frågan och få resultatet
            var resultat = idb.fetchSingle(fraga);

            if (resultat != null) {
                // Konvertera resultatet till integer och lagra det i valtAlienID
                valtAgentID = Integer.parseInt(resultat);
            }

            //Kolla om Agent redan är kontorschef
            String existerandeChef = idb.fetchSingle(
                    "SELECT agent_ID FROM kontorschef WHERE agent_ID =" + valtAgentID);

            if (existerandeChef != null) {
                JOptionPane.showMessageDialog(null, "Agenten du valt är den nuvarande kontorschefen");

            }else{
            String agentNamn = idb.fetchSingle("SELECT Namn FROM agent WHERE agent_ID = " + valtAgentID);
            idb.update("UPDATE kontorschef SET agent_ID =" + valtAgentID);
            System.out.println("Kontorschefen är nu ändrad till " + agentNamn);
            JOptionPane.showMessageDialog(null, "Ny kontorschef registrerad: " + agentNamn);
            }

        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Något gick fel!");
            System.out.println("Internt felmeddelande" + e.getMessage());
        }

    }//GEN-LAST:event_jbBekraftaAndringActionPerformed

    private void btnTillbaka3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTillbaka3ActionPerformed
        // TODO add your handling code here:
        EfterInloggAdmin nytt = new EfterInloggAdmin();
        AndraKontorsChef.this.setVisible(false);
        nytt.setVisible(true);
    }//GEN-LAST:event_btnTillbaka3ActionPerformed

    private void fyllCbtnAgentNamn() {
        try {
            // SQL-fråga för att hämta Plats_ID och Benamning från plats-tabellen
            String fraga = "SELECT Agent_ID, Namn FROM Agent;";
            // Utför SQL-frågan och få resultatet
            var resultat = idb.fetchRows(fraga);

            // Iterera över varje rad i resultatet
            for (HashMap<String, String> rad : resultat) {
                // Hämta Plats_ID och Benamning från raden
                String AgentIdStr = rad.get("Agent_ID");
                String AgentNamn = rad.get("Namn");

                // Kontrollera om Plats_ID är inte null
                if (AgentIdStr != null) {
                    // Konvertera Plats_ID till integer
                    // Lägg till Benamning i dropdown-menyn
                    cbtnAgentNamn.addItem(AgentNamn);
                }
            }
        } catch (InfException ex) {
            // Visa felmeddelande om något går fel med databasen
            JOptionPane.showMessageDialog(null, "Något gick fel!");
            System.out.println("Internt felmeddelande" + ex.getMessage());
        }
    }

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
            java.util.logging.Logger.getLogger(AndraKontorsChef.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AndraKontorsChef.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AndraKontorsChef.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AndraKontorsChef.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AndraKontorsChef().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTillbaka3;
    private javax.swing.JComboBox<String> cbtnAgentNamn;
    private javax.swing.JButton jbBekraftaAndring;
    private javax.swing.JLabel jlAndraKontorschef;
    private javax.swing.JLabel jlSkrivIAgentID;
    // End of variables declaration//GEN-END:variables
}
