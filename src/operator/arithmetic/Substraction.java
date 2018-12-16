/*
 -----------------------------------------------------------------------------------
 Laboratoire : Laboratoire 08
 Fichier     : Substraction.java
 Auteur(s)   : Bouyiatiotis - Jaquet
 Date        : 04.12.2018

 Remarque(s) :

 Compilateur : java 1.8.0_191
 -----------------------------------------------------------------------------------
 */

package operator.arithmetic;

import state.State;

/**
 * Execute une soustraction entre 2 opérandes
 */
public class Substraction extends BinaryOperator {

   /**
    * Constructeur
    *
    * @param state     Etat de la calculatrice
    */
   public Substraction(State state) {
        super(state);
    }

   /**
    * Calcule la différence entre le premier élément de la pile et la valeur affichée
    */
   @Override
   public void execute() {
      State state = getState();

      if(!isOperationDoable()) {
         state.setError(true, "Impossible de faire la soustraction");
         return;
      }

      Double result = state.removeValue() - Double.parseDouble(state.getCurrentDisplay());

      state.setCurrentDisplay(String.valueOf(result));
      state.setRemoveOldDisplay(true);
   }
}
