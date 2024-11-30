/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NewsAndInformationHUB;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

/**
 * This class is part of the QuizModule class
 * Here is still need to work whit it,   
 * @author arets
 */
public class QuizzModule {
    private List<Quiz> quizzes;
    private int currentQuestionIndex;
    private int timeRemaining;
    private Timer timer;
      
    public QuizzModule(ArrayList<Quiz> quizzes) {
        this.quizzes = quizzes;
        this.currentQuestionIndex = 0;
        this.timeRemaining = 10;
    }

    // Returns the current quiz
    public Quiz getCurrentQuiz() {
        return quizzes.get(currentQuestionIndex);
    }

    // Checks for answer if is correct
    public boolean checkAnswer(int answerIndex) {
        return quizzes.get(currentQuestionIndex).getCorrectAnswerIndex() == answerIndex;
    }

    // Moves to the next question 
    public void moveToNextQuestion() {
        currentQuestionIndex++;
    }

    // Checks for more questions in the quiz
    public boolean hasNextQuestion() {
        return currentQuestionIndex < quizzes.size();
    }

    // Getter for the current question 
    public int getCurrentQuestionIndex() {
        return currentQuestionIndex;
    }

    // Starts a timer for the quiz
    public void startTimer(Runnable onTimeOut) {
        
    }

    // Stops the timer
    public void stopTimer() {
        if (timer != null) {
            timer.cancel();
        }
    }

    // Getter for the remaining time
    public int getTimeRemaining() {
        return timeRemaining;
    }
    
    // Sets up a list of available quizzes , it will be in the future 
    public ArrayList<String> getAvailableQuizzes() {
        ArrayList<String> availableQuizzes = new ArrayList<>();
        availableQuizzes.add("Quiz 1: Basic Concepts of Climate Change");
      //  availableQuizzes.add("Quiz 2: Advanced Topics on Global Warming");
      //  availableQuizzes.add("Quiz 3: Renewable Energy Technologies");
      //  availableQuizzes.add("Quiz 4: Understanding Carbon Footprint");
      //  availableQuizzes.add("Quiz 5: Biodiversity and Ecosystems");
      //  availableQuizzes.add("Quiz 6: Water Conservation Techniques");
      //  availableQuizzes.add("Quiz 7: The Role of NGOs in Environmental Protection");
      //  availableQuizzes.add("Quiz 8: Sustainable Agriculture Practices");
      //  availableQuizzes.add("Quiz 9: Climate Policy and International Agreements");
      //  availableQuizzes.add("Quiz 10: Waste Management and Recycling");
        return availableQuizzes;
    }

        public Result displayQuiz(int quizID) {
        // this function is Display the quiz and calculate a result
        int score = 0; // Example score
        int totalQuestions = quizzes.size(); // Quizzes is the list of questions
        

        // Display the quiz or calculate results as needed
        return new Result(score, totalQuestions);
    }
    
    // Updates the quiz 
    public void updateQuiz() {
        // Implementation to update quiz
    }

    // Submits an answer to the quiz 
    public void submitAnswers(String answer) {
        System.out.println("Submitted answer: " + answer);
       
    }
}