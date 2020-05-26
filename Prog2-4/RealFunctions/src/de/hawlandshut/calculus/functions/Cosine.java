package de.hawlandshut.calculus.functions;

import de.hawlandshut.calculus.Differiantiability.Differentiable;

public class Cosine extends RealFunction implements Differentiable {
    private final double a,f;

    public Cosine(double a, double f){
        this.a = a;
        this.f = f;
    }
    @Override
    public double evaluateAt(double x) {
        return a * Math.cos(x * f);
    }

    @Override
    public boolean inDomain(double x) {
        return true;
    }

    @Override
    public String toString() {
        return String.format("%f*cos(%f*x)",a,f);
    }

    @Override
    public Sine derive() {
        return new Sine(-a * f, f);
    }
}
