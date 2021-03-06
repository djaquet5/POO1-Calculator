/*
 -----------------------------------------------------------------------------------
 Laboratoire : Laboratoire 08
 Fichier     : JCalculator.java
 Auteur(s)   : Bouyiatiotis - Jaquet
 Date        : 04.12.2018

 Remarque(s) : Nous avons changer l'ordre des appels à la méthode addOperatorButton
               afin de pouvoir nous y retrouver plus facilement

 Compilateur : java 1.8.0_191
 -----------------------------------------------------------------------------------
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import operator.*;
import operator.memory.*;
import operator.number.*;
import operator.arithmetic.*;
import state.State;

/**
 * Interface graphique d'une calculatrice
 */
public class JCalculator extends JFrame {
    // Tableau representant une pile vide
    private final String[] empty = {"< empty stack >"};

    // Zone de texte contenant la valeur introduite ou resultat courant
    private final JTextField jNumber = new JTextField("0");

    // Composant liste representant le contenu de la pile
    private final JList jStack = new JList(empty);

    // Contraintes pour le placement des composants graphiques
    private final GridBagConstraints constraints = new GridBagConstraints();
    
    private State state = new State();
    
    /*
     * Mise a jour de l'interface apres une operation (jList et jStack)
     */
    private void update() {
       if(state.getCurrentDisplay().compareTo("") != 0)
            jNumber.setText(state.getCurrentDisplay());
        else 
            jNumber.setText("0");
        
        if(!state.isEmpty())
            jStack.setListData(state.toTab());
        else
            jStack.setListData(empty);

    }

    /*
     * Ajout d'un bouton dans l'interface et de l'operation associee,
     * instance de la classe Operation, possedeant une methode execute()
     */
    private void addOperatorButton(String name, int x, int y, Color color,
            final Operator operator) {
        JButton b = new JButton(name);
        b.setForeground(color);
        constraints.gridx = x;
        constraints.gridy = y;
        getContentPane().add(b, constraints);

        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                operator.execute();
                update();
            }
        });
    }

    /*
     * Constructeur
     */
    public JCalculator() {
        super("JCalculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new GridBagLayout());

        // Contraintes des composants graphiques
        constraints.insets = new Insets(3, 3, 3, 3);
        constraints.fill = GridBagConstraints.HORIZONTAL;

        // Nombre courant
        jNumber.setEditable(false);
        jNumber.setBackground(Color.WHITE);
        jNumber.setHorizontalAlignment(JTextField.RIGHT);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 5;
        getContentPane().add(jNumber, constraints);
        constraints.gridwidth = 1; // reset width


        //---------------- memory ------------------------------------------------
        // Rappel de la valeur en memoire
        addOperatorButton("MR", 0, 1, Color.RED, new MemoryRecall(state));

        // Stockage d'une valeur en memoire
        addOperatorButton("MS", 1, 1, Color.RED, new MemoryStore(state));

        // Backspace
        addOperatorButton("<=", 2, 1, Color.RED, new BackSpace(state));

        // Mise a zero de la valeur courante + suppression des erreurs
        addOperatorButton("CE", 3, 1, Color.RED, new ClearError(state));

        // Comme CE + vide la pile
        addOperatorButton("C", 4, 1, Color.RED, new Clear(state));

        // Entree: met la valeur courante sur le sommet de la pile
        addOperatorButton("Ent", 4, 5, Color.RED, new Enter(state));

        //---------------- Fin memory --------------------------------------------


        //---------------- number ------------------------------------------------
        // Boutons 1-9
        for (int i = 1; i < 10; i++) {
            addOperatorButton(String.valueOf(i), (i - 1) % 3, 4 - (i - 1) / 3,
                    Color.BLUE, new AddNumber(state, String.valueOf(i)));
        }
        // Bouton 0
        addOperatorButton("0", 0, 5, Color.BLUE, new AddNumber(state, "0"));

        // Changement de signe de la valeur courante
        addOperatorButton("+/-", 1, 5, Color.BLUE, new ChangeSign(state));

        // Operateur point (chiffres apres la virgule ensuite)
        addOperatorButton(".", 2, 5, Color.BLUE, new Dot(state));

        //----------------- Fin number -------------------------------------------
        

        //----------------- aritmetic --------------------------------------------
        // Operateurs arithmetiques a deux operandes: /, *, -, +
        addOperatorButton("/", 3, 2, Color.RED, new Division(state));
        addOperatorButton("*", 3, 3, Color.RED, new Multiplication(state));
        addOperatorButton("-", 3, 4, Color.RED, new Substraction(state));
        addOperatorButton("+", 3, 5, Color.RED, new Addition(state));

        // Operateurs arithmetiques a un operande: 1/x, x^2, Sqrt
        addOperatorButton("1/x", 4, 2, Color.RED, new Reversion(state));
        addOperatorButton("x^2", 4, 3, Color.RED, new Square(state));
        addOperatorButton("Sqrt", 4, 4, Color.RED, new SquareRoot(state));

        //----------------- Fin aritmetic -----------------------------------------
        

        // Affichage de la pile
        JLabel jLabel = new JLabel("Stack");
        jLabel.setFont(new Font("Dialog", 0, 12));
        jLabel.setHorizontalAlignment(JLabel.CENTER);
        constraints.gridx = 5;
        constraints.gridy = 0;
        getContentPane().add(jLabel, constraints);

        jStack.setFont(new Font("Dialog", 0, 12));
        jStack.setVisibleRowCount(8);
        JScrollPane scrollPane = new JScrollPane(jStack);
        constraints.gridx = 5;
        constraints.gridy = 1;
        constraints.gridheight = 5;
        getContentPane().add(scrollPane, constraints);
        constraints.gridheight = 1; // reset height

        setResizable(false);
        pack();
    }

    /*
     * main()
     */
    public static void main(String args[]) {
        new JCalculator().setVisible(true);
    }
}
