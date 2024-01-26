package com.example.MathStuff;

public class Equation {

    public Term[] terms;

    public Equation(Term... terms){

        this.terms = terms;
        //create some kind of system to link terms using operators (+,-,*,/) while still allowing for freedom of parentheses
        //also create functions that allow program to convert between objects and plain text, but won't need that for a while
    }

    public Term getTerm(int index){
        if(index+1 > terms.length){
            return new Term();
        }else{
            return terms[index];
        }
    }
}