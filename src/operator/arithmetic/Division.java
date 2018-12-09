package operator.arithmetic;
import State.State;

public class Division extends BinaryOperator {

    public Division(State state) {
        super(state);
    }


   @Override
   public void execute() {
      State state = getState();

      if(!isOperationDoable()) {
         state.setError(true, "Impossible de faire la division");
         return;
      }

      double result = state.removeValue() / Double.parseDouble(state.getCurrentDisplay());

      state.addValue(result);
      state.setRemoveOldDisplay(true);
   }

   @Override
   public boolean isOperationDoable() {
      return super.isOperationDoable() && !getState().getCurrentDisplay().equals("0");
   }
}
