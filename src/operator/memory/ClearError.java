package operator.memory;

import state.State;
import operator.Operator;

public class ClearError extends Operator {
   /**
    * @param state : state don on fait référence pour les opérations
    * @brief : Constructeur de la classe Operator
    */
   public ClearError(State state) {
      super(state);
   }

   @Override
   public void execute() {
      State state = getState();

      state.setCurrentDisplay("0");
      state.setError(false);
      state.setRemoveOldDisplay(false);
   }
}
