package de.hawlandshut.calculus.Differiantiability;

import de.hawlandshut.calculus.functions.RealFunction;

public interface Differentiable {                   //Interface zum Ableiten

    /**Leitet eine Reelle Funktion ab
     *
     * @return abgeleitete Reelle Funktion
     * @throws DiffException wird geworfen wenn Definitionsmenge
     */
    RealFunction derive() throws DiffException;
}
