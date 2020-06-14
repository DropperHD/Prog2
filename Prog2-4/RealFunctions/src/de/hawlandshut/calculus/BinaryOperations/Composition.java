package de.hawlandshut.calculus.BinaryOperations;

import de.hawlandshut.calculus.Differiantiability.DiffException;
import de.hawlandshut.calculus.Differiantiability.Differentiable;
import de.hawlandshut.calculus.functions.RealFunction;

public class Composition extends BinaryOperation implements Differentiable {
    public Composition(RealFunction left, RealFunction right) {
        super(left, right);
        if(left == null || right == null) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public double evaluateAt(double x) {
        return getLeft().evaluateAt(getRight().evaluateAt(x));
    }

    @Override
    public boolean inDomain(double x) {
        return getLeft().inDomain(getRight().evaluateAt(x)) && getRight().inDomain(x);
    }

    @Override
    public Multiplication derive() throws DiffException {
        if(!(getLeft() instanceof Differentiable && getRight() instanceof Differentiable)){
            throw new DiffException("Diff");
        }
        Composition Comp = new Composition(((Differentiable) getLeft()).derive(),getRight());
        return new Multiplication(Comp, ((Differentiable) getRight()).derive());
    }

    @Override
    public String toString() {
        return "(" + getLeft().toString() + ")o(" + getRight().toString() + ")";
    }
}
