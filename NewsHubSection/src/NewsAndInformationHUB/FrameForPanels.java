/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package NewsAndInformationHUB;

import static java.awt.Component.CENTER_ALIGNMENT;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.BorderFactory;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.SwingUtilities;

/**
 * Andrei Re.
 */
public class FrameForPanels extends javax.swing.JFrame {
    private QuizzGUI quizGUI;
    private NewsFeedGUI newsFeedGUI;
    private DonationGUI donationGUI;
    private MainPageImage mainPageImage;

    public FrameForPanels() {
        // Initialize the main components and layout
        FrameForPanels parentFrame = (FrameForPanels) SwingUtilities.getWindowAncestor(this);
        initComponents();
        
        
        
        // Initialize frames for each section
        quizGUI = new QuizzGUI();
        newsFeedGUI = new NewsFeedGUI();
        donationGUI = new DonationGUI();

        // Add frames to the desktop panel, setting them invisible initially
        desktopPanel.add(quizGUI);
        desktopPanel.add(newsFeedGUI);
        desktopPanel.add(donationGUI);

        MainPageImage mainPageImage = new MainPageImage();
        desktopPanel.add(mainPageImage);
        mainPageImage.setVisible(true);
    }

    void hideAllFramesExcept(JInternalFrame frameToShow) {
        quizGUI.setVisible(false);
        newsFeedGUI.setVisible(false);
        donationGUI.setVisible(false);

        frameToShow.setVisible(true);
        try {
            frameToShow.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
            System.out.println(e);
        }
    }

    private void initComponents() {
        desktopPanel = new javax.swing.JDesktopPane();
        quizBtn = createButton("Quiz");
        newsFeedBtn = createButton("News Feed");
        donationBtn = createButton("Donation");
        exitBtn = createButton("Exit");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        desktopPanel.setLayout(null); // Free-form layout for desktop panel

        // Set button actions to open respective frames
        newsFeedBtn.addActionListener(evt -> hideAllFramesExcept(newsFeedGUI));
        donationBtn.addActionListener(evt -> hideAllFramesExcept(donationGUI));
        quizBtn.addActionListener(evt -> hideAllFramesExcept(quizGUI));
        exitBtn.addActionListener(evt -> System.exit(0));

        // Create a vertical panel 
        javax.swing.JPanel buttonPanel = new javax.swing.JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        // Add some padding around the buttons and center them
        buttonPanel.add(Box.createVerticalStrut(10));  // Add gap bettwen the buttons 10 px
        buttonPanel.add(newsFeedBtn);
        buttonPanel.add(Box.createVerticalStrut(10));  
        buttonPanel.add(donationBtn);
        buttonPanel.add(Box.createVerticalStrut(10));  
        buttonPanel.add(quizBtn);
        
        // Spacer to push the Exit button to the bottom
        buttonPanel.add(Box.createVerticalGlue());
        buttonPanel.add(Box.createVerticalStrut(10)); // extra padding for Exit button
        buttonPanel.add(exitBtn);

        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Padding around button panel

        // Layout for main frame, adding buttons on the left and desktop panel in the center
        setLayout(new java.awt.BorderLayout());
        add(buttonPanel, java.awt.BorderLayout.WEST); // Place buttons on the left side
        add(desktopPanel, java.awt.BorderLayout.CENTER); // Main content on the right side

        setSize(1020, 600); // Set the window size
        setLocationRelativeTo(null); // Center the window
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setMaximumSize(new Dimension(150, 40)); // Set button size
        button.setAlignmentX(CENTER_ALIGNMENT); // Center align each button
        button.setFont(new Font("Arial", Font.PLAIN, 14)); // Font settings
        return button;
    }

    public JInternalFrame getMainPageImage() {
    return mainPageImage;
    }
    
    
    // Declare components
    private javax.swing.JDesktopPane desktopPanel;
    private javax.swing.JButton newsFeedBtn;
    private javax.swing.JButton donationBtn;
    private javax.swing.JButton quizBtn;
    private javax.swing.JButton exitBtn;

}