package com.example;

import com.example.Term.*;

public class NewMath {

    public static class DerivationRules {
    
        public Term Derivative(Term term){
            //if derivative exists in term, perform power rule

            double coefficient = term.getCoefficient();
            NumberE e = term.getNumberE();
            NaturalLog ln = term.getNaturalLog();
            Cosine cos = term.getCosine();
            Sine sin = term.getSine();
            Tangent tan = term.getTangent();
            Variable[] variables = term.getVariables();

        //derivative of e
            if(e.power.isConstant == true){
                coefficient *= Math.pow(Math.E, e.power.getCoefficient());
            }else{
                //TODO - idk, sounds complicated
            }

        //derivative of ln

        //trig derivatives

        //variable derivatives (power rule)
                Variable v;
            for(int i=0; i<variables.length; i++){
                    v = variables[i];
                if(v.power.isConstant){
                    coefficient *= v.power.getCoefficient();
                    v.power.setCoefficient(v.power.getCoefficient() - 1);
                }else{
                    //TODO - idk, i'll work on it
                }
            }

            return term;}

        }

        public Term ChainRule(Term term){
            return term
        }

        public Term PartialDerivative(Term term, Variable withRespectTo){
            return term;
        }

        public Term IndefiniteIntegral(Term term, Variable withRespectTo, boolean includeC){
            return term;
        }

        public Term DefiniteIntegral(Term term, Variable withRespectTo, Term upperLimit, Term lowerLimit){
            return term;
        }

    }
    
}
