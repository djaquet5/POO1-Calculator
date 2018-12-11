package operator.arithmetic;

import state.State;

public class SquareRoot extends UnaryOperator{

    public SquareRoot(State state) {
        super(state);
    }

   @Override
   public void execute() {
      State state = getState();
      Double value = Double.parseDouble(state.getCurrentDisplay());
      
      if(!isOperationDoable() || !Double.isNaN(value)) {
         state.setError(true, "Impossible d'obtenir la racine");
         return;
      }
      
      value = Math.sqrt(value);
      state.setCurrentDisplay(value.toString());
      state.setRemoveOldDisplay(true);
   }
}
