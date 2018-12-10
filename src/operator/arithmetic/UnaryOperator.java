package operator.arithmetic;

import state.State;
import operator.Operator;

public abstract class UnaryOperator extends Operator {

   /**
    * @param state : state don on fait référence pour les opérations
    * @brief : Constructeur de la classe Operator
    */
   public UnaryOperator(State state) {
      super(state);
   }
}
