package com.example;

public class Functions {
    
    public static char indexToVariable(int index){
        char[] c = new char[2];
        c = Character.toChars(index+65);
        return c[0];
    }

    public static int variableToIndex(char variable){
        return (Character.getNumericValue(variable) - 10);
    }

}
