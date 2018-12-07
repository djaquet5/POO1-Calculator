package operator.arithmetic;

import State.State;
import java.util.Stack;
import operator.Operator;

public class Multiplication extends BinaryOperator {

    public Multiplication(State state) {
        super(state);
    }


   @Override
   public void execute() {
      if(!isOperationDoable())
         throw new RuntimeException("Impossible de faire la multiplication");

      State state = getState();
      double result = state.pop() * Double.parseDouble(state.getCurrentDisplay());

      state.push(result);
   }
}
