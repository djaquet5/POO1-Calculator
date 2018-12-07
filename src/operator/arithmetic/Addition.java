package operator.arithmetic;
import State.State;
import java.util.Stack;
import operator.Operator;

public class Addition extends  BinaryOperator{
   public Addition(State state) {
      super(state);
   }

   @Override
   public void execute() {
      if(!isOperationDoable())
         throw new RuntimeException("Impossible de faire l'addition");

      State state = getState();
      double result = state.pop() + Double.parseDouble(state.getCurrentDisplay());

      state.push(result);
   }
}
