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
      if(!isOperationDoable())
         throw new RuntimeException("Impossible d'obtenir la racine");

      State state = getState();
      double result = Math.sqrt(Double.parseDouble(state.getCurrentDisplay()));

      state.push(result);
   }
}
