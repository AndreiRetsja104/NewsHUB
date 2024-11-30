/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NewsAndInformationHUB;

import java.util.ArrayList;

/**
 * Part of the QuizMOdule class,  
 * @author arets
 */
public class Quiz {
    
     private String questionText;
    private ArrayList<String> options;
    private int correctAnswerIndex;

    public Quiz(String questionText, ArrayList<String> options, int correctAnswerIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    // Getter for question text
    public String getQuestionText() {
        return questionText;
    }

    // Getter for answer options
    public ArrayList<String> getOptions() {
        return options;
    }

    // Getter for the index of the correct answer
    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }
}
    
 
