/*
 -----------------------------------------------------------------------------------
 Laboratoire : Laboratoire 08
 Fichier     : MemoryStore.java
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
 * Permet de stocker la valeur afficher dans state dans la mémoire
 */
public class MemoryStore extends Operator {

   /**
    * Constructeur
    *
    * @param state     Etat de la calculatrice
    */
   public MemoryStore(State state) {
      super(state);
   }

   /**
    * Ajoute la valeur affiché dans state dans la mémoire
    */
   @Override
   public void execute() {
      State state = getState();

      if(!isOperationDoable()) {
         state.setError(true, "Impossible de mettre la valeur en mémoire");
         return;
      }

      state.setMemory(state.getCurrentDisplay());
   }
}