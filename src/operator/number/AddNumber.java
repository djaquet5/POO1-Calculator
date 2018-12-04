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
        
        if(getState().getCurrentDisplay().equals("0")){
            getState().setCurrentDisplay(val);
        } else {
            getState().setCurrentDisplay(getState().getCurrentDisplay()+val);
        }
    }
}
