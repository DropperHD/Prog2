package de.hawlandshut.calculus.BinaryOperations;

import de.hawlandshut.calculus.Differiantiability.DiffException;
import de.hawlandshut.calculus.Differiantiability.Differentiable;
import de.hawlandshut.calculus.functions.RealFunction;

public class Multiplication extends BinaryOperation implements Differentiable {

    public Multiplication(RealFunction left, RealFunction right) {
        super(left, right); //super muss immer zuerst stehen und gibt left und right an den Konstruktor von der Oberklasse
        if(left == null || right == null) {
            throw new IllegalArgumentException("Einer der Argumente ist null!");
        }
    }

    @Override
    public double evaluateAt(double x){
        return getLeft().evaluateAt(x) * getRight().evaluateAt(x); //Das Ergebnis ist beide Funktionswerte multipliziert
    }

    @Override
    public boolean inDomain(double x){
        return getLeft().inDomain(x) && getRight().inDomain(x); //X muss in beiden Definitionsmengen sein
    }

    @Override
    public String toString() {
        return "(" + getLeft().toString() + ")*(" + getRight().toString() + ")";
    }

    @Override
    public Addition derive() throws DiffException {
        if(!(getLeft() instanceof Differentiable && getRight() instanceof Differentiable)){
            throw new DiffException("Einer der beiden Operanden ist nicht Differenzierbar!");
        }
        Multiplication firstMultiplication = new Multiplication(getLeft(), ((Differentiable) getRight()).derive());
        Multiplication secondMultiplication = new Multiplication(((Differentiable) getLeft()).derive(),getRight());
        return new Addition(firstMultiplication,secondMultiplication); //Die Ableitung geschieht nach dem Schema f * g' + f' * g
    }
}
