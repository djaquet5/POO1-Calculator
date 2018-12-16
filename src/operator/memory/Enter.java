/*
 -----------------------------------------------------------------------------------
 Laboratoire : Labo08
 Fichier     : Enter.java
 Auteur(s)   : Bouyiatiotis - jaquet
 Date        : 04.12.2018

 Remarque(s) :

 Compilateur : MinGW-g++ <x.y.z>
 -----------------------------------------------------------------------------------
 */
package operator.memory;
import state.State;
import operator.Operator;

public class Enter extends Operator{

    public Enter(State state) {
        super(state);
    }

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
