/*
 -----------------------------------------------------------------------------------
 Laboratoire : Laboratoire 08
 Fichier     : Enter.java
 Auteur(s)   : Bouyiatiotis - Jaquet
 Date        : 04.12.2018

 Remarque(s) :

 Compilateur : java 1.8.0_191
 -----------------------------------------------------------------------------------
 */

package operator.memory;

import state.State;
import operator.Operator;

/**
 * Permet d'ajouter un nouvel élément dans la pile de l'état de la calculatrice
 */
public class Enter extends Operator{

    /**
     * Constructeur
     *
     * @param state     Etat de la calculatrice
     */
    public Enter(State state) {
        super(state);
    }

    /**
     * Entre une nouvelle valeur dans la pile de l'état de la calculatrice
     */
    @Override
    public void execute() {
        State state = getState();

        if(!isOperationDoable()){
            state.setError(true, "Impossible d'ajouter un nombre");
            return;
        }

        Double val = Double.parseDouble(state.getCurrentDisplay());
        state.addValue(val);
        state.setCurrentDisplay("0");
        state.setRemoveOldDisplay(false);
    }
    
}