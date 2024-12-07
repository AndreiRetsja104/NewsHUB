
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package NewsAndInformationHUB;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author seang
 */
public class LoginPageGUI extends javax.swing.JInternalFrame {

    /**
     * Creates new form UserProfileFormGUI
     */
    public LoginPageGUI() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        titleLBL = new javax.swing.JLabel();
        userTF = new javax.swing.JTextField();
        passwordTF = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        registerPageBTN = new javax.swing.JButton();
        enterBTN = new javax.swing.JButton();
        ImageLBL = new javax.swing.JLabel();
        userLBL = new javax.swing.JLabel();
        passwordLBL = new javax.swing.JLabel();
        ImageLoginLBL = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setToolTipText("");
        jPanel1.setPreferredSize(new java.awt.Dimension(840, 540));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titleLBL.setBackground(new java.awt.Color(255, 255, 255));
        titleLBL.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        titleLBL.setText("Login From ");
        jPanel1.add(titleLBL, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 160, -1));

        userTF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(204, 204, 204), null, null));
        userTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userTFActionPerformed(evt);
            }
        });
        jPanel1.add(userTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, 180, -1));

        passwordTF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        passwordTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(204, 204, 204), null, null));
        passwordTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordTFActionPerformed(evt);
            }
        });
        jPanel1.add(passwordTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 240, 180, -1));

        jLabel1.setText("For people who is not registered please proceed to the register page");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 380, 370, -1));

        registerPageBTN.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        registerPageBTN.setText("Register Page");
        registerPageBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerPageBTNActionPerformed(evt);
            }
        });
        jPanel1.add(registerPageBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 380, -1, -1));

        enterBTN.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        enterBTN.setText("Enter");
        enterBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterBTNActionPerformed(evt);
            }
        });
        jPanel1.add(enterBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 240, 100, -1));

        ImageLBL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Profile_Image.jpeg"))); // NOI18N
        jPanel1.add(ImageLBL, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 110, 120));

        userLBL.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        userLBL.setText("User name ");
        jPanel1.add(userLBL, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, 120, -1));

        passwordLBL.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        passwordLBL.setText("Password");
        jPanel1.add(passwordLBL, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, -1, -1));

        ImageLoginLBL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/MainPAge_Background.jpg"))); // NOI18N
        ImageLoginLBL.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        ImageLoginLBL.setMaximumSize(new java.awt.Dimension(840, 540));
        ImageLoginLBL.setMinimumSize(new java.awt.Dimension(840, 540));
        ImageLoginLBL.setPreferredSize(new java.awt.Dimension(840, 540));
        jPanel1.add(ImageLoginLBL, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 590));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void passwordTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordTFActionPerformed

    private void userTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userTFActionPerformed

    private void enterBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterBTNActionPerformed
        // TODO add your handling code here:
      // Retrieve username and password from input fields
    String username = userTF.getText();
    String password = new String(passwordTF.getText()); 

    System.out.println("Username: " + username); // For testing purposes only; remove in production

    // Attempt to authenticate by reading the credentials file
    try (BufferedReader reader = new BufferedReader(new FileReader("user_credentials.txt"))) {
        String line;
        boolean isAuthenticated = false;

        // Read each line in the credentials file
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            // Check if username and password match the input
            if (parts[0].equals(username) && parts[1].equals(password)) {
                isAuthenticated = true;
                break;
            }
        }
        // Show appropriate message based on authentication result
        if (isAuthenticated) {
            JOptionPane.showMessageDialog(this, "Login successful!");
            // Proceed to the next screen or main application window here if needed
        } else {
            JOptionPane.showMessageDialog(this, "Invalid credentials. Please try again.");
        }
    } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "Error reading credentials file.");
        e.printStackTrace(); // Optional: for debugging, remove in production
    }
    }//GEN-LAST:event_enterBTNActionPerformed

    private void registerPageBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerPageBTNActionPerformed
        // TODO add your handling code here:
        RegisterGUI registerGUI = new RegisterGUI();
        registerGUI.setVisible(true);
        getDesktopPane().add(registerGUI);
        registerGUI.setSelected(true);
        
    }//GEN-LAST:event_registerPageBTNActionPerformed

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
            java.util.logging.Logger.getLogger(LoginPageGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginPageGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginPageGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginPageGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPageGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ImageLBL;
    private javax.swing.JLabel ImageLoginLBL;
    private javax.swing.JButton enterBTN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel passwordLBL;
    private javax.swing.JTextField passwordTF;
    private javax.swing.JButton registerPageBTN;
    private javax.swing.JLabel titleLBL;
    private javax.swing.JLabel userLBL;
    private javax.swing.JTextField userTF;
    // End of variables declaration//GEN-END:variables
}
