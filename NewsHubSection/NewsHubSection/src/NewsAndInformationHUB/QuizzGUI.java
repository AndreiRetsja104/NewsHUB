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
            JOptionPane.showMessageDialog(this, "Please select an answer.");
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

        question6LBL = new javax.swing.JLabel();
        question5LBL = new javax.swing.JLabel();
        question2LBL = new javax.swing.JLabel();
        question1LBL = new javax.swing.JLabel();
        question4LBL = new javax.swing.JLabel();
        question3LBL = new javax.swing.JLabel();
        scoreLBL = new javax.swing.JLabel();
        quizTitleLBL = new javax.swing.JLabel();
        timerLBL = new javax.swing.JLabel();
        answerCB1 = new javax.swing.JCheckBox();
        answerCB3 = new javax.swing.JCheckBox();
        answerCB2 = new javax.swing.JCheckBox();
        answerCB4 = new javax.swing.JCheckBox();
        answerCB5 = new javax.swing.JCheckBox();
        answerCB6 = new javax.swing.JCheckBox();
        exitBTN = new javax.swing.JToggleButton();
        startQuizBTN = new javax.swing.JToggleButton();
        submitAnswerBTN = new javax.swing.JToggleButton();
        questionLBL = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(840, 540));

        question6LBL.setText("Question 6 :");

        question5LBL.setText("Question 5 :");

        question2LBL.setText("Question 2 :");

        question1LBL.setText("Question 1 :");

        question4LBL.setText("Question 4 :");

        question3LBL.setText("Question 3 :");

        scoreLBL.setBackground(new java.awt.Color(255, 255, 255));

        quizTitleLBL.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        quizTitleLBL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        quizTitleLBL.setText("Quiz Form");

        answerCB1.setText("answer");

        answerCB3.setText("answer");

        answerCB2.setText("answer");

        answerCB4.setText("answer");

        answerCB5.setText("answer");
        answerCB5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answerCB5ActionPerformed(evt);
            }
        });

        answerCB6.setText("answer");

        exitBTN.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        exitBTN.setText("Exit");
        exitBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBTNActionPerformed(evt);
            }
        });

        startQuizBTN.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        startQuizBTN.setText("Start Quiz");
        startQuizBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startQuizBTNActionPerformed(evt);
            }
        });

        submitAnswerBTN.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        submitAnswerBTN.setText("Submit Answer");
        submitAnswerBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitAnswerBTNActionPerformed(evt);
            }
        });

        questionLBL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        questionLBL.setText("Question");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(231, 231, 231)
                        .addComponent(submitAnswerBTN))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(41, 41, 41)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(question1LBL)
                                            .addComponent(question2LBL)
                                            .addComponent(question3LBL))
                                        .addGap(56, 56, 56)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(answerCB1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(answerCB2)
                                            .addComponent(answerCB3))
                                        .addGap(115, 115, 115)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(question5LBL)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(answerCB5))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(question4LBL)
                                                .addGap(86, 86, 86)
                                                .addComponent(answerCB4))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(question6LBL)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(answerCB6))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addComponent(startQuizBTN)))
                                .addGap(59, 59, 59))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(scoreLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(exitBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(timerLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(questionLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(262, 262, 262)
                        .addComponent(quizTitleLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(quizTitleLBL)
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scoreLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timerLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(startQuizBTN)
                .addGap(29, 29, 29)
                .addComponent(questionLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(question1LBL)
                    .addComponent(answerCB1)
                    .addComponent(question4LBL)
                    .addComponent(answerCB4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(question2LBL)
                    .addComponent(answerCB2)
                    .addComponent(question5LBL)
                    .addComponent(answerCB5))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(answerCB3)
                    .addComponent(question3LBL)
                    .addComponent(question6LBL)
                    .addComponent(answerCB6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(submitAnswerBTN)
                .addGap(12, 12, 12)
                .addComponent(exitBTN)
                .addGap(50, 50, 50))
        );

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
    private javax.swing.JCheckBox answerCB1;
    private javax.swing.JCheckBox answerCB2;
    private javax.swing.JCheckBox answerCB3;
    private javax.swing.JCheckBox answerCB4;
    private javax.swing.JCheckBox answerCB5;
    private javax.swing.JCheckBox answerCB6;
    private javax.swing.JToggleButton exitBTN;
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
    // End of variables declaration//GEN-END:variables
}
