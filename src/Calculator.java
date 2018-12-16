/*
 -----------------------------------------------------------------------------------
 Laboratoire : Laboratoire 08
 Fichier     : Calculator.java
 Auteur(s)   : Bouyiatiotis - Jaquet
 Date        : 04.12.2018

 Remarque(s) :

 Compilateur : java 1.8.0_191
 -----------------------------------------------------------------------------------
 */

import java.util.*;
import operator.number.AddNumber;
import state.State;
import operator.Operator;
import operator.memory.*;
import operator.arithmetic.*;

/**
 * Permet de lancer la calculatrice en mode console
 */
public class Calculator {
   private State state = new State();
   private Map<String, Operator> operation;

   /**
    * Constructeur
    */
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

   /**
    * Execute la calculatrice
    */
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

   /**
    * Effectue l'opération entrée. Si il y a une erreur, on ne peut faire
    * que les opération CE ou C
    *
    * @param input   Opération entrée par l'utilisateur
    */
   private void makeOperation(String input){
      if(state.isError() && !input.equals("CE") && !input.equals("C"))
         return;

      operation.get(input).execute();
   }

   /**
    * Ajoute une valeur dans la pile. Si il ne s'agit pas d'un nombre,
    * On met une erreur dans la calculatrice
    *
    * @param input   Valeur entrée par l'utilisateur
    */
   private void addValues(String input){

      // On rentre de le catch si l'input n'est pas parsable en Double
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

   /**
    * Affiche l'erreur de la calculatrice
    */
   private void displayError(){
      if(state.isError()){
         System.out.println(state.getCurrentDisplay());
         System.out.println("Entrer 'CE' ou 'C' pour continuer à utiliser le programme.");
      }
   }

   /**
    * Affiche le contenu de la pile. Si la pile est vide, affiche "< empty stack >"
    */
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
