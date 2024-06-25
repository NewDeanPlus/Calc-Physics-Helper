package com.example;

public final class Errors {

    public enum errors {
        rareExpression, trigError
    }
    public static String msg;
    
    public static void printError(errors errorType){
        switch(errorType){
            case rareExpression: msg = "The program was not prepared for this kind of expression. Please report as feedback.";
                break;
            case trigError: msg = "That's some weird trig shit. Please report as feedback.";
                break;
            default: msg = "Unknown Error";
        }

        System.out.println("Error: "+msg);
    }

    public static void printError(String msg){
        System.out.println("Error: "+msg);
    }

}
