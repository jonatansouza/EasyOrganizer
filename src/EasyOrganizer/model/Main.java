/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package EasyOrganizer.model;

import EasyOrganizer.UI.Menu;
import EasyOrganizer.UI.Register;
import EasyOrganizer.UI.Tarefas;
import EasyOrganizer.controller.EasyOrganizerController;
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
    private Tarefas tarefas;
    private EasyOrganizerController eomController;
    
    private void displayGUI(){
        
        eomController = new EasyOrganizerController();
        
        JFrame frame = new JFrame("Easy Organizer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(
         BorderFactory.createEmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new CardLayout());
        menuPanel = new Menu(contentPane, eomController);
        registerPanel = new Register(contentPane, eomController);
        tarefas = new Tarefas(contentPane, eomController);
        contentPane.add(menuPanel, "menu");
        contentPane.add(registerPanel, "register");
        contentPane.add(tarefas, "tarefas");
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
