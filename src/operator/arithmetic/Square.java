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
      if(!isOperationDoable())
         throw new RuntimeException("Impossible d'obtenir le carré");

      State state = getState();
      double value = Double.parseDouble(state.getCurrentDisplay());
      double result = value * value;

      state.push(result);
   }
}
