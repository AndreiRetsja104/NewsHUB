/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package NewsAndInformationHUB;



import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;


/**
 *
 * @author arets
 */
public class DonationGUI extends javax.swing.JInternalFrame {
    private String selectedNGO = ""; 
    private JList<String> ngoList;
    private NGOList ngoListData;
    private Donation donation;
    
    /**
     * Creates new form DonationGUI
     */

    public DonationGUI() {
        this.donation = new Donation();
        this.ngoListData = new NGOList();
        initComponents();
        initializeNGOList();
    }

    private void initializeNGOList() {
        DefaultListModel<String> model = new DefaultListModel<>();
        List<String> ngos = ngoListData.getNgoList();

        for (String ngo : ngos) {
            model.addElement(ngo);
        }

        displayNGOTAJL.setModel(model);
        displayNGOTAJL.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    
        private void saveToFile(String name, String phone, String email, float amount, String ngo) {
        String fileName = "UserDonation.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write("Name: " + name + ", ");
            writer.write("Phone: " + phone + ", ");
            writer.write("Email: " + email + ", ");
            writer.write("Amount: €" + amount + ", ");
            writer.write("NGO: " + ngo);
            writer.newLine(); // Move to the next line
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving donation details: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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

        nameLBL = new javax.swing.JLabel();
        donationLBL = new javax.swing.JLabel();
        phoneLBL = new javax.swing.JLabel();
        emailLBL = new javax.swing.JLabel();
        confirmationLBL = new javax.swing.JLabel();
        nameTF = new javax.swing.JTextField();
        donationTF = new javax.swing.JTextField();
        emailTF = new javax.swing.JTextField();
        phoneTF = new javax.swing.JTextField();
        headerLBL = new javax.swing.JLabel();
        exitBTN = new javax.swing.JToggleButton();
        submitDonationBTN = new javax.swing.JToggleButton();
        confirmDonationBTN = new javax.swing.JButton();
        confirmNgoBTN = new javax.swing.JButton();
        ScrollPane1 = new javax.swing.JScrollPane();
        displayTA = new javax.swing.JTextArea();
        ScrollPane2 = new javax.swing.JScrollPane();
        displayNGOTAJL = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(840, 540));

        nameLBL.setText("Name :");

        donationLBL.setText("Donation Amount");

        phoneLBL.setText("Phone");

        emailLBL.setText("Email:");

        confirmationLBL.setText("confirmation");

        nameTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTFActionPerformed(evt);
            }
        });

        headerLBL.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        headerLBL.setText("                             Donation Form ");

        exitBTN.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        exitBTN.setText("Exit");
        exitBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBTNActionPerformed(evt);
            }
        });

        submitDonationBTN.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        submitDonationBTN.setText("Submite");
        submitDonationBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitDonationBTNActionPerformed(evt);
            }
        });

        confirmDonationBTN.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        confirmDonationBTN.setText("Confirm");
        confirmDonationBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmDonationBTNActionPerformed(evt);
            }
        });

        confirmNgoBTN.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        confirmNgoBTN.setText("Confirm NGO");
        confirmNgoBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmNgoBTNActionPerformed(evt);
            }
        });

        displayTA.setColumns(20);
        displayTA.setRows(5);
        ScrollPane1.setViewportView(displayTA);

        ScrollPane2.setViewportView(displayNGOTAJL);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addComponent(headerLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(261, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(donationLBL)
                            .addComponent(phoneLBL)
                            .addComponent(emailLBL)
                            .addComponent(nameLBL))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(phoneTF, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(donationTF, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailTF, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(confirmNgoBTN)
                            .addComponent(submitDonationBTN)))
                    .addComponent(ScrollPane1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(ScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(confirmationLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(confirmDonationBTN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exitBTN)
                        .addGap(59, 59, 59))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(headerLBL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(confirmNgoBTN)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameLBL))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emailTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailLBL))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(phoneTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phoneLBL))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(donationTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(donationLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(submitDonationBTN))
                    .addComponent(ScrollPane2))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(confirmationLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(confirmDonationBTN)
                        .addComponent(exitBTN))
                    .addComponent(ScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nameTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTFActionPerformed

    private void exitBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBTNActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitBTNActionPerformed

    private void submitDonationBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitDonationBTNActionPerformed
    // TODO add your handling code here:
        if (selectedNGO.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please choose an NGO first.\nThen press Button Confirm NGO"  , "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String name = nameTF.getText();
        String phone = phoneTF.getText();
        String email = emailTF.getText();
        float amount;
        try {
            amount = Float.parseFloat(donationTF.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid donation amount.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        displayTA.append("Donation submitted successfully!\n");
        displayTA.append("To: " + selectedNGO + "\n");
        displayTA.append("Name: " + name + "\n");
        displayTA.append("Phone: " + phone + "\n");
        displayTA.append("Email: " + email + "\n");
        displayTA.append("Amount: €" + amount + "\n\n");
    
    }//GEN-LAST:event_submitDonationBTNActionPerformed

    private void confirmDonationBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmDonationBTNActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Donation confirmed. Thank you \nDonation details was saved in UserDonation.txt file In the src folder.");

        // Save details to file
        String name = nameTF.getText();
        String phone = phoneTF.getText();
        String email = emailTF.getText();
        float amount;
        try {
            amount = Float.parseFloat(donationTF.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid donation amount.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        saveToFile(name, phone, email, amount, selectedNGO);

        // Clear fields
        nameTF.setText("");
        phoneTF.setText("");
        emailTF.setText("");
        donationTF.setText("");
        displayTA.setText("");
        selectedNGO = "";
    
    }//GEN-LAST:event_confirmDonationBTNActionPerformed

    private void confirmNgoBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmNgoBTNActionPerformed
        // TODO add your handling code here:
    if (displayNGOTAJL.getSelectedValue() != null) {
        selectedNGO = displayNGOTAJL.getSelectedValue();
        JOptionPane.showMessageDialog(this, "Selected NGO: " + selectedNGO);
    } else {
        JOptionPane.showMessageDialog(this, "Please select an NGO.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_confirmNgoBTNActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        JFrame frame = new JFrame("Donation GUI Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);
        DonationGUI donationGUI = new DonationGUI();
        frame.add(donationGUI);
        donationGUI.setVisible(true);
        frame.setVisible(true);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrollPane1;
    private javax.swing.JScrollPane ScrollPane2;
    private javax.swing.JButton confirmDonationBTN;
    private javax.swing.JButton confirmNgoBTN;
    private javax.swing.JLabel confirmationLBL;
    private javax.swing.JList<String> displayNGOTAJL;
    private javax.swing.JTextArea displayTA;
    private javax.swing.JLabel donationLBL;
    private javax.swing.JTextField donationTF;
    private javax.swing.JLabel emailLBL;
    private javax.swing.JTextField emailTF;
    private javax.swing.JToggleButton exitBTN;
    private javax.swing.JLabel headerLBL;
    private javax.swing.JLabel nameLBL;
    private javax.swing.JTextField nameTF;
    private javax.swing.JLabel phoneLBL;
    private javax.swing.JTextField phoneTF;
    private javax.swing.JToggleButton submitDonationBTN;
    // End of variables declaration//GEN-END:variables
}
