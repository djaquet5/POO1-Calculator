package operator.arithmetic;

import State.State;
import operator.Operator;

public abstract class BinaryOperator extends Operator {

   public BinaryOperator(State state){
      super(state);
   }

   @Override
   public boolean isOperationDoable() {
      return super.isOperationDoable() && !getState().empty();
   }
}
