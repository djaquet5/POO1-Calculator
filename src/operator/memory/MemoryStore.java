package operator.memory;

import State.State;
import operator.Operator;

public class MemoryStore extends Operator {
   /**
    * @param state : State don on fait référence pour les opérations
    * @brief : Constructeur de la classe Operator
    */
   public MemoryStore(State state) {
      super(state);
   }

   @Override
   public void execute() {
      if(!isOperationDoable())
         throw new RuntimeException("Impossible de mettre la valeur en mémoire");

      State state = getState();

      state.setMemory(state.getCurrentDisplay());
   }
}
