package de.hawlandshut.calculus.functions;

import de.hawlandshut.calculus.Differiantiability.Differentiable;

public class Exp extends RealFunction implements Differentiable {

    @Override
    public double evaluateAt(double x) {
        return Math.exp(x);
    }

    @Override
    public boolean inDomain(double x) {
        return true;
    }

    @Override
    public Exp derive() {
        return this;
    }

    @Override
    public String toString() {
        return "e^x";
    }
}
