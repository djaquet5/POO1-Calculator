/*
 -----------------------------------------------------------------------------------
 Laboratoire : Laboratoire 08
 Fichier     : Square.java
 Auteur(s)   : Bouyiatiotis - Jaquet
 Date        : 04.12.2018

 Remarque(s) :

 Compilateur : java 1.8.0_191
 -----------------------------------------------------------------------------------
 */

package operator.arithmetic;

import state.State;

/**
 * Calcule le carré d'une valeur affichée
 */
public class Square extends UnaryOperator {

   /**
    * Constructeur
    *
    * @param state     Etat de la calculatrice
    */
   public Square(State state) {
        super(state);
    }

   /**
    * Calcule le carré de la valeur contenue dans le currentDisplay de l'état
    */
   @Override
   public void execute() {
      State state = getState();
      double value = Double.parseDouble(state.getCurrentDisplay());
      
      if(!isOperationDoable()) {
         state.setError(true, "Impossible d'obtenir le carré");
         return;
      }

      state.setCurrentDisplay(String.valueOf(value * value));
      state.setRemoveOldDisplay(true);
   }
}
