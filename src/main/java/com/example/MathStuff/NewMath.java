package com.example.MathStuff;

import com.example.Errors;
import com.example.MathStuff.Term.*;

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
            if(ln.containedEquation.terms.length == 1){
                if(ln.power.isConstant == true){
                    if(ln.power.getCoefficient() == 1){
                        int j = term.findVariable(ln.containedEquation.getTerm(0).getVariable(0).variableName);  //TODO - double check, but I think this is right
                        //TODO - remove ln from term, subtract 1 from power of variable at index j, multiply coefficient by power of variable inside ln equation
                        variables[j].power.setCoefficient(variables[j].power.getCoefficient() - 1);
                        coefficient *= ln.containedEquation.getTerm(0).getVariable(0).power.getCoefficient(); //assuming variable coefficient is constant
                        ln.ifExists = false; ln = new NaturalLog("na");  //should deal with getting rid of ln
                    }
                }else{
                    Errors.printError("natural log with power > 1");
                }
            }else{
                //TODO - what to do if ln contains more than one term
            }

        //trig derivatives
            //TODO - fuckin hate trig, i'll do this when I figure out a way to make it work with the system

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
            return term;
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
