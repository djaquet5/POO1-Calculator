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

package state;
import java.util.Stack;

public class State {
    private Stack<Double> values = new Stack<>();
    private String currentDisplay = "0";
    private String memory;
    private boolean error = false;
    private boolean removeOldDisplay = false;

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
        values.push(val);
        setCurrentDisplay(val.toString());
    }

    public Double removeValue(){
        return values.pop();
    }
    
    /**
     * @brief   : Convertie la pile en un tableau d'Object
     * @return  : Object[] des éléments contenue dans la pile
     */
    public Double[] toTab(){
        int size = values.size();
        int i = size - 1;
        Double[] tab = new Double[size];

        for(Double o : values)
            tab[i--] = o;

        return tab;
    }
    
    /**
     * @brief   : Détermine si la pile est vide ou non
     * @return  : Boolean indiquant si la pile est vide ou non 
     *            True : Pile vide
     *            False: Pile non vide
     */
    public boolean isEmpty(){
        return values.empty();
    }

    public void clearValues() {
        while(!values.empty())
            values.pop();
    }

    public boolean isError(){
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public void setError(boolean error, String message){
        setError(error);
        setCurrentDisplay(message);
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public boolean isRemoveOldDisplay() {
        return removeOldDisplay;
    }

    public void setRemoveOldDisplay(boolean removeOldDisplay) {
        this.removeOldDisplay = removeOldDisplay;
    }
}
