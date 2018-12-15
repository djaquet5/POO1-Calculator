package operator.arithmetic;

import state.State;

public class Reversion extends UnaryOperator {

    public Reversion(State state) {
        super(state);
    }

   @Override
   public void execute() {
      State state = getState();

      if(!isOperationDoable()) {
         state.setError(true, "Impossible d'obtenir l'inverse");
         return;
      }

      Double result = 1 / Double.parseDouble(state.getCurrentDisplay());

      state.setCurrentDisplay(String.valueOf(result));
      state.setRemoveOldDisplay(true);
   }

   @Override
   public boolean isOperationDoable() {
      return super.isOperationDoable() && !getState().getCurrentDisplay().equals("0");
   }
}
