package operator.arithmetic;

import State.State;
import java.util.Stack;
import operator.Operator;

public class Substraction extends BinaryOperator {

    public Substraction(State state) {
        super(state);
    }
   
   @Override
   public void execute() {
      if(!isOperationDoable())
         throw new RuntimeException("Impossible de faire la multiplication");

      State state = getState();
      double result = state.pop() - Double.parseDouble(state.getCurrentDisplay());

      state.push(result);
   }
}
