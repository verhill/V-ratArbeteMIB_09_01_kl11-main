/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mib_projekt;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author David
 */
public class Main {

    private static InfDB idb;

    public static void main(String[] args) {
        new Main().startApplication();
    }

    private void startApplication() {
         try {
            idb = new InfDB("mibdb", "3306", "mibdba", "mibkey");
            java.awt.EventQueue.invokeLater(() -> {
                new HuvudMeny(idb).setVisible(true);
                JOptionPane.showMessageDialog(null, "Anslutning Lyckades");
            });
        } catch (InfException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Kunde inte ansluta till databasen. Kontrollera dina uppgifter och försök igen.");
        }
    }
}
    