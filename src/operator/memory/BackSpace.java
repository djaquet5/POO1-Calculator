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
import state.State;
import operator.*;

public class BackSpace extends Operator{

    public BackSpace(State state) {
        super(state);
    }
    
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