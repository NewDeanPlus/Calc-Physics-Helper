package com.example;

public class ProblemSolver {

    String problemType;
    String userInput;

    public String calcSolve(String problemType, String userInput){  //takes type of problem and text to redirect to problem stuff
        this.problemType = problemType;
        this.userInput = userInput;

        //switch statement to actually redirect based on problem type
        switch(problemType){
        //CALC 1
            case "Find Limit": 

                break;
            
            case "Test for Continuity":

                break;

            case "Find Derivative":

                break;

            case "Test for Calc 1 Graph Features":  //tests for inc/dec, local extrema, abs extrema, concavity, asymptotes

                break;

            case "Find Integral":

                break;

        //CALC 2
            case "Find Convergence":

                break;
            
            case "Convert to Parametric Equation":

                break;

            case "Find Second Derivative":

                break;

            case "Find Partial Derivative":

                break;
        }

        return null;
    }
}
