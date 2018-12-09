package operator.memory;

import State.State;
import operator.Operator;

public class ClearError extends Operator {
   /**
    * @param state : State don on fait référence pour les opérations
    * @brief : Constructeur de la classe Operator
    */
   public ClearError(State state) {
      super(state);
   }

   @Override
   public void execute() {
      getState().setCurrentDisplay("0");
      getState().setError(false);
   }
}
