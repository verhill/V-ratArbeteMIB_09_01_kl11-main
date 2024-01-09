/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mib_projekt;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author David
 */
public class Main {

    private static InfDB idb;

    public static void main(String[] args) {
          try {
            idb = new InfDB("mibdb", "3306", "mibdba", "mibkey");
            
            // Skapa och visa JFrame-fönstret
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    HuvudMeny firstWindow = new HuvudMeny(); // Skapa en instans av din JFrame-klass
                    firstWindow.setVisible(true); // Gör fönstret synligt
                }
            });
        } catch (InfException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }


    