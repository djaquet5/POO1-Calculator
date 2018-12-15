/*
 -----------------------------------------------------------------------------------
 Laboratoire : Labo08
 Fichier     : AddNumber.java
 Auteur(s)   : Bouyiatiotis - Jaquet
 Date        : 27.112018

 Remarque(s) : 

 Compilateur : MinGW-g++ <x.y.z>
 -----------------------------------------------------------------------------------
 */
package operator.number;

import state.State;
import operator.Operator;

/**
 * Permet de rajouter un nombre dans la chaine de JCalculator
 *
 */
public class AddNumber extends Operator {
    private String value;

    public AddNumber(State state, String value){
        super(state);
        this.value = value;
    }

    /**
     * Rajoute le nombre voulue dans la chaîne jNumber
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