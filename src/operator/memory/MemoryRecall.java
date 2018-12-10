package operator.memory;

import State.State;
import operator.Operator;

public class MemoryRecall extends Operator {
   /**
    * @param state : State don on fait référence pour les opérations
    * @brief : Constructeur de la classe Operator
    */
   public MemoryRecall(State state) {
      super(state);
   }

   @Override
   public void execute() {
      State state = getState();

      if(!isOperationDoable()) {
         state.setError(true, "La mémoire est vide");
         return;
      }

      state.setCurrentDisplay(state.getMemory());
   }

   @Override
   public boolean isOperationDoable() {
      return getState().getMemory() != null;
   }
}
