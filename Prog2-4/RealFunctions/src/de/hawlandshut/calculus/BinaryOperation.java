package de.hawlandshut.calculus;

public abstract class BinaryOperation extends RealFunction {
    private final RealFunction left,right; //Eine Binäroperation besteht immer aus zwei Funktionen

    /**
     * Erstellt eine neue Binäroperation
     * @param left Erste Funktion
     * @param right Zweite Funktion
     */
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
