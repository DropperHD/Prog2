package de.hawlandshut.calculus.BinaryOperations;

import de.hawlandshut.calculus.Differiantiability.DiffException;
import de.hawlandshut.calculus.Differiantiability.Differentiable;
import de.hawlandshut.calculus.functions.RealFunction;

public class Addition extends BinaryOperation implements Differentiable {

    /**
     * Erstellt neue Addition
      * @param left Erste Funktion
     * @param right Zweite Funktion
     */
    public Addition(RealFunction left, RealFunction right) {
        super(left, right); //super muss immer zuerst stehen und gibt left und right an den Konstruktor von der Oberklasse
        if(left == null || right == null){
            throw new IllegalArgumentException("Einer der Argumente ist null!");
        }
    }

    @Override
    public double evaluateAt(double x){
        return getLeft().evaluateAt(x) + getRight().evaluateAt(x); //bei der Addition werden beide Ergebnisse addiert
    }

    @Override
    public boolean inDomain(double x){  //X muss in beiden Definitionsmengen sein
        return getLeft().inDomain(x) && getRight().inDomain(x);
    }

    @Override
    public String toString() {
        return "(" + getLeft().toString() + ")+(" + getRight().toString() + ")";
    }

    @Override
    public Addition derive() throws DiffException {
        if(!(getLeft() instanceof Differentiable && getRight() instanceof Differentiable)){ //Beide müssen das Interface implementieren
            throw new DiffException("Einer der beiden Operanden ist nicht Differenzierbar!");
        }
        return new Addition(((Differentiable) getLeft()).derive(), ((Differentiable) getRight()).derive()); //die Ableitung ist f' + g'
    }
}
