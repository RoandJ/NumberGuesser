import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;

public class NumberGuesser implements ActionListener {

    public final int MIN_NUMBER = 1;
    public final int MAX_NUMBER = 100;
    JButton giveUp, playAgain, guess;
    JTextField input;
    JTextField output;

    public int randomNumber() {
        int number;
        number = (int) (Math.random() * MAX_NUMBER + MIN_NUMBER);
        return number;
    }

    double number = randomNumber();
    
    NumberGuesser() {

        System.out.println(number);
        JFrame frame = new JFrame();
        input = new JTextField();
        JTextArea textOne = new JTextArea();
        JTextArea textTwo = new JTextArea();
        output = new JTextField();

        Color background = new Color(100, 149, 237);

        ImageIcon img = new ImageIcon("images/Vraagteken.png");
        ImageIcon img2 = new ImageIcon("images/GuessMyNumbers.jpg");

        Font fontOne = new Font("Monospace", Font.BOLD, 30);
        Font fontTwo = new Font("Monospace", Font.BOLD, 20);
        Font fontThree = new Font("Monospace", Font.BOLD, 15);

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

        input.setBounds(670, 200, 90, 40);
        input.setFont(fontTwo);

        output.setBounds(580, 250, 270, 30);
        output.setFont(fontThree);
        output.setEditable(false);
        output.setBackground(background);

        JLabel label = new JLabel(img2);
        label.setBounds(70, 120, 478, 399);

        giveUp = new JButton("Give up!");
        playAgain = new JButton("Play again!");
        guess = new JButton("Guess");

        giveUp.setBounds(600, 300, 100, 50);
        giveUp.addActionListener(this);
        giveUp.setFocusable(false);

        playAgain.setBounds(730, 300, 100, 50);
        guess.addActionListener(this);
        playAgain.setFocusable(false);

        guess.setBounds(650, 350, 130, 50);
        guess.addActionListener(this);
        guess.setFocusable(false);

        frame.add(output);
        frame.add(guess);
        frame.add(playAgain);
        frame.add(giveUp);
        frame.add(label);
        frame.add(textOne);
        frame.add(textTwo);
        frame.add(input);
        frame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        double temp;

        if(e.getSource() == guess) {
            try {
                temp = Double.parseDouble(input.getText());
                if(temp == number) {
                    output.setText("You guessed right, well done!");
                }
                if (temp != number) {
                    output.setText("You did not guess right, try again!");
                }
            } 
            catch (Exception ex) {
                output.setText(" ");
            }
        }
        
    }
    
    public static void main(String args[]) {
        NumberGuesser guesser = new NumberGuesser();
    }
}