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
import State.State;
import operator.Operator;

public class Enter extends Operator{

    public Enter(State state) {
        super(state);
    }

    @Override
    public void execute() {
        Double val = Double.parseDouble(getState().getCurrentDisplay());
        getState().addValue(val);
        getState().setCurrentDisplay("0");
    }
    
}
