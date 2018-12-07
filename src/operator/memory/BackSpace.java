/*
 -----------------------------------------------------------------------------------
 Laboratoire : Labo08
 Fichier     : BackSpace.java
 Auteur(s)   : Bouyiatiotis - jaquet
 Date        : 04.12.2018

 Remarque(s) : 

 Compilateur : MinGW-g++ <x.y.z>
 -----------------------------------------------------------------------------------
 */
package operator.memory;
import State.State;
import operator.*;

public class BackSpace extends Operator{

    public BackSpace(State state) {
        super(state);
    }
    
    @Override
    public void execute() {
        if(getState().getCurrentDisplay().compareTo("") != 0){
            String str = getState().getCurrentDisplay();
            getState().setCurrentDisplay(str.substring(0, str.length()-1));
        }
    }
    
}
