/*
 -----------------------------------------------------------------------------------
 Laboratoire : Laboratoire 08
 Fichier     : BinaryOperator.java
 Auteur(s)   : Bouyiatiotis - Jaquet
 Date        : 04.12.2018

 Remarque(s) :

 Compilateur : java 1.8.0_191
 -----------------------------------------------------------------------------------
 */

package operator.arithmetic;

import state.State;
import operator.Operator;

/**
 * Classe abstraite représentant les opération avec deux opérandes
 */
public abstract class BinaryOperator extends Operator {

   /**
    * Constructeur
    *
    * @param state     Etat de la calculatrice
    */
   public BinaryOperator(State state){
      super(state);
   }

   /**
    * L'opération est faisable si l'état n'est pas en erreur et si la pile n'est pas vide
    *
    * @return  True si l'oprétation est faisable
    *          False sinon
    */
   @Override
   public boolean isOperationDoable() {
      return super.isOperationDoable() && !getState().isEmpty();
   }
}
