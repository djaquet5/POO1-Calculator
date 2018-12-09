package operator.arithmetic;

import State.State;

public class Multiplication extends BinaryOperator {

    public Multiplication(State state) {
        super(state);
    }


   @Override
   public void execute() {
      State state = getState();

      if(!isOperationDoable()) {
         state.setError(true, "Impossible de faire la multiplication");
         return;
      }

      double result = state.removeValue() * Double.parseDouble(state.getCurrentDisplay());

      state.addValue(result);
      state.setRemoveOldDisplay(true);
   }
}
