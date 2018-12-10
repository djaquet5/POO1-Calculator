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

import State.State;
import javax.swing.JTextField;
import operator.Operator;

/**
 * Permet de rajouter un nombre dans la chaine de JCalculator
 *
 */
public class AddNumber extends Operator {
    String val;
    public AddNumber(State state, String val){
        super(state);
        this.val = val;
    }

    /**
     * Rajoute le nombre voulue dans la chaîne jNumber
     */
    @Override
    public void execute() {
        State state = getState();

        if(state.isRemoveOldDisplay()){
            state.addValue(Double.parseDouble(state.getCurrentDisplay()));
            state.setRemoveOldDisplay(false);
            state.setCurrentDisplay(val);
        } else if(state.getCurrentDisplay().equals("0")) {
            state.setCurrentDisplay(val);
        } else {
            state.setCurrentDisplay(state.getCurrentDisplay() + val);
        }
    }
}