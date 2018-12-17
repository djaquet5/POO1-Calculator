/*
 -----------------------------------------------------------------------------------
 Laboratoire : Laboratoire 08
 Fichier     : Clear.java
 Auteur(s)   : Bouyiatiotis - Jaquet
 Date        : 04.12.2018

 Remarque(s) :

 Compilateur : java 1.8.0_191
 -----------------------------------------------------------------------------------
 */

package operator.memory;

import state.State;

/**
 * Réinitialise l’affichage, supprime une éventuelle erreur et vide la pile
 */
public class Clear extends ClearError {

   /**
    * Constructeur
    *
    * @param state     Etat de la calculatrice
    */
   public Clear(State state) {
      super(state);
   }


   /**
    * Réinitialise l’affichage, supprime une éventuelle erreur et vide la pile
    */
   @Override
   public void execute() {
      super.execute();

      getState().clearValues();
   }
}
