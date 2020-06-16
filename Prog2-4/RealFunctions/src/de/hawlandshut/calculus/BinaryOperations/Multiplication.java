package de.hawlandshut.calculus.BinaryOperations;

import de.hawlandshut.calculus.Differiantiability.DiffException;
import de.hawlandshut.calculus.Differiantiability.Differentiable;
import de.hawlandshut.calculus.functions.RealFunction;

public class Multiplication extends BinaryOperation implements Differentiable {

    public Multiplication(RealFunction left, RealFunction right) {
        super(left, right);
        if(left == null || right == null) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public double evaluateAt(double x){
        return getLeft().evaluateAt(x) * getRight().evaluateAt(x);
    }

    @Override
    public boolean inDomain(double x){
        return getLeft().inDomain(x) && getRight().inDomain(x);
    }

    @Override
    public String toString() {
        return "(" + getLeft().toString() + ")*(" + getRight().toString() + ")";
    }

    @Override
    public Addition derive() throws DiffException {
        if(!(getLeft() instanceof Differentiable && getRight() instanceof Differentiable)){
            throw new DiffException("Eine der beiden Operanden ist nicht Differenzierbar!");
        }
        Multiplication firstMultiplication = new Multiplication(getLeft(), ((Differentiable) getRight()).derive());
        Multiplication secondMultiplication = new Multiplication(((Differentiable) getLeft()).derive(),getRight());
        return new Addition(firstMultiplication,secondMultiplication);
    }
}
