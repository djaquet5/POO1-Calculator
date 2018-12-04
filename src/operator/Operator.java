package operator;
import java.util.Stack;
import javax.swing.JTextField;

public abstract class Operator {
    private JTextField jNumber;
    
    public Operator(JTextField jNumber){
        this.jNumber = jNumber;
    }
    
    public Operator(Stack<Double> values){
        
    }
    
    public abstract void execute();
    public void setJNumber(String val){
        jNumber.setText(val);
    }
    
    public String getJNumber(){
        return jNumber.getText();
    }
}
