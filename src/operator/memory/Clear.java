package operator.memory;

import state.State;

public class Clear extends ClearError {
   /**
    * @param state : state don on fait référence pour les opérations
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
