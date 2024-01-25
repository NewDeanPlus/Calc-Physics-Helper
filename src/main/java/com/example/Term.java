package com.example;

public class Term {

    private Operator operator;
    private double coefficient;
    private NumberE e;
    private NaturalLog ln;
    private Cosine cos;
    private Sine sin;
    private Tangent tan;
    // private Integral integ;
    //private Derivative deriv;
    private Variable[] variables;

    public boolean isConstant = false;


    public Term(
        Operator operator,

        double coefficient, 
        
        NumberE e,
        NaturalLog ln,
        Cosine cos,
        Sine sin,
        Tangent tan,
        // Integral integ,
        // Derivative deriv,
        
        Variable... variables){

            this.operator = operator;
            this.coefficient = coefficient;
            this.e = e;
            this.ln = ln;
            this.cos = cos;
            this.sin = sin;
            this.tan = tan;
            // this.integ = integ;
            // this.deriv = deriv;
            this.variables = variables;

    }

    public Term(double coefficient){
        this.coefficient = coefficient;
        this.isConstant = true;
    }

    public Term(double coefficient, Variable... variables){
        this.coefficient = coefficient;
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
            public Term power;
        public NumberE(Term p){
            this.power = p;
            this.ifExists = true;
        }

        public NumberE(String na){  //no e in equation, e^0 equals 1
            this.ifExists = false;
        }
    }

    public class NaturalLog{
            boolean ifExists;
            Term power;
            Term containedTerm;
        public NaturalLog(Term p, Term t){
            this.power = p;
            this.containedTerm = t;
            this.ifExists = true;
        }

        public NaturalLog(String na){
            this.ifExists = false;
        }
    }

    public class Cosine{
            boolean ifExists;
            Term power;
            Term containedTerm;
        public Cosine(Term p, Term t){
            this.power = p;
            this.containedTerm = t;
            this.ifExists = true;
        }

        public Cosine(String na){
            this.ifExists = false;
        }
    }

    public class Sine{
            boolean ifExists;
            Term power;
            Term containedTerm;
        public Sine(Term p, Term t){
            this.power = p;
            this.containedTerm = t;
            this.ifExists = true;
        }

        public Sine(String na){
            this.ifExists = false;
        }
    }

    public class Tangent{
            boolean ifExists;
            Term power;
            Term containedTerm;
        public Tangent(Term p, Term t){
            this.power = p;
            this.containedTerm = t;
            this.ifExists = true;
        }

        public Tangent(String na){
            this.ifExists = false;
        }
    }

    // public class Integral{
    //         boolean ifExists;
    //         char axisOfIntegration;
    //         double upperLimit;
    //         double lowerLimit;
    //     public Integral(char c){  //indefinite integral
    //         this.axisOfIntegration = c;
    //         this.ifExists = true;
    //     }

    //     public Integral(char c, double upper, double lower){  //definite integral
    //         this.axisOfIntegration = c;
    //         this.upperLimit = upper;
    //         this.lowerLimit = lower;
    //         this.ifExists = false;
    //     }

    //     public Integral(String na){
    //         this.ifExists = false;
    //     }
    // }

    // public class Derivative{  //appears as (d/dx) and so on
    //         boolean ifExists;
    //         char axisOfDerivation;
    //         boolean ifPartial;
    //     public Derivative(char c, boolean b){
    //         this.axisOfDerivation = c;
    //         this.ifPartial = b;
    //         this.ifExists = true;
    //     }

    //     public Derivative(){
    //         this.ifExists = false;
    //     }
    // }

    public class Variable{
            boolean ifExists;
            char variableName;
            Term power;
        public Variable(char c, Term p){
            this.variableName = c;
            this.power = p;
            this.ifExists = true;
        }

        public Variable(String na){
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

    // public Integral getIntegral(){
    //     return this.integ;
    // }

    // public Derivative getDerivative(){
    //     return this.deriv;
    // }

    public Variable getVariable(int index){
        if(index > variables.length){
            return new Variable("na");
        }else{
            return variables[index];
        }
    }

    public Variable[] getVariables(){
        return variables;
    }

    //setters

    public void setCoefficient(double a){
        this.coefficient = a;
    }

    public void setNumberE(NumberE a){
        this.e = a;
    }

    public void setNaturalLog(NaturalLog a){
        this.ln = a;
    }

    public void setCosine(Cosine a){
        this.cos = a;
    }

    public void setSine(Sine a){
        this.sin = a;
    }

    public void setTangent(Tangent a){
        this.tan = a;
    }

    

}
