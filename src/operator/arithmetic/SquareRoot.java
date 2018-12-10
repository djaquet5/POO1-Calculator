package operator.arithmetic;

import State.State;
import java.util.Stack;
import operator.Operator;

public class SquareRoot extends UnaryOperator{

    public SquareRoot(State state) {
        super(state);
    }

   @Override
   public void execute() {
      State state = getState();

      if(!isOperationDoable()) {
         state.setError(true, "Impossible d'obtenir la racine");
         return;
      }

      Double result = Math.sqrt(Double.parseDouble(state.getCurrentDisplay()));

      state.setCurrentDisplay(result.toString());
      state.setRemoveOldDisplay(true);
   }
}
