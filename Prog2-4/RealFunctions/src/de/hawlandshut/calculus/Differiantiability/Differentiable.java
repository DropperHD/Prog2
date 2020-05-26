package de.hawlandshut.calculus.Differiantiability;

import de.hawlandshut.calculus.functions.RealFunction;

public interface Differentiable {

    RealFunction derive() throws DiffException;
}
