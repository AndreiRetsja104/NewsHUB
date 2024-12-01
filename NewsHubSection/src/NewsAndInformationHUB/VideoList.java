/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NewsAndInformationHUB;

/**
 *
 * @author arets
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
import java.util.List;

/**
 * The VideoList class displays a list of videos from a NewsFeed.
 * Each video is displayed as a clickable link that opens the video URL in a browser.
 * @author arets
 */
public class VideoList extends javax.swing.JFrame {

    /*
     * Constructor to initialize the VideoList GUI.
     * Fetches videos, renders them in a list, and makes each item clickable.
     * Creates new form ShortVideoListGUI
     */
     public VideoList() {
        setTitle("Videos"); // Set the window title
        setSize(400, 300); // Set the window size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Exit the application on close

        // Fetch the latest videos
        NewsFeed newsFeed = new NewsFeed();
        List<Video> video = newsFeed.getLatestVideos();

        // Create a JList to display videos
        JList<Video> list = new JList<>(video.toArray(new Video[0]));
        list.setCellRenderer(new ShortVideoRenderer());                         // Custom rendering for clickable links
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  // Allow single selection

        // Add a mouse listener for detecting clicks on list items
        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {  // Single click event
                    int index = list.locationToIndex(e.getPoint());  // Get the clicked index
                    Video selectedVideo = list.getModel().getElementAt(index);    // Get the selected video
                    openWebpage(selectedVideo.getUrl());
                }
            }
        });

        add(new JScrollPane(list));
        setVisible(true); // Make the frame visible
    }

    // Opens the specified URL in the default web browser
    private void openWebpage(String url) {
        try { 
            Desktop.getDesktop().browse(new URI(url)); // Open the URL in the browser
        } catch (Exception e) {
            e.printStackTrace(); // Print the error if an exception occurs
        }
    }

    // Inner class to define how video links are rendered in the JList.
    // Each video title is displayed as a clickable link.
    private class ShortVideoRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            // Create the base component
            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            label.setText("<html><a href=''>" + value.toString() + "</a></html>");   // Render as HTML link
            return label; // Return the customized label
        }
    
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
            java.util.logging.Logger.getLogger(VideoList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VideoList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VideoList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VideoList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
            SwingUtilities.invokeLater(() -> new VideoList());
            
    }
    }
}