package operator.arithmetic;

import State.State;

public class Substraction extends BinaryOperator {

    public Substraction(State state) {
        super(state);
    }
   
   @Override
   public void execute() {
      State state = getState();

      if(!isOperationDoable()) {
         state.setError(true, "Impossible de faire la soustraction");
         return;
      }

      Double result = state.removeValue() - Double.parseDouble(state.getCurrentDisplay());

      state.setCurrentDisplay(result.toString());
      state.setRemoveOldDisplay(true);
   }
}
