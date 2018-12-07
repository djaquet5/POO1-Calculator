package operator.arithmetic;
import State.State;
import java.util.Stack;
import operator.Operator;

public class Division extends BinaryOperator {

    public Division(State state) {
        super(state);
    }


   @Override
   public void execute() {
      if(!isOperationDoable())
         throw new RuntimeException("Impossible de faire la division");

      State state = getState();
      double result = state.pop() / Double.parseDouble(state.getCurrentDisplay());

      state.push(result);
   }

   @Override
   public boolean isOperationDoable() {
      return super.isOperationDoable() && !getState().getCurrentDisplay().equals("0");
   }
}
