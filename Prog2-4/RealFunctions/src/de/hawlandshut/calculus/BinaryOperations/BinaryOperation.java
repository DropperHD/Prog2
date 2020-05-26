package de.hawlandshut.calculus.BinaryOperations;

import de.hawlandshut.calculus.functions.RealFunction;

public abstract class BinaryOperation extends RealFunction {
    private final RealFunction left,right;

    public BinaryOperation(RealFunction left, RealFunction right) {
        this.left = left;
        this.right = right;
    }

    public RealFunction getLeft() {
        return left;
    }

    public RealFunction getRight() {
        return right;
    }
}
