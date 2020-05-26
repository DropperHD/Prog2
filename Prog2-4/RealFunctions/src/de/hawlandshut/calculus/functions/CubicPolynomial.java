package de.hawlandshut.calculus.functions;

import de.hawlandshut.calculus.Differiantiability.Differentiable;

public class CubicPolynomial extends RealFunction implements Differentiable {
    private final double a,b,c,d;

    public CubicPolynomial(double a, double b, double c, double d) {
        this.b = b;
        this.c = c;
        this.d = d;
        this.a = a;
    }

    @Override
    public double evaluateAt(double x) {
        return a * x * x * x + b * x * x + c * x + d;
    }
    @Override
    public boolean inDomain(double x) {
        return true;
    }

    @Override
    public String toString() {
        return String.format("%f*x^3+%f*x^2+%f*x+%f",a,b,c,d);
    }

    @Override
    public CubicPolynomial derive() {
        return new CubicPolynomial(0,3*a,2*b,c);
    }
}
