/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package NewsAndInformationHUB;

/**
 * This is main class for the News and Information Hub application.
 * It launches the main application frame.
 * 
 * @author arets
 */
public class ClimateAPP {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            // Display the main application frame
            new FrameForPanels().setVisible(true);
        });
    }
}
