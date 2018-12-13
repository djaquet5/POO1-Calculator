import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import state.State;
import operator.*;
import operator.memory.*;
import operator.number.*;
import operator.arithmetic.*;

public class Calculator {
    private State state = new State();
    private Map<String, Operator> operation;

    public Calculator(){
        this.operation = new HashMap<>();
        operation.put("+", new Addition(state));
        operation.put("-", new Substraction(state));
        operation.put("*", new Multiplication(state));
        operation.put("/", new Division(state));
    }
    
}
