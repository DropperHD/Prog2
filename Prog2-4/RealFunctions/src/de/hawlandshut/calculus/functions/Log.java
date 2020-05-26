package de.hawlandshut.calculus.functions;

import de.hawlandshut.calculus.Differiantiability.Differentiable;

public class Log extends RealFunction implements Differentiable {
    @Override
    public double evaluateAt(double x) {
        if (!inDomain(x))
            throw new OutsideOfDomainException();
        return Math.log(x);
    }

    @Override
    public boolean inDomain(double x) {
        return x > 0;
    }

    @Override
    public String toString() {
        return "ln(x)";
    }

    @Override
    public Log derive() {
        return new LogDerivative();
    }

    private static class LogDerivative extends Log{
        @Override
        public double evaluateAt(double x) {
            return 1/x;
        }

        @Override
        public boolean inDomain(double x) {
            return x > 0;
        }
    }
}