package operator.memory;

import State.State;

public class Clear extends ClearError {
   /**
    * @param state : State don on fait référence pour les opérations
    * @brief : Constructeur de la classe Operator
    */
   public Clear(State state) {
      super(state);
   }

   @Override
   public void execute() {
      super.execute();

      getState().clearValues();
   }
}
