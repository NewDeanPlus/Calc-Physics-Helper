package com.example;

public class Term {

    private Operator operator;
    private double coefficient;
    private NumberE e;
    private NaturalLog ln;
    private Cosine cos;
    private Sine sin;
    private Tangent tan;
    private Integral integ;
    private Derivative deriv;
    private Variable[] variables;


    public Term(
        Operator operator,

        double coefficient, 
        
        NumberE e,
        NaturalLog ln,
        Cosine cos,
        Sine sin,
        Tangent tan,
        Integral integ,
        Derivative deriv,
        
        Variable... variables){

            this.operator = operator;
            this.coefficient = coefficient;
            this.e = e;
            this.ln = ln;
            this.cos = cos;
            this.sin = sin;
            this.tan = tan;
            this.integ = integ;
            this.deriv = deriv;
            this.variables = variables;

    }

    public Term(){}

    public class Operator{
            char type;
        public Operator(char c){
            this.type = c;
        }
    }

    //valid operators:
    //e, ln, sin, cos, tan, integral, derivative 

    public class NumberE{
            boolean ifExists;
            double power;
        public NumberE(double p){
            this.power = p;
            this.ifExists = true;
        }

        public NumberE(){  //no e in equation, e^0 equals 1
            this.ifExists = false;
        }
    }

    public class NaturalLog{
            boolean ifExists;
            double power;
            Term containedTerm;
        public NaturalLog(double p, Term t){
            this.power = p;
            this.containedTerm = t;
            this.ifExists = true;
        }

        public NaturalLog(){
            this.ifExists = false;
        }
    }

    public class Cosine{
            boolean ifExists;
            double power;
            Term containedTerm;
        public Cosine(double p, Term t){
            this.power = p;
            this.containedTerm = t;
            this.ifExists = true;
        }

        public Cosine(){
            this.ifExists = false;
        }
    }

    public class Sine{
            boolean ifExists;
            double power;
            Term containedTerm;
        public Sine(double p, Term t){
            this.power = p;
            this.containedTerm = t;
            this.ifExists = true;
        }

        public Sine(){
            this.ifExists = false;
        }
    }

    public class Tangent{
            boolean ifExists;
            double power;
            Term containedTerm;
        public Tangent(double p, Term t){
            this.power = p;
            this.containedTerm = t;
            this.ifExists = true;
        }

        public Tangent(){
            this.ifExists = false;
        }
    }

    public class Integral{
            boolean ifExists;
            char axisOfIntegration;
            double upperLimit;
            double lowerLimit;
        public Integral(char c){  //indefinite integral
            this.axisOfIntegration = c;
            this.ifExists = true;
        }

        public Integral(char c, double upper, double lower){  //definite integral
            this.axisOfIntegration = c;
            this.upperLimit = upper;
            this.lowerLimit = lower;
            this.ifExists = false;
        }

        public Integral(){
            this.ifExists = false;
        }
    }

    public class Derivative{  //appears as (d/dx) and so on
            boolean ifExists;
            char axisOfDerivation;
            boolean ifPartial;
        public Derivative(char c, boolean b){
            this.axisOfDerivation = c;
            this.ifPartial = b;
            this.ifExists = true;
        }

        public Derivative(){
            this.ifExists = false;
        }
    }

    public class Variable{
            boolean ifExists;
            char variableName;
            double power;
        public Variable(char c, double p){
            this.variableName = c;
            this.power = p;
            this.ifExists = true;
        }

        public Variable(){
            this.ifExists = false;
        }
    }

    //getters for different components of term
    public Operator getOperator(){
        return this.operator;
    }

    public double getCoefficient(){
        return this.coefficient;
    }

    public NumberE getNumberE(){
        return this.e;
    }

    public NaturalLog getNaturalLog(){
        return this.ln;
    }

    public Cosine getCosine(){
        return this.cos;
    }

    public Sine getSine(){
        return this.sin;
    }

    public Tangent getTangent(){
        return this.tan;
    }

    public Integral getIntegral(){
        return this.integ;
    }

    public Derivative getDerivative(){
        return this.deriv;
    }

    public Variable getVariable(int index){
        if(index > variables.length){
            return new Variable();
        }else{
            return variables[index];
        }
    }

}
