package operator.arithmetic;

import State.State;
import operator.Operator;

public abstract class UnaryOperator extends Operator {

   /**
    * @param state : State don on fait référence pour les opérations
    * @brief : Constructeur de la classe Operator
    */
   public UnaryOperator(State state) {
      super(state);
   }
}
