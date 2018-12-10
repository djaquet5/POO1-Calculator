package operator.arithmetic;

import State.State;
import java.util.Stack;
import operator.Operator;

public class Square extends UnaryOperator {

    public Square(State state) {
        super(state);
    }

   @Override
   public void execute() {
      State state = getState();

      if(!isOperationDoable()) {
         state.setError(true, "Impossible d'obtenir le carré");
         return;
      }

      double value = Double.parseDouble(state.getCurrentDisplay());

      state.setCurrentDisplay(String.valueOf(value * value));
      state.setRemoveOldDisplay(true);
   }
}
