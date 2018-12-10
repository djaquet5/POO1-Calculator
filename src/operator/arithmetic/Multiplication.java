package operator.arithmetic;

import state.State;

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

      Double result = state.removeValue() * Double.parseDouble(state.getCurrentDisplay());

      state.setCurrentDisplay(result.toString());
      state.setRemoveOldDisplay(true);
   }
}
