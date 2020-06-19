package de.hawlandshut.calculus;

public class Composition extends BinaryOperation implements Differentiable {
    public Composition(RealFunction left, RealFunction right) {
        super(left, right); //super muss immer zuerst stehen und gibt left und right an den Konstruktor von der Oberklasse
        if(left == null || right == null) {
            throw new IllegalArgumentException("Einer der Argumente ist null!");
        }
    }

    @Override
    public double evaluateAt(double x) {
        return getLeft().evaluateAt(getRight().evaluateAt(x)); //Berechnet x durch f(g(x))
    }

    @Override
    public boolean inDomain(double x) { //x muss im Definitionsbereich von right liegen und right(x) im Definitionsbereich von left
        return getLeft().inDomain(getRight().evaluateAt(x)) && getRight().inDomain(x);
    }

    @Override
    public Multiplication derive() throws DiffException {
        if(!(getLeft() instanceof Differentiable && getRight() instanceof Differentiable)){ //Beide müssen das Interface implementieren
            throw new DiffException("Einer der beiden Operanden ist nicht Differenzierbar!");
        }
        Composition Comp = new Composition(((Differentiable) getLeft()).derive(),getRight()); //f' ◦ g
        return new Multiplication(Comp, ((Differentiable) getRight()).derive()); //Die ganze Ableitung ist f' ◦ g + g'
    }

    @Override
    public String toString() {
        return "(" + getLeft().toString() + ")o(" + getRight().toString() + ")";
    }
}
