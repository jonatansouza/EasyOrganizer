/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EasyOrganizer.model;

import EasyOrganizer.UI.List;
import EasyOrganizer.UI.Menu;
import EasyOrganizer.UI.Register;
import static EasyOrganizer.model.Main.main;
import java.awt.CardLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author jonatan
 */

public class Main {
private Menu menuPanel;
private Register registerPanel;
private List listPanel;
  private void displayGUI(){
        JFrame frame = new JFrame("Easy Organizer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setBorder(
            BorderFactory.createEmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new CardLayout());
        menuPanel = new Menu(contentPane);
        registerPanel = new Register(contentPane);
        listPanel = new List(contentPane);
        contentPane.add(menuPanel, "menu"); 
        contentPane.add(registerPanel, "register");
        contentPane.add(listPanel, "list");
        frame.setContentPane(contentPane);
        frame.pack();   
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
 public static void main(String... args) {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new Main().displayGUI();
            }
        });
    }
      
}