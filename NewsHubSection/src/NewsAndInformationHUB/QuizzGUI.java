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
 
    
    
        quizModule = new QuizzModule(quizzes); // Initialize with the list of quizzes
        timeRemaining = 10; // Timer for 10 seconds
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
        if (quizModule.hasNextQuestion()) {       //<<<<<< It is check if there has more questions
            Quiz currentQuiz = quizModule.getCurrentQuiz();
            quizTitleLBL.setText("Quiz Title: General Knowledge");
            questionLBL.setText(currentQuiz.getQuestionText()); //<>>>>  Set Question text <<<<<<<< 
            
             //<<<<<<<<<<<<<<< Display answer options in labels 1 2 3 4 5 6
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
    }

    private void startTimer() {
        if (timer != null) timer.stop();
        timeRemaining = 10;
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
        if (!answerCB1.isSelected() && !answerCB2.isSelected() && !answerCB3.isSelected() && !answerCB4.isSelected()) {
            JOptionPane.showMessageDialog(this, "Please select an answer.");
            return;
        }
        // >>>>Determine which answer is selected <<<<<
        int selectedAnswer = answerCB1.isSelected() ? 0 :
                             answerCB2.isSelected() ? 1 :
                             answerCB3.isSelected() ? 2 : 3;

        boolean isCorrect = quizModule.checkAnswer(selectedAnswer);
        JOptionPane.showMessageDialog(this, isCorrect ? "Correct!" : "Incorrect.");
        if (isCorrect) {
            quizModule.moveToNextQuestion();
        }
        updateScore();          // Update the score
        updateQuestion();       // Load the next question
    }

    private void updateScore() { ///Updates the score display
        int score = quizModule.getCurrentQuestionIndex();
        scoreLBL.setText("Score: " + score + " / " + quizModule.getAvailableQuizzes().size());
    }

    private void endQuiz() { ///Ends the quiz, stops the timer, and displays the final score
        timer.stop();
        JOptionPane.showMessageDialog(this, "Quiz Finished! " + scoreLBL.getText());
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
        quizTitleLBL.setText("Quiz Title");

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

        exitBTN.setText("Exit");
        exitBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBTNActionPerformed(evt);
            }
        });

        startQuizBTN.setText("Start Quiz");
        startQuizBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startQuizBTNActionPerformed(evt);
            }
        });

        submitAnswerBTN.setText("Submit Answer");
        submitAnswerBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitAnswerBTNActionPerformed(evt);
            }
        });

        questionLBL.setText("Question");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(questionLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
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
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(exitBTN)
                                            .addComponent(answerCB6)))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(startQuizBTN)))
                .addGap(44, 44, 44)
                .addComponent(timerLBL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(212, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(329, 329, 329)
                        .addComponent(quizTitleLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(231, 231, 231)
                        .addComponent(submitAnswerBTN)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(scoreLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(433, 433, 433))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(submitAnswerBTN)
                .addGap(18, 18, 18)
                .addComponent(exitBTN)
                .addGap(44, 44, 44))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startQuizBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startQuizBTNActionPerformed
        // TODO add your handling code here:
                updateQuestion();
                submitAnswerBTN.setEnabled(true);
                startQuizBTN.setEnabled(false);
            
          
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
