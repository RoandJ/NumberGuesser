import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.*;
import javax.swing.*;
import javax.swing.JComponent;


public class NumberGuesser {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 100;

    public static int randomNumber() {
        int temp;
        temp = (int) (Math.random() * MAX_NUMBER + MIN_NUMBER);
        return temp;
    }
    
    public static void myFrame() {

        JFrame frame = new JFrame();
        JTextField textfield = new JTextField();
        JTextField input = new JTextField();
        JTextArea textOne = new JTextArea();
        JTextArea textTwo = new JTextArea();

        ImageIcon img = new ImageIcon("images/Vraagteken.png");
        //JComponent ic = new JComponent();

        Font fontOne = new Font("Monospace", Font.BOLD, 30);
        Font fontTwo = new Font("Monospace", Font.BOLD, 20);

        frame.setTitle("Number Guesser!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(img.getImage());
        frame.setSize(1000, 600);
        frame.setResizable(false);
        frame.setLayout(null);

        /*textfield.setBounds(200, 50, 150, 50);
        textfield.setText("Test");*/

        textOne.setBounds(550, 80, 355, 60);
        textOne.setFont(fontOne);
        textOne.setText("Guess my number game!");
        textOne.setEditable(false);

        textTwo.setBounds(550, 140, 330, 30);
        textTwo.setFont(fontTwo);
        textTwo.setText("Guess a number between 1 - 100: ");
        textTwo.setEditable(false);

        frame.add(textOne);
        frame.add(textTwo);
        frame.add(textfield);
        frame.setVisible(true);

    }
    
    
    public static void main(String args[]) {
        myFrame();
    }

}