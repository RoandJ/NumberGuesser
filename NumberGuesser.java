import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.*;
import javax.swing.*;
import java.awt.Color;

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
        JButton giveUp, playAgain, guess;


        Color background = new Color(100, 149, 237);

        ImageIcon img = new ImageIcon("images/Vraagteken.png");
        //ImageIcon img2 = new ImageIcon("images/VraagtekenPoppetje.png");
        ImageIcon img2 = new ImageIcon("images/GuessMyNumbers.jpg");

        Font fontOne = new Font("Monospace", Font.BOLD, 30);
        Font fontTwo = new Font("Monospace", Font.BOLD, 20);

        frame.setTitle("Number Guesser!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(img.getImage());
        frame.setSize(1000, 600);
        frame.setResizable(false);
        frame.getContentPane().setBackground(background);
        frame.setLayout(null);

        textOne.setBounds(560, 80, 355, 60);
        textOne.setFont(fontOne);
        textOne.setBackground(background);
        textOne.setText("Guess my number game!");
        textOne.setEditable(false);

        textTwo.setBounds(560, 140, 330, 30);
        textTwo.setFont(fontTwo);
        textTwo.setBackground(background);
        textTwo.setText("Guess a number between 1 - 100: ");
        textTwo.setEditable(false);

        JLabel label = new JLabel(img2);
        label.setBounds(70, 120, 478, 399);

        

        frame.add(label);
        frame.add(textOne);
        frame.add(textTwo);
        frame.add(textfield);
        frame.setVisible(true);
    }
    
    
    public static void main(String args[]) {
        myFrame();
    }

}