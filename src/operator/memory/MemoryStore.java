package operator.memory;

import state.State;
import operator.Operator;

public class MemoryStore extends Operator {
   /**
    * @param state : state don on fait référence pour les opérations
    * @brief : Constructeur de la classe Operator
    */
   public MemoryStore(State state) {
      super(state);
   }

   @Override
   public void execute() {
      State state = getState();

      if(!isOperationDoable()) {
         state.setError(true, "Impossible de mettre la valeur en mémoire");
         return;
      }

      state.setMemory(state.getCurrentDisplay());
   }
}