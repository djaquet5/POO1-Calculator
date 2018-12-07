/*
 -----------------------------------------------------------------------------------
 Laboratoire : Labo08
 Fichier     : State.java
 Auteur(s)   : Bouyiatiotis - jaquet
 Date        : 04.12.2018

 Remarque(s) :

 Compilateur : MinGW-g++ <x.y.z>
 -----------------------------------------------------------------------------------
 */

package State;
import java.util.Stack;

public class State {
    private Stack<Double> values = new Stack<>();
    private String currentDisplay = "0";
    private String memory;
    private boolean error = false;

    /**
     * @brief   : Permet de récupérer ce qui se toruve dans currentDisplay
     * @return  : String du currentDisplay
     */
    public String getCurrentDisplay(){
        return currentDisplay;
    }
    
    /**
     * @brief       : Permet de changer la valeur contenue dans current
     *                display
     * @param val   : String de la nouvelle valeur pour currentDisplay
     */
    public void setCurrentDisplay(String val){
        currentDisplay = val;
    }
    
    /**
     * @brief       : Ajoute une valeur à la pile en front
     * @param val   : Double de la valeur à ajouter dans la pile
     */
    public void addValue(Double val){
        values.add(0, val);
        setCurrentDisplay(val.toString());
    }
    
    /**
     * @brief   : Convertie la pile en un tableau d'Object
     * @return  : Object[] des éléments contenue dans la pile
     */
    public Double[] toTab(){
        Double[] tab = new Double[values.capacity()];
        int i = 0;

        for(Double o : values){
            tab[i] = o;
            ++i;
        }

        return tab;
    }
    
    /**
     * @brief   : Détermine si la pile est vide ou non
     * @return  : Boolean indiquant si la pile est vide ou non 
     *            True : Pile vide
     *            False: Pile non vide
     */
    public boolean empty(){
        return values.empty();
    }

    public Double pop(){
        return values.pop();
    }

    public void push(double value){
        values.push(value);
    }

    public boolean isError(){
        return error;
    }
}
