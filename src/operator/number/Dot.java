/*
 -----------------------------------------------------------------------------------
 Laboratoire : Laboratoire 08
 Fichier     : Dot.java
 Auteur(s)   : Bouyiatiotis - Jaquet
 Date        : 04.12.2018

 Remarque(s) :

 Compilateur : java 1.8.0_191
 -----------------------------------------------------------------------------------
 */

package operator.number;

import state.State;
import operator.Operator;

/**
 * Ajoute un point dans la chaîne de JCalculator. Si un point s'y trouve déjà
 * alors rien n'est rajouté.
 */
public class Dot extends Operator{

    /**
     * Constructeur
     *
     * @param state     Etat de la calculatrice
     */
    public Dot(State state) {
        super(state);
    }

    /**
     * Execute l'opération
     */
    @Override
    public void execute() {
        State state = getState();

        if(!state.getCurrentDisplay().contains("."))
            state.setCurrentDisplay(state.getCurrentDisplay()+".");
    }
}
