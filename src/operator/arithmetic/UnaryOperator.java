/*
 -----------------------------------------------------------------------------------
 Laboratoire : Laboratoire 08
 Fichier     : UnaryOperator.java
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
 * Classe abstraite représentant les opération avec une seule opérande
 */
public abstract class UnaryOperator extends Operator {

   /**
    * Constructeur
    *
    * @param state     Etat de la calculatrice
    */
   public UnaryOperator(State state) {
      super(state);
   }
}
