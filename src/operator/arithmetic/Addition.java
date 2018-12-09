package operator.arithmetic;
import State.State;

public class Addition extends  BinaryOperator{
   public Addition(State state) {
      super(state);
   }

   @Override
   public void execute() {
      State state = getState();

      if(!isOperationDoable()){
         state.setError(true, "Impossible de faire l'addition");
         return;
      }

      double result = state.removeValue() + Double.parseDouble(state.getCurrentDisplay());

      state.addValue(result);
      state.setRemoveOldDisplay(true);
   }
}
