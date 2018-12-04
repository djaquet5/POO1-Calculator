/*
 -----------------------------------------------------------------------------------
 Laboratoire : Labo08
 Fichier     : Dote.java
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
 * Ajoute un point dans la chaîne de JCalculator. Si un point s'y trouve déjà 
 * alors rien n'est rajouté.
 */
public class Dote extends Operator{
    private String dote;
    public Dote(JTextField jNumber, String val) {
        super(jNumber);
        this.dote = val;
    }

    @Override
    public void execute() {
        if(!super.getJNumber().contains("."))
            super.setJNumber(super.getJNumber() + dote);
    }
    
    
    
}
