/*
 -----------------------------------------------------------------------------------
 Laboratoire : Labo08
 Fichier     : ChangeSigne.java
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
 * Change le signe devant la valeur contenue dans la chaîne.
 */
public class ChangeSign extends Operator {

    public ChangeSign(State state) {
        super(state);
    }
    
    /**
     * Alterne entre + et - selon le signe. Ne fait rien si la valeur est 0
     */
    @Override
    public void execute() {
        State state = getState();

        if(!state.getCurrentDisplay().equals("0")){
            if(state.getCurrentDisplay().contains("-"))
                state.setCurrentDisplay(state.getCurrentDisplay().replace("-", ""));
            else
                state.setCurrentDisplay("-" + state.getCurrentDisplay());
        }
    }

}
