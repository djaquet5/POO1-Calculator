package operator.arithmetic;

import State.State;
import java.util.Stack;
import operator.Operator;

public class Reversion extends UnaryOperator {

    public Reversion(State state) {
        super(state);
    }

   @Override
   public void execute() {
      if(!isOperationDoable())
         throw new RuntimeException("Impossible d'obtenir l'inverse");

      State state = getState();
      double result = 1 / Double.parseDouble(state.getCurrentDisplay());

      state.push(result);
   }

   @Override
   public boolean isOperationDoable() {
      return super.isOperationDoable() && !getState().getCurrentDisplay().equals("0");
   }
}
