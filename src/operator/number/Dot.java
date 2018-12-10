/*
 -----------------------------------------------------------------------------------
 Laboratoire : Labo08
 Fichier     : Dot.java
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
 * Ajoute un point dans la chaîne de JCalculator. Si un point s'y trouve déjà 
 * alors rien n'est rajouté.
 */
public class Dot extends Operator{

    public Dot(State state) {
        super(state);
    }

    @Override
    public void execute() {
        State state = getState();

        if(!state.getCurrentDisplay().contains("."))
            state.setCurrentDisplay(state.getCurrentDisplay()+".");
    }
}
