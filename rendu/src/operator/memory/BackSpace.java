/*
 -----------------------------------------------------------------------------------
 Laboratoire : Laboratoire 08
 Fichier     : Backspace.java
 Auteur(s)   : Bouyiatiotis - Jaquet
 Date        : 04.12.2018

 Remarque(s) :

 Compilateur : java 1.8.0_191
 -----------------------------------------------------------------------------------
 */

package operator.memory;

import state.State;
import operator.*;

/**
 * Supprime le dernier caractère d’une valeur en cours d’introduction
 */
public class BackSpace extends Operator{

    /**
     * Constructeur
     *
     * @param state     Etat de la calculatrice
     */
    public BackSpace(State state) {
        super(state);
    }

    /**
     * Supprime le dernier caractère d’une valeur en cours d’introduction
     */
    @Override
    public void execute() {
        State state = getState();
        if(!state.isRemoveOldDisplay()){
            if(state.getCurrentDisplay().compareTo("") != 0 && 
                    state.getCurrentDisplay().compareTo("0") != 0){
                String str = state.getCurrentDisplay();
                state.setCurrentDisplay(str.substring(0, str.length()-1));
            } else {
                state.setCurrentDisplay("0");
            }
        }
    }
}