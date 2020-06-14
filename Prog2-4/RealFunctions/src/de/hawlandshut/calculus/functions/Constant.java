package de.hawlandshut.calculus.functions;

import de.hawlandshut.calculus.Differiantiability.Differentiable;

public class Constant extends RealFunction implements Differentiable {
    private final double c;

    public Constant(double c){
        this.c = c;
    }
    @Override
    public double evaluateAt(double x) {
        return c;
    }

    @Override
    public boolean inDomain(double x) {
        return true;
    }

    @Override
    public String toString() {
        return String.format("%f",c);
    }

    @Override
    public RealFunction derive() {
        return new Constant(0);
    }
}
