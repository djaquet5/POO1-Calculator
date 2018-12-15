   import java.util.*;

import operator.number.AddNumber;
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
      if(state.isError() && !input.equals("CE") && !input.equals("C"))
         return;

      operation.get(input).execute();
   }

   private void addValues(String input){
      try {
         Double number = Double.parseDouble(input);

         if(!state.getCurrentDisplay().equals("0")){
            Enter enter = new Enter(state);
            enter.execute();
         }

         AddNumber addNumber = new AddNumber(state, input);
         addNumber.execute();

      } catch(NumberFormatException e) {
         state.setError(true, "Impossible d'utiliser cette valeur.");
      }
   }

   private void displayError(){
      if(state.isError()){
         System.out.println(state.getCurrentDisplay());
         System.out.println("Entrer 'CE' ou 'C' pour continuer à utiliser le programme.");
      }
   }

   private void displayStack(){
      if(state.isEmpty() && state.getCurrentDisplay().equals("0")) {
         System.out.println("< empty stack >\n");
         return;
      }

      System.out.print(Double.parseDouble(state.getCurrentDisplay()) + " ");

      Double[] values = state.toTab();

      for(Double value : values)
         System.out.print(value + " ");

      System.out.println("\n");
   }

   public static void main(String args[]){
      new Calculator();
   }
}
