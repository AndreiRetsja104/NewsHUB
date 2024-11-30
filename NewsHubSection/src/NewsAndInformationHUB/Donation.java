/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NewsAndInformationHUB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author arets
 */
public class Donation {
        // Attributes
    private String name;
    private String phone;
    private String email;
    private float donationAmount;
    private List<NGOList> preferredNGOs;

    // Constructor
    public Donation() {
        this.preferredNGOs = new ArrayList<>();
    }
    
    
    // Methods
    public void fillForm(String userName, String userPhone, String userEmail, float donationAmount) {
        this.name = userName;
        this.phone = userPhone;
        this.email = userEmail;
        this.donationAmount = donationAmount;
    }

   // public Confirmation submitDonation() {
        // Logic to submit donation data
     //   return new Confirmation();
   // }

    public List<NGOList> suggestNGOs() {
        // Suggests NGOs based on some logic, if needed
        return preferredNGOs;
    }

    
    
    public Donation(String name, String phone, String email, float donationAmount, List<NGOList> preferredNGOs) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.donationAmount = donationAmount;
        this.preferredNGOs = preferredNGOs;
    }

    // Getters and Setters
    public String getUserName() { return name; }
    public void setUserName(String userName) { this.name = userName; }

    public String getUserPhone() { return phone; }
    public void setUserPhone(String userPhone) { this.phone = userPhone; }

    public String getUserEmail() { return email; }
    public void setUserEmail(String userEmail) { this.email = userEmail; }

    public float getDonationAmount() { return donationAmount; }
    public void setDonationAmount(float donationAmount) { this.donationAmount = donationAmount; }

    public List<NGOList> getPreferredNGOs() { return preferredNGOs; }
    public void setPreferredNGOs(List<NGOList> preferredNGOs) { this.preferredNGOs = preferredNGOs; }

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
    

