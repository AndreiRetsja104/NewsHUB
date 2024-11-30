/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package NewsAndInformationHUB;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * I'm still need to work a little bit with this class , 
 * need to more organize things around , and think with end logik of quiz  
 *  
 * @author arets
 */
public class QuizzGUI extends javax.swing.JInternalFrame {
    private QuizzModule quizModule;
    private Timer timer;
    private int timeRemaining;
    
    
    // Constructor 
    public QuizzGUI() {
        initComponents();
        setupQuizModule();  
        setupActionListeners();
    }

    
    ///quiz module with predefined quiz questions and options
    private void setupQuizModule() {
        ArrayList<Quiz> quizzes = new ArrayList<>();

    // I wan't create minimum 10 quastions     
    // Quiz 1: Basic Concepts of Climate Change
    quizzes.add(new Quiz("What is the main greenhouse gas responsible for global warming?", 
                         new ArrayList<>(List.of("Oxygen", "Carbon Dioxide", "Nitrogen", "Argon", "Methane", "Water Vapor")), 1));
    quizzes.add(new Quiz("Which layer of the Earth’s atmosphere contains the ozone layer?", 
                         new ArrayList<>(List.of("Troposphere", "Stratosphere", "Mesosphere", "Thermosphere", "Exosphere", "Magnetosphere")), 1));
    quizzes.add(new Quiz("What is the primary cause of recent climate change?", 
                         new ArrayList<>(List.of("Natural cycles", "Solar activity", "Human activities", "Volcanic eruptions", "Deforestation", "Ocean currents")), 2));
    quizzes.add(new Quiz("What percentage of the Earth's water is freshwater?", 
                     new ArrayList<>(List.of("1%", "2.5%", "10%", "50%", "70%", "97%")), 1));

    quizzes.add(new Quiz("Which renewable energy source uses the Earth's internal heat?", 
                         new ArrayList<>(List.of("Solar", "Wind", "Geothermal", "Hydropower", "Biomass", "Tidal")), 2));

    quizzes.add(new Quiz("What is the largest contributor to deforestation?", 
                         new ArrayList<>(List.of("Urbanization", "Cattle ranching", "Logging", "Wildfires", "Mining", "Agriculture")), 1));

    quizzes.add(new Quiz("What is the main function of the ozone layer?", 
                         new ArrayList<>(List.of("Absorb carbon dioxide", "Reflect sunlight", "Protect from UV radiation", "Trap heat", "Provide oxygen", "Regulate temperature")), 2));

    quizzes.add(new Quiz("Which country is the largest producer of solar energy?", 
                         new ArrayList<>(List.of("India", "USA", "Germany", "China", "Australia", "Spain")), 3));

    quizzes.add(new Quiz("Which process is responsible for the majority of oxygen production on Earth?", 
                         new ArrayList<>(List.of("Rainforests", "Phytoplankton photosynthesis", "Volcanic eruptions", "Ocean currents", "Wind erosion", "Desertification")), 1));

    quizzes.add(new Quiz("What is the primary effect of melting polar ice caps?", 
                         new ArrayList<>(List.of("Ocean levels drop", "Ocean levels rise", "Global cooling", "Oxygen levels drop", "Increased salinity", "Stronger storms")), 1));

    
        System.out.println("Total Questions Added: " + quizzes.size());             
        quizModule = new QuizzModule(quizzes); // Initialize with the list of quizzes
        timeRemaining = 20; // Timer for 10 seconds
        resetQuiz();
    }
    private void setupActionListeners() {
        startQuizBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateQuestion();                             ////>>>>Update the question when starting the quiz <<<<<<<<<<
                submitAnswerBTN.setEnabled(true);
                startQuizBTN.setEnabled(false);
            }
        });

        submitAnswerBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitAnswer();
            }
        });

    }

    private void resetQuiz() {
        quizModule.moveToNextQuestion();
        scoreLBL.setText("Score: 0"); //Reset the score 
        startQuizBTN.setEnabled(true);
        submitAnswerBTN.setEnabled(false);// Disable the submit button until quiz starts
        resetSelections();
    }

    private void updateQuestion() {
        if (quizModule.hasNextQuestion()) {
            Quiz currentQuiz = quizModule.getCurrentQuiz();
            System.out.println("Displaying Question: " + currentQuiz.getQuestionText());

            questionLBL.setText(currentQuiz.getQuestionText());
            question1LBL.setText(currentQuiz.getOptions().get(0));
            question2LBL.setText(currentQuiz.getOptions().get(1));
            question3LBL.setText(currentQuiz.getOptions().get(2));
            question4LBL.setText(currentQuiz.getOptions().get(3));
            question5LBL.setText(currentQuiz.getOptions().get(4));
            question6LBL.setText(currentQuiz.getOptions().get(5));

            resetSelections();
            startTimer();
        } else {
            endQuiz();
        }
    }

    private void resetSelections() {
        answerCB1.setSelected(false);
        answerCB2.setSelected(false);
        answerCB3.setSelected(false);
        answerCB4.setSelected(false);
        answerCB5.setSelected(false);
        answerCB6.setSelected(false);
    }

    private void startTimer() {
        if (timer != null) {
            timer.stop();
        }

        timeRemaining = 20; // Reset timer
        timerLBL.setText("Time: " + timeRemaining);

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeRemaining--;
                timerLBL.setText("Time: " + timeRemaining);

                if (timeRemaining <= 0) {
                    timer.stop();
                    JOptionPane.showMessageDialog(null, "Time's up!");
                    quizModule.moveToNextQuestion();
                    updateQuestion();
                }
            }
        });
        timer.start();
    }

    private void submitAnswer() {
        // Ensure an answer is selected
        if (!answerCB1.isSelected() && !answerCB2.isSelected() && !answerCB3.isSelected() &&
            !answerCB4.isSelected() && !answerCB5.isSelected() && !answerCB6.isSelected()) {
            //   JOptionPane.showMessageDialog(this, "Please select an answer.");
            return; // Do not proceed without an answer
        }

        // Determine which answer is selected
        int selectedAnswer = answerCB1.isSelected() ? 0 :
                             answerCB2.isSelected() ? 1 :
                             answerCB3.isSelected() ? 2 :
                             answerCB4.isSelected() ? 3 :
                             answerCB5.isSelected() ? 4 : 5;

        // Check if the answer is correct
        boolean isCorrect = quizModule.checkAnswer(selectedAnswer);

        // Increment the score only if correct
        if (isCorrect) {
            quizModule.incrementScore();
        }

        // Provide feedback
        JOptionPane.showMessageDialog(this, isCorrect ? "Correct!" : "Incorrect.");

        // Update the score display
        updateScore();

        // Move to the next question if available
        if (quizModule.hasNextQuestion()) {
            quizModule.moveToNextQuestion();
            updateQuestion(); // Load the next question
        } else {
            endQuiz(); // End the quiz if no more questions
        }
    }
    
    private void updateScore() {
        int score = quizModule.getScore(); // Fetch the current score
        int totalQuestions = quizModule.getTotalQuestions(); // Fetch total questions from the module
        scoreLBL.setText("Score: " + score + " / " + totalQuestions); // Display correct total
    }

    private boolean quizEnded = false;

    private void endQuiz() {
        timer.stop();
        int totalQuestions = quizModule.getTotalQuestions(); // Fetch the correct total
        int score = quizModule.getScore();
        JOptionPane.showMessageDialog(this, "Quiz Finished! Your Score: " + score + " / " + totalQuestions);
        System.out.println("Your Score: " + score + " / " + totalQuestions);
        resetQuiz();
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
        quizTitleLBL = new javax.swing.JLabel();
        exitBTN = new javax.swing.JToggleButton();
        startQuizBTN = new javax.swing.JToggleButton();
        submitAnswerBTN = new javax.swing.JToggleButton();
        scoreLBL = new javax.swing.JLabel();
        timerLBL = new javax.swing.JLabel();
        question1LBL = new javax.swing.JLabel();
        question2LBL = new javax.swing.JLabel();
        question3LBL = new javax.swing.JLabel();
        question4LBL = new javax.swing.JLabel();
        question5LBL = new javax.swing.JLabel();
        question6LBL = new javax.swing.JLabel();
        answerCB1 = new javax.swing.JCheckBox();
        answerCB2 = new javax.swing.JCheckBox();
        answerCB3 = new javax.swing.JCheckBox();
        answerCB4 = new javax.swing.JCheckBox();
        answerCB5 = new javax.swing.JCheckBox();
        answerCB6 = new javax.swing.JCheckBox();
        questionLBL = new javax.swing.JLabel();
        whiteBackGroundLBL = new javax.swing.JLabel();
        ImageLBL = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(840, 540));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        quizTitleLBL.setBackground(new java.awt.Color(255, 255, 255));
        quizTitleLBL.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        quizTitleLBL.setForeground(new java.awt.Color(255, 255, 255));
        quizTitleLBL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        quizTitleLBL.setText("Quiz Form");
        jPanel1.add(quizTitleLBL, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 160, 40));

        exitBTN.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        exitBTN.setText("Exit");
        exitBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBTNActionPerformed(evt);
            }
        });
        jPanel1.add(exitBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 460, 90, 50));

        startQuizBTN.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        startQuizBTN.setText("Start Quiz");
        startQuizBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startQuizBTNActionPerformed(evt);
            }
        });
        jPanel1.add(startQuizBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 120, 50));

        submitAnswerBTN.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        submitAnswerBTN.setText("Submit Answer");
        submitAnswerBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitAnswerBTNActionPerformed(evt);
            }
        });
        jPanel1.add(submitAnswerBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 470, 140, 40));

        scoreLBL.setBackground(new java.awt.Color(255, 255, 255));
        scoreLBL.setText("Score");
        jPanel1.add(scoreLBL, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 210, 100, 30));
        jPanel1.add(timerLBL, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 210, 100, 30));

        question1LBL.setText("Question 1 :");
        jPanel1.add(question1LBL, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 180, -1));

        question2LBL.setText("Question 2 :");
        jPanel1.add(question2LBL, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 180, 20));

        question3LBL.setText("Question 3 :");
        jPanel1.add(question3LBL, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, 180, 20));

        question4LBL.setText("Question 4 :");
        jPanel1.add(question4LBL, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 350, 180, 20));

        question5LBL.setText("Question 5 :");
        jPanel1.add(question5LBL, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 390, 180, 20));

        question6LBL.setText("Question 6 :");
        jPanel1.add(question6LBL, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 430, 180, 20));

        answerCB1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        answerCB1.setText("answer");
        jPanel1.add(answerCB1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, -1, -1));

        answerCB2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        answerCB2.setText("answer");
        jPanel1.add(answerCB2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 390, -1, 20));

        answerCB3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        answerCB3.setText("answer");
        jPanel1.add(answerCB3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 430, -1, 20));

        answerCB4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        answerCB4.setText("answer");
        jPanel1.add(answerCB4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 350, 70, 20));

        answerCB5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        answerCB5.setText("answer");
        answerCB5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answerCB5ActionPerformed(evt);
            }
        });
        jPanel1.add(answerCB5, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 390, 70, -1));

        answerCB6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        answerCB6.setText("answer");
        jPanel1.add(answerCB6, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 430, 70, 20));

        questionLBL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        questionLBL.setText("Question");
        jPanel1.add(questionLBL, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 640, 30));

        whiteBackGroundLBL.setBackground(new java.awt.Color(255, 255, 255));
        whiteBackGroundLBL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/WhiteBackGround.jpg"))); // NOI18N
        jPanel1.add(whiteBackGroundLBL, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, 320));

        ImageLBL.setBackground(new java.awt.Color(255, 255, 255));
        ImageLBL.setForeground(new java.awt.Color(255, 255, 255));
        ImageLBL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/RegisterPageBackGround.jpg"))); // NOI18N
        ImageLBL.setMaximumSize(new java.awt.Dimension(840, 540));
        ImageLBL.setMinimumSize(new java.awt.Dimension(840, 540));
        ImageLBL.setPreferredSize(new java.awt.Dimension(840, 540));
        jPanel1.add(ImageLBL, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 530));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 840, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startQuizBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startQuizBTNActionPerformed
        // TODO add your handling code here:
    // Reset the quiz
    quizModule.resetQuiz();

    // Reset the displayed score
    scoreLBL.setText("Score: 0 / " + quizModule.getAvailableQuizzes().size());

    // Enable the Submit Answer button
    submitAnswerBTN.setEnabled(true);

    // Disable the Start Quiz button
    startQuizBTN.setEnabled(false);

    // Start with the first question
    updateQuestion();

    }//GEN-LAST:event_startQuizBTNActionPerformed

    private void submitAnswerBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitAnswerBTNActionPerformed
        // TODO add your handling code here:
           submitAnswer();
            
    }//GEN-LAST:event_submitAnswerBTNActionPerformed

    private void exitBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBTNActionPerformed
        // TODO add your handling code here:
            System.exit(0); //exit from system
    }//GEN-LAST:event_exitBTNActionPerformed

    private void answerCB5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answerCB5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_answerCB5ActionPerformed

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
            java.util.logging.Logger.getLogger(QuizzGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuizzGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuizzGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuizzGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuizzGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ImageLBL;
    private javax.swing.JCheckBox answerCB1;
    private javax.swing.JCheckBox answerCB2;
    private javax.swing.JCheckBox answerCB3;
    private javax.swing.JCheckBox answerCB4;
    private javax.swing.JCheckBox answerCB5;
    private javax.swing.JCheckBox answerCB6;
    private javax.swing.JToggleButton exitBTN;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel question1LBL;
    private javax.swing.JLabel question2LBL;
    private javax.swing.JLabel question3LBL;
    private javax.swing.JLabel question4LBL;
    private javax.swing.JLabel question5LBL;
    private javax.swing.JLabel question6LBL;
    private javax.swing.JLabel questionLBL;
    private javax.swing.JLabel quizTitleLBL;
    private javax.swing.JLabel scoreLBL;
    private javax.swing.JToggleButton startQuizBTN;
    private javax.swing.JToggleButton submitAnswerBTN;
    private javax.swing.JLabel timerLBL;
    private javax.swing.JLabel whiteBackGroundLBL;
    // End of variables declaration//GEN-END:variables
}
