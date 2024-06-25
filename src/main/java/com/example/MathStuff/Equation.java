package com.example.MathStuff;

import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.Functions;
import com.example.Regex;

public class Equation {

    public Term[] terms;

    public String equation;
    public String[] containedTerms = new String[26];

    public static Pattern p1 = Regex.pattern1[1];
    public static Matcher m1;

    public Equation(Term... terms){
        //left over constructor, may re-use later
        this.terms = terms;
    }

    public Equation(String equation){
        //use regex to get ( [anything that isn't parentheses] ) and put into containedTerms array. replace stuff in parentheses with char from Functions.indexToVariable
        equation = equation.replaceAll(" ", ""); //removes whitespace
        m1 = p1.matcher(equation);

        for(int i=0; i<containedTerms.length; i++){
            if(m1.find()){
                containedTerms[i] = m1.group();
                equation = equation.replaceFirst("(\\([^\\(|\\)]*\\))", String.valueOf(Functions.indexToVariable(i)));
                m1 = p1.matcher(equation);
            }else{
        System.out.println("c");
                break;
            }
        }
        System.out.println(equation);
    }

    public Term getTerm(int index){
        if(index+1 > terms.length){
            return new Term();
        }else{
            return terms[index];
        }
    }
}