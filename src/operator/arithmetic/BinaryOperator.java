package operator.arithmetic;

import state.State;
import operator.Operator;

public abstract class BinaryOperator extends Operator {

   public BinaryOperator(State state){
      super(state);
   }

   @Override
   public boolean isOperationDoable() {
      return super.isOperationDoable() && !getState().isEmpty();
   }
}
