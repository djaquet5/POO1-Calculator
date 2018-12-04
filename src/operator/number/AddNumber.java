/*
 -----------------------------------------------------------------------------------
 Laboratoire : Labo08
 Fichier     : AddNumber.java
 Auteur(s)   : Bouyiatiotis - Jaquet
 Date        : 27.112018

 Remarque(s) : 

 Compilateur : MinGW-g++ <x.y.z>
 -----------------------------------------------------------------------------------
 */
package operator.number;

import javax.swing.JTextField;
import operator.Operator;

/**
 * Permet de rajouter un nombre dans la chaine de JCalculator
 * 
 */
public class AddNumber extends Operator {
    
    private String val;
    
    public AddNumber(JTextField jNumber, String val) {
        super(jNumber);
        this.val = val;
    }
    
    /**
     * Rajoute le nombre voulue dans la chaîne jNumber
     */
    @Override
    public void execute() {

        if (!super.getJNumber().equals("0")) {
            super.setJNumber(super.getJNumber() + val);
        } else {
            super.setJNumber(val);
        }
        
    }
}
