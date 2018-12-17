/*
 -----------------------------------------------------------------------------------
 Laboratoire : Laboratoire 08
 Fichier     : Operator.java
 Auteur(s)   : Bouyiatiotis - Jaquet
 Date        : 04.12.2018

 Remarque(s) :

 Compilateur : java 1.8.0_191
 -----------------------------------------------------------------------------------
 */

package operator;

import state.State;

/**
 * Classe abstraite représentant les opérateurs de la calculatrice
 */
public abstract class Operator {
    private State state;
    
    /**
     * Constructeur de la classe Operator
     *
     * @param state     State dont on fait référence pour les opérations
     */
    public Operator(State state){
        this.state = state;
    }
    
    /**
     * Méthode abstraite permettant d'exécuter l'opération
     */
    public abstract void execute();
    
    /**
     * Permet de récupérer l'état de la la calculatrice
     *
     * @return  Etat de la calculcatrice
     */
    public State getState(){
        return state;
    }

    /**
     * Vérifie si l'opération est faisable ou non
     *
     * @return  True si l'oprétation est faisable
     *          False sinon
     */
    public boolean isOperationDoable(){
        return !state.isError();
    }
}
