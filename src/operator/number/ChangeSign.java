/*
 -----------------------------------------------------------------------------------
 Laboratoire : Laboratoire 08
 Fichier     : ChangeSign.java
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
 * Change le signe devant la valeur contenue dans la chaîne affichée dans state.
 */
public class ChangeSign extends Operator {

   /**
    * Constructeur
    *
    * @param state   Etat de la calculatrice
    */
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
