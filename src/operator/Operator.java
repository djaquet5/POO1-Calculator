package operator;
import State.State;
import java.util.Stack;
import javax.swing.JTextField;
import State.*;

public abstract class Operator {
    private State state;
    
    public Operator(State state){
        this.state = state;
    }
    
    public abstract void execute();
    
    public State getState(){
        return state;
    }

}
