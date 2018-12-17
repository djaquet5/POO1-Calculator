/*
 -----------------------------------------------------------------------------------
 Laboratoire : Laboratoire 08
 Fichier     : State.java
 Auteur(s)   : Bouyiatiotis - Jaquet
 Date        : 04.12.2018

 Remarque(s) :

 Compilateur : java 1.8.0_191
 -----------------------------------------------------------------------------------
 */

package state;

import java.util.Stack;

/**
 * Classe représentant l'état d'une calculatrice
 */
public class State {
    private Stack<Double> values = new Stack<>();
    private String currentDisplay = "0";
    private String memory;
    private boolean error = false;
    private boolean removeOldDisplay = false;

    /**
     * Permet de récupérer ce qui se trouve dans currentDisplay
     * @return      String du currentDisplay
     */
    public String getCurrentDisplay(){
        return currentDisplay;
    }

    /**
     * Permet de changer la valeur contenue dans current display
     *
     * @param value     String de la nouvelle valeur pour currentDisplay
     */
    public void setCurrentDisplay(String value){
        currentDisplay = value;
    }
    
    /**
     * Ajoute une valeur à la pile en front
     * @param value     Valeur en Double à ajouter dans la pile
     */
    public void addValue(Double value){
        values.push(value);
        setCurrentDisplay(String.valueOf(value));
    }

    /**
     * Enlève le premier Element de la pile
     * @return      Premier élément de la pile
     */
    public Double removeValue(){
        return values.pop();
    }
    
    /**
     * Convertit la pile en un tableau de Double
     * @return  : Double[] des éléments contenu dans la pile
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
     * Détermine si la pile est vide ou non
     * @return      Boolean indiquant si la pile est vide ou non
     *              True  : Pile vide
     *              False : Pile non vide
     */
    public boolean isEmpty(){
        return values.empty();
    }

    /**
     * Vide la pile
     */
    public void clearValues() {
        values.clear();
    }

    /**
     * Indique si l'état est en erreur ou non
     * @return      Boolean indiquant s'il y a une erreur
     */
    public boolean isError(){
        return error;
    }

    /**
     * Permet de définir s'il y a une erreur
     *
     * @param error     Valeur de l'erreur
     */
    public void setError(boolean error) {
        this.error = error;
    }

    /**
     * Permet de définir s'il y a une erreur et le message d'erreur
     *
     * @param error     Valeur de l'erreur
     * @param message   Message d'erreur
     */
    public void setError(boolean error, String message){
        setError(error);
        setCurrentDisplay(message);
    }

    /**
     * Retourne la valeur de la mémoire
     *
     * @return      Valeur contenue dans la mémoire
     */
    public String getMemory() {
        return memory;
    }

    /**
     * Définit la valeur de la mémoire
     * @param memory    Nouvelle valeur de la mémoire
     */
    public void setMemory(String memory) {
        this.memory = memory;
    }

    /**
     * Permet de déterminer si on doit écraser la valeur de currentDisplay
     *
     * @return  True si on doit écraser la valeur de currentDisplay
     *          False sinon
     */
    public boolean isRemoveOldDisplay() {
        return removeOldDisplay;
    }

    /**
     * Permet de définir si la valeur de currentDisplay doit être écrasée
     *
     * @param removeOldDisplay  Boolean définissant si currentDisplay doit être écrasé
     */
    public void setRemoveOldDisplay(boolean removeOldDisplay) {
        this.removeOldDisplay = removeOldDisplay;
    }
}
