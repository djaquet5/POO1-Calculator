/*
 -----------------------------------------------------------------------------------
 Laboratoire : Laboratoire 08
 Fichier     : AddNumber.java
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
 * Permet d'ajouter un nombre dans la chaine de affiché par l'état state
 */
public class AddNumber extends Operator {
    private String value;

    /**
     * Constructeur
     *
     * @param state     Etat de la calculatrice
     * @param value     Valeur du chiffre à ajouter
     */
    public AddNumber(State state, String value){
        super(state);
        this.value = value;
    }

    /**
     * Ajoute le nombre voulu à la chaîne affiché par l'état
     */
    @Override
    public void execute() {
        State state = getState();

        if(!isOperationDoable()){
            state.setError(true, "Impossible de changer la valeur");
            return;
        }

        if(state.isRemoveOldDisplay()){
            state.addValue(Double.parseDouble(state.getCurrentDisplay()));
            state.setRemoveOldDisplay(false);
            state.setCurrentDisplay(value);
        } else if(state.getCurrentDisplay().equals("0")) {
            state.setCurrentDisplay(value);
        } else {
            state.setCurrentDisplay(state.getCurrentDisplay() + value);
        }
    }
}