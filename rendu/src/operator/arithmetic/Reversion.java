/*
 -----------------------------------------------------------------------------------
 Laboratoire : Laboratoire 08
 Fichier     : Reversion.java
 Auteur(s)   : Bouyiatiotis - Jaquet
 Date        : 04.12.2018

 Remarque(s) :

 Compilateur : java 1.8.0_191
 -----------------------------------------------------------------------------------
 */

package operator.arithmetic;

import state.State;

/**
 * Effectue l'opération inverse d'une valeur affichée
 */
public class Reversion extends UnaryOperator {

   /**
    * Constructeur
    *
    * @param state     Etat de la calculatrice
    */
   public Reversion(State state) {
        super(state);
    }

   /**
    * Effectue l'inverse de la valeur contenue dans le currentDisplay de l'état
    */
   @Override
   public void execute() {
      State state = getState();

      if(!isOperationDoable()) {
         state.setError(true, "Impossible d'obtenir l'inverse");
         return;
      }

      Double result = 1 / Double.parseDouble(state.getCurrentDisplay());

      state.setCurrentDisplay(String.valueOf(result));
      state.setRemoveOldDisplay(true);
   }

   /**
    * L'opération est faisable si l'état n'est pas en erreur et si le currentDisplay est différent de 0
    *
    * @return  True si l'opération est faisable
    *          False sinon
    */
   @Override
   public boolean isOperationDoable() {
      return super.isOperationDoable() && !getState().getCurrentDisplay().equals("0");
   }
}
