/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mib_projekt;

import java.util.HashMap;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author David
 */
public class TaBortAgent extends javax.swing.JFrame {
    private InfDB idb;
    /**
     */
    public TaBortAgent(InfDB idb) {
        this.idb = idb;
        initComponents();
        AgentNamnScroll();
        AgentNamnScroll2();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnTaBortAgent = new javax.swing.JButton();
        cbtnAgentNamn = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        lblTaBortAlienSystem = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbtnAgentNamn1 = new javax.swing.JComboBox<>();
        btnTillbaka2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnTaBortAgent.setText("Ta bort Agent");
        btnTaBortAgent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaBortAgentActionPerformed(evt);
            }
        });

        jLabel1.setText("Välj Agent nedan:");

        lblTaBortAlienSystem.setText("Ta bort Agent ur Systemet ");

        jLabel2.setText("Vänligen välj ny ansvarig agent:");

        btnTillbaka2.setText("Tillbaka");
        btnTillbaka2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTillbaka2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTaBortAgent)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbtnAgentNamn, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbtnAgentNamn1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTaBortAlienSystem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTillbaka2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTaBortAlienSystem)
                    .addComponent(btnTillbaka2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbtnAgentNamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbtnAgentNamn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnTaBortAgent)
                .addGap(120, 120, 120))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

       private void AgentNamnScroll(){
        try {
            // SQL-fråga för att hämta Plats_ID och Benamning från plats-tabellen
            String fraga = "SELECT Agent_ID, Namn FROM agent;";
            // Utför SQL-frågan och få resultatet
            var resultat = idb.fetchRows(fraga);

            // Iterera över varje rad i resultatet
            for (HashMap<String, String> rad : resultat) {
                // Hämta Plats_ID och Benamning från raden
                String AgentIdStr = rad.get("Agent_ID");
                String AgentNamn = rad.get("Namn");

                // Kontrollera om Plats_ID är inte null
                if (AgentIdStr != null) {
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
      private void AgentNamnScroll2(){
        try {
            // SQL-fråga för att hämta Plats_ID och Benamning från plats-tabellen
            String fraga = "SELECT Agent_ID, Namn FROM agent;";
            // Utför SQL-frågan och få resultatet
            var resultat = idb.fetchRows(fraga);

            // Iterera över varje rad i resultatet
            for (HashMap<String, String> rad : resultat) {
                // Hämta Plats_ID och Benamning från raden
                String AgentIdStr = rad.get("Agent_ID");
                String AgentNamn = rad.get("Namn");

                // Kontrollera om Plats_ID är inte null
                if (AgentIdStr != null) {
                    // Lägg till Benamning i dropdown-menyn
                    cbtnAgentNamn1.addItem(AgentNamn);
                }
            }
        } catch (InfException ex) {
            // Visa felmeddelande om något går fel med databasen
            JOptionPane.showMessageDialog(null, "Något gick fel!");
            System.out.println("Internt felmeddelande" + ex.getMessage());
        }
    }
    private void btnTaBortAgentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaBortAgentActionPerformed
    String valtAgentNamn = (String) cbtnAgentNamn.getSelectedItem();
    String valtAgentNamn2 = (String) cbtnAgentNamn1.getSelectedItem();
        try {
            String fraga = "SELECT Agent_ID FROM Agent WHERE Namn = '" + valtAgentNamn + "'";
            String fraga2 = "SELECT Agent_ID FROM Agent WHERE Namn = '" + valtAgentNamn2 + "'";

            var agentID = idb.fetchSingle(fraga);
            var agentID2 = idb.fetchSingle(fraga2);
            
            String fragaOmradesChef = "SELECT benamning FROM omrade JOIN omradeschef ON omrades_id = omrade WHERE Agent_ID = " + agentID;
            String svarOmradesChef = idb.fetchSingle(fragaOmradesChef);
            
            String fragaKontorsChef = "SELECT Agent_ID from kontorschef WHERE Agent_ID = " + agentID;
            String svarKontorschef = idb.fetchSingle(fragaKontorsChef);
            if(svarOmradesChef != null){
                JOptionPane.showMessageDialog(null, "Agenten är omradeschef för: " + svarOmradesChef+ " vänligen välj ny chef för: " +svarOmradesChef);
                   AndraOmradesChef nytt = new AndraOmradesChef();
                   TaBortAgent.this.setVisible(false);
                   nytt.setVisible(true);
            }
            else if(svarKontorschef != null){
                 JOptionPane.showMessageDialog(null, "Agenten är kontorschef! Vänligen utse en ny kontorschef");
                   AndraKontorsChef nytt = new AndraKontorsChef();
                   TaBortAgent.this.setVisible(false);
                   nytt.setVisible(true);
            }
            else {
                
                idb.update("UPDATE Alien SET Ansvarig_Agent = " + agentID2 + " WHERE Ansvarig_Agent = " + agentID);
                
                idb.delete("DELETE FROM Omradeschef WHERE Agent_ID = " +  agentID);
                idb.delete("DELETE FROM Kontorschef WHERE Agent_ID = " +  agentID);
                idb.delete("DELETE FROM Innehar_Utrustning WHERE Agent_ID = " +  agentID);
                idb.delete("DELETE FROM Alien WHERE Ansvarig_Agent = " +  agentID);
                idb.delete("DELETE FROM Faltagent WHERE Agent_ID = " +  agentID);
                idb.delete("DELETE FROM Agent WHERE Agent_ID = " +  agentID);
               
                JOptionPane.showMessageDialog(null, valtAgentNamn + " har tagits bort");
            
            }
    } catch (InfException e) {
        JOptionPane.showMessageDialog(null, "Vänligen välj en ny ansvarig agent för Alien innan du tar bort Agenten");
        System.out.println("Internt felmeddelande: " + e.getMessage());
    }
    }//GEN-LAST:event_btnTaBortAgentActionPerformed

    private void btnTillbaka2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTillbaka2ActionPerformed
        // TODO add your handling code here:
        EfterInloggAdmin nytt = new EfterInloggAdmin();
        TaBortAgent.this.setVisible(false);
        nytt.setVisible(true);
    }//GEN-LAST:event_btnTillbaka2ActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TaBortAgent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

try{
            InfDB idb = new InfDB("mibdb", "3306", "mibdba", "mibkey");
            TaBortAgent TaBortAgentFrame = new TaBortAgent(idb); 
            
        
            TaBortAgentFrame.setSize(551, 301);
            TaBortAgentFrame.setVisible(true);
        } catch (InfException Fel) {
            JOptionPane.showMessageDialog(null, "Något gick fel!");
            System.out.println("Internt felmeddelande: " + Fel.getMessage());
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTaBortAgent;
    private javax.swing.JButton btnTillbaka2;
    private javax.swing.JComboBox<String> cbtnAgentNamn;
    private javax.swing.JComboBox<String> cbtnAgentNamn1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblTaBortAlienSystem;
    // End of variables declaration//GEN-END:variables
}
