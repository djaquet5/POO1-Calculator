package State;
import java.util.Stack;

public class State {
    private Stack<Double> values = new Stack<Double>();
    private String currentDisplay = "0";
    private Double memory;
    
    
    public String getCurrentDisplay(){
        return currentDisplay;
    }
    
    public void setCurrentDisplay(String val){
        currentDisplay = val;
    }
    
    public void addValue(Double val){
        values.push(val);
        setCurrentDisplay(val.toString());
    }
    
}
