package de.hawlandshut.calculus.functions;

import de.hawlandshut.calculus.Differiantiability.Differentiable;

public class Sine extends RealFunction implements Differentiable {
    private final double a,f;

    public Sine(double a,double f){
        this.a = a;
        this.f = f;
    }

    @Override
    public double evaluateAt(double x) {
        return a * Math.sin(x * f);
    }

    @Override
    public boolean inDomain(double x) {
        return true;
    }

    @Override
    public String toString() {
        return String.format("%f*sin(%f*x)",a,f);
    }

    @Override
    public Cosine derive() {
        return new Cosine(a*f, f);
    }
}
