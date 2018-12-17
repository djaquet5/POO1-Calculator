/*
 -----------------------------------------------------------------------------------
 Laboratoire : Laboratoire 08
 Fichier     : SquareRoot.java
 Auteur(s)   : Bouyiatiotis - Jaquet
 Date        : 04.12.2018

 Remarque(s) :

 Compilateur : java 1.8.0_191
 -----------------------------------------------------------------------------------
 */

package operator.arithmetic;

import state.State;

/**
 * Execute une la racine carrée d'une valeur affichée
 */
public class SquareRoot extends UnaryOperator{

   /**
    * Constructeur
    *
    * @param state     Etat de la calculatrice
    */
    public SquareRoot(State state) {
        super(state);
    }

   /**
    * Calcule la racine carrée de la valeur contenue dans le currentDisplay de l'état
    */
   @Override
   public void execute() {
      State state = getState();

      if(!isOperationDoable()){
         state.setError(true, "Impossible d'obtenir la racine.");
         return;
      }

      Double value = Math.sqrt(Double.parseDouble(state.getCurrentDisplay()));

      state.setCurrentDisplay(String.valueOf(value));
      state.setRemoveOldDisplay(true);
   }

   /**
    * L'opération est faisable si l'état n'est pas en erreur et si le currentDisplay est positif
    *
    * @return  True si l'opération est faisable
    *          False sinon
    */
   @Override
   public boolean isOperationDoable() {
      return super.isOperationDoable() && Double.parseDouble(getState().getCurrentDisplay()) >= 0;
   }
}
