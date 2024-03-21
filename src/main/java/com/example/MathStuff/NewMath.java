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
        //increases length of trig arrays to allow for space for derivatives, may need to increase futher
            Cosine[] cos = new Cosine[term.getCosine().length + 1];
                cos = term.getCosine();
            Sine[] sin = new Sine[term.getSine().length + 1];
                sin = term.getSine();
            Tangent[] tan = new Tangent[term.getTangent().length + 1];
                tan = term.getTangent();
            Variable[] variables = term.getVariables();

        //derivative of e
            if(e.power.isConstant == true){
                coefficient *= Math.pow(Math.E, e.power.getCoefficient());
            }else{
                Errors.printError("e with non-constant power");
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
                        ln.ifExists = false; ln = null; //new NaturalLog("na");  //should deal with getting rid of ln
                    }
                }else{
                    Errors.printError("natural log with power > 1");
                }
            }else{
                Errors.printError("natural log contains more than one term");
                //TODO - what to do if ln contains more than one term
            }

        //trig derivatives
            if(cos[0] != null && sin[0] != null && tan[0] != null){
                Errors.printError("trig");
            }
            //TODO - fuckin hate trig, i'll do this when I figure out a way to make it work with the system
            

        //variable derivatives (power rule)
                Variable v;
            for(int i=0; i<variables.length; i++){
                    v = variables[i];
                if(v.power.isConstant){
                    coefficient *= v.power.getCoefficient();
                    v.power.setCoefficient(v.power.getCoefficient() - 1);
                }else{
                    Errors.printError("variable with non-constant power");
                    //TODO - idk, i'll work on it
                }
            }

            return term;}

        }

    //TODO - complex calc stuff
        public Term ChainRule(Term term){  //if taking derivative of function to power
            return term;
        }

        public Term PartialDerivative(Term term, Variable withRespectTo){  //if partial derivative
            return term;
        }

        public Term IndefiniteIntegral(Term term, Variable withRespectTo, boolean includeC){
            return term;
        }

        public Term DefiniteIntegral(Term term, Variable withRespectTo, Term upperLimit, Term lowerLimit){
            return term;
        }

    }
