import java.util.*;
import state.State;
import operator.*;
import operator.memory.*;
import operator.arithmetic.*;

public class Calculator {
    private State state = new State();
    private Map<String, Operator> operation;

    public Calculator(){
        this.operation = new HashMap<>();
        // Arithmétique
        operation.put("+", new Addition(state));
        operation.put("-", new Substraction(state));
        operation.put("*", new Multiplication(state));
        operation.put("/", new Division(state));
        operation.put("1/x", new Reversion(state));
        operation.put("x^2", new Square(state));
        operation.put("sqrt", new SquareRoot(state));

        // Mémoire
        operation.put("MR", new MemoryRecall(state));
        operation.put("MS", new MemoryStore(state));

        // Affichage
       operation.put("C", new Clear(state));
       operation.put("CE", new ClearError(state));

       executeCalculator();
    }

   private void executeCalculator(){
      String input;
      Scanner reader = new Scanner(System.in);

      do {
         input = reader.nextLine();

         if(input.equals("exit"))
            break;

         if(operation.containsKey(input))
            makeOperation(input);
         else
            addValues(input);

         if(state.isError())
            displayError();
         else
            displayStack();

      } while (true);

      reader.close();
   }

   private void makeOperation(String input){
      operation.get(input).execute();

      if(!state.isError() || input.equals("CE"))
         state.addValue(Double.parseDouble(state.getCurrentDisplay()));
   }

   private void addValues(String input){
      try {
         Double number = Double.parseDouble(input);

         if(!state.isRemoveOldDisplay())
            state.addValue(Double.parseDouble(state.getCurrentDisplay()));

         state.setCurrentDisplay(input);

      } catch(NumberFormatException e) {
         state.setError(true, "Impossible d'utiliser cette valeur.");
      }
   }

   private void displayError(){
      if(state.isError()){
         System.out.println(state.getCurrentDisplay());
         System.out.println("Entrer 'CE' pour continuer à utiliser le programme.");
      }
   }

   private void displayStack(){
      Double[] values = state.toTab();

      System.out.print(Double.parseDouble(state.getCurrentDisplay()) + " ");

      for(Double value : values)
         System.out.print(value + " ");

      System.out.println("\n");
   }

   public static void main(String args[]){
      new Calculator();
   }
}
