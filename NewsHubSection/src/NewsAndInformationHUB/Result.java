/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NewsAndInformationHUB;

/**
 * 
 * This class should work as counting the score for Quiz [ How many right quastions was answeard ]
 * 
 * @author arets
 */
public class Result {
    
    private int score; 
    private int totalQuestions;

    // The constructor wich is initialize the Result with a specific score  
    // Shows the total number of questions.
    public Result(int score, int totalQuestions) {
        this.score = score;
        this.totalQuestions = totalQuestions;
    }

    
    // Getters and Setters 
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    // The score and totalQuastions dispaly of number and questions
    //string for display
    @Override
    public String toString() {
        return "Score: " + score + " / " + totalQuestions;
    }
}
    
