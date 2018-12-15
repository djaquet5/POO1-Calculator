package operator.arithmetic;

import state.State;

public class SquareRoot extends UnaryOperator{

    public SquareRoot(State state) {
        super(state);
    }

   @Override
   public void execute() {
      State state = getState();
      
//      if(!isOperationDoable() || !Double.isNaN(value)) {
      if(!isOperationDoable()){
         state.setError(true, "Impossible d'obtenir la racine.");
         return;
      }

      Double value = Math.sqrt(Double.parseDouble(state.getCurrentDisplay()));

      state.setCurrentDisplay(String.valueOf(value));
      state.setRemoveOldDisplay(true);
   }

   @Override
   public boolean isOperationDoable() {
      return super.isOperationDoable() && Double.parseDouble(getState().getCurrentDisplay()) >= 0;
   }
}
