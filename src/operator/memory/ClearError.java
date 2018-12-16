/*
 -----------------------------------------------------------------------------------
 Laboratoire : Laboratoire 08
 Fichier     : ClearError.java
 Auteur(s)   : Bouyiatiotis - Jaquet
 Date        : 04.12.2018

 Remarque(s) :

 Compilateur : java 1.8.0_191
 -----------------------------------------------------------------------------------
 */

package operator.memory;

import state.State;
import operator.Operator;

/**
 * Réinitialise l’affichage à 0 et supprime une éventuelle erreur
 */
public class ClearError extends Operator {

   /**
    * Constructeur
    *
    * @param state     Etat de la calculatrice
    */
   public ClearError(State state) {
      super(state);
   }


   /**
    * Réinitialise l’affichage à 0 et supprime une éventuelle erreur
    */
   @Override
   public void execute() {
      State state = getState();

      state.setCurrentDisplay("0");
      state.setError(false);
      state.setRemoveOldDisplay(false);
   }
}
