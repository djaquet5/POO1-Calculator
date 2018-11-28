package operator;

import java.util.Stack;

public abstract class Operator {
   private Stack<Double> values;

   public Operator(Stack<Double> values){
      this.values = values;
   }

   public abstract void execute();
}
