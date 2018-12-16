/*
 -----------------------------------------------------------------------------------
 Laboratoire : Laboratoire 08
 Fichier     : Division.java
 Auteur(s)   : Bouyiatiotis - Jaquet
 Date        : 04.12.2018

 Remarque(s) :

 Compilateur : java 1.8.0_191
 -----------------------------------------------------------------------------------
 */

package operator.arithmetic;

import state.State;

/**
 * Effectue la division entre 2 opérandes
 */
public class Division extends BinaryOperator {

   /**
    * Constructeur
    *
    * @param state     Etat de la calculatrice
    */
   public Division(State state) {
        super(state);
    }

   /**
    * Calcule le produit entre le premier élément de la pile et la valeur affichée
    */
   @Override
   public void execute() {
      State state = getState();

      if(!isOperationDoable()) {
         state.setError(true, "Impossible de faire la division");
         return;
      }

      Double result = state.removeValue() / Double.parseDouble(state.getCurrentDisplay());

      state.setCurrentDisplay(String.valueOf(result));
      state.setRemoveOldDisplay(true);
   }

   /**
    * L'opération est faisable si :
    *    - L'état n'est pas en erreur
    *    - La pile n'est pas vide
    *    - Le currentDisplay est différent de 0
    *
    * @return  True si l'opération est faisable
    *          False sinon
    */
   @Override
   public boolean isOperationDoable() {
      return super.isOperationDoable() && !getState().getCurrentDisplay().equals("0");
   }
}
