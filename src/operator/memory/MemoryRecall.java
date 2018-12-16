/*
 -----------------------------------------------------------------------------------
 Laboratoire : Laboratoire 08
 Fichier     : MemoryRecall.java
 Auteur(s)   : Bouyiatiotis - Jaquet
 Date        : 04.12.2018

 Remarque(s) :

 Compilateur : java 1.8.0_191
 -----------------------------------------------------------------------------------
 */

package operator.memory;

import state.State;
import operator.Operator;

public class MemoryRecall extends Operator {

   /**
    * Constructeur
    *
    * @param state     Etat de la calculatrice
    */
   public MemoryRecall(State state) {
      super(state);
   }

   /**
    * Ajoute la valeur affiché dans state dans la mémoire
    */
   @Override
   public void execute() {
      State state = getState();

      if(!isOperationDoable()) {
         state.setError(true, "Impossible de charger la mémoire");
         return;
      }

      state.setCurrentDisplay(state.getMemory());
      state.setRemoveOldDisplay(true);
   }

   /**
    * Vérifie si l'opération est faisable ou non
    * @return  True si il n'y a pas d'erreur et qu'une valeur est stocké en mémoire
    */
   @Override
   public boolean isOperationDoable() {
      return super.isOperationDoable() && getState().getMemory() != null;
   }
}
