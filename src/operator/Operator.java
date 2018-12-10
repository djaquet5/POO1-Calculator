/*
 -----------------------------------------------------------------------------------
 Laboratoire : Labo08
 Fichier     : Operator.java
 Auteur(s)   : Bouyiatiotis - jaquet
 Date        : 04.12.2018

 Remarque(s) :

 Compilateur : MinGW-g++ <x.y.z>
 -----------------------------------------------------------------------------------
 */

package operator;
import state.State;

public abstract class Operator {
    private State state;
    
    /**
     * @brief       : Constructeur de la classe Operator
     * @param state : state don on fait référence pour les opérations
     */
    public Operator(State state){
        this.state = state;
    }
    
    /**
     * @brief   : method execute abstract qui sera redéfinie dans les sous
     *  classe de Operator
     */
    public abstract void execute();
    
    /**
     * @brief   : Permet de récupérer state
     * @return  : state de l'attribue state de Operator
     */
    public State getState(){
        return state;
    }

    public boolean isOperationDoable(){
        return !state.isError();
    }
}
