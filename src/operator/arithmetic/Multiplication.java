/*
 -----------------------------------------------------------------------------------
 Laboratoire : Laboratoire 08
 Fichier     : Multiplication.java
 Auteur(s)   : Bouyiatiotis - Jaquet
 Date        : 04.12.2018

 Remarque(s) :

 Compilateur : java 1.8.0_191
 -----------------------------------------------------------------------------------
 */

package operator.arithmetic;

import state.State;

/**
 * Effectue la multiplcation entre 2 opérandes
 */
public class Multiplication extends BinaryOperator {

   /**
    * Constructeur
    *
    * @param state     Etat de la calculatrice
    */
   public Multiplication(State state) {
        super(state);
    }

   /**
    * Calcule le produit entre le premier élément de la pile et la valeur affichée
    */
   @Override
   public void execute() {
      State state = getState();

      if(!isOperationDoable()) {
         state.setError(true, "Impossible de faire la multiplication");
         return;
      }

      Double result = state.removeValue() * Double.parseDouble(state.getCurrentDisplay());

      state.setCurrentDisplay(String.valueOf(result));
      state.setRemoveOldDisplay(true);
   }
}
