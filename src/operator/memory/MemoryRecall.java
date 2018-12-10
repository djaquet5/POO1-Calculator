package operator.memory;

import state.State;
import operator.Operator;

public class MemoryRecall extends Operator {
   /**
    * @param state : state don on fait référence pour les opérations
    * @brief : Constructeur de la classe Operator
    */
   public MemoryRecall(State state) {
      super(state);
   }

   @Override
   public void execute() {
      State state = getState();

      if(!isOperationDoable()) {
         state.setError(true, "Impossible de charger la mémoire");
         return;
      }

      state.setCurrentDisplay(state.getMemory());
   }

   @Override
   public boolean isOperationDoable() {
      return super.isOperationDoable() && getState().getMemory() != null;
   }
}
