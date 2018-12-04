/*
 -----------------------------------------------------------------------------------
 Laboratoire : Labo08
 Fichier     : ChangeSigne.java
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
 * Change le signe devant la valeur contenue dans la chaîne.
 */
public class ChangeSign extends Operator {

    public ChangeSign(JTextField jNumber) {
        super(jNumber);
    }
    
    /**
     * Alterne entre + et - selon le signe. Ne fait rien si la valeur est 0
     */
    @Override
    public void execute() {
        if(!super.getJNumber().equals("0")){
            if (!super.getJNumber().contains("-")) {
                super.setJNumber("-" + super.getJNumber());
            } else {
                super.setJNumber(super.getJNumber().replace("-", ""));
            }
        }
    }

}
