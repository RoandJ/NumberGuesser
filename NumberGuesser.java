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
    JFrame frame;
    JButton giveUp, playAgain, guess;
    JTextField input, output;
    JTextArea textOne, textTwo, tries, highscore;

    public int randomNumber() {
        int number;
        number = (int) (Math.random() * MAX_NUMBER + MIN_NUMBER);
        return number;
    }

    int number = randomNumber();
    int numberOfTries;
    int numberOfHighscore;
    
    NumberGuesser() {

        frame = new JFrame();
        input = new JTextField();
        textOne = new JTextArea();
        textTwo = new JTextArea();
        output = new JTextField();
        tries = new JTextArea();
        highscore = new JTextArea();

        Color bg = new Color(100, 149, 237);

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
        frame.getContentPane().setBackground(bg);
        frame.setLayout(null);

        textOne.setBounds(560, 80, 355, 60);
        textOne.setFont(fontOne);
        textOne.setBackground(bg);
        textOne.setText("Guess my number game!");
        textOne.setEditable(false);

        textTwo.setBounds(560, 140, 330, 30);
        textTwo.setFont(fontTwo);
        textTwo.setBackground(bg);
        textTwo.setText("Guess a number between 1 - 100: ");
        textTwo.setEditable(false);

        tries.setBounds(140, 40, 180, 40);
        tries.setFont(fontThree);
        tries.setEditable(false);
        tries.setBackground(bg);
        tries.setText("Number of tries: " + numberOfTries);

        highscore.setBounds(330, 40, 180, 40);
        highscore.setFont(fontThree);
        highscore.setEditable(false);
        highscore.setBackground(bg);
        highscore.setText("Your highscore: " + numberOfHighscore);

        input.setBounds(670, 200, 90, 40);
        input.setFont(fontTwo);

        output.setBounds(580, 250, 275, 30);
        output.setFont(fontThree);
        output.setEditable(false);
        output.setBorder(null);
        output.setHorizontalAlignment(JTextField.CENTER);
        output.setBackground(bg);

        JLabel label = new JLabel(img2);
        label.setBounds(70, 120, 478, 399);

        giveUp = new JButton("Give up!");
        playAgain = new JButton("Play again!");
        guess = new JButton("Guess");

        giveUp.setBounds(600, 300, 100, 50);
        giveUp.addActionListener(this);
        giveUp.setFocusable(false);

        playAgain.setBounds(730, 300, 100, 50);
        playAgain.addActionListener(this);
        playAgain.setFocusable(false);

        guess.setBounds(650, 350, 130, 50);
        guess.addActionListener(this);
        guess.setFocusable(false);

        frame.add(tries);
        frame.add(highscore);
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
        int temp;

        if(e.getSource() == guess) {
            try {
            
                temp = Integer.parseInt(input.getText());
                if (temp < 1 || temp > 100) {
                    output.setText("That is not a number between 1 - 100!");
                } 
                else if (temp == number) {
                    output.setText("You guessed right, well done!");
                    numberOfTries++;
                    tries.setText("Number of tries: " + numberOfTries);
                    giveUp.setEnabled(false);
                    if(numberOfHighscore == 0) {
                        numberOfHighscore = numberOfTries;
                        highscore.setText("Your Highscore: " + numberOfHighscore);
                    }
                    if(numberOfTries < numberOfHighscore) {
                        numberOfHighscore = numberOfTries;
                        highscore.setText("Your Highscore: " + numberOfHighscore);
                    }
                }
                else if (temp != number) {
                    output.setText("You did not guess right, try again!");
                    numberOfTries++;
                    tries.setText("Number of tries: " + numberOfTries);
                }
            } 
            catch (Exception ex) {
                output.setText(" ");
            }
        }

        if(e.getSource() == playAgain) {
            try {
                input.setText("");
                output.setText("");
                number = randomNumber();
                System.out.println(number);
                numberOfTries = 0;
                tries.setText("Number of tries: " + numberOfTries);
                guess.setEnabled(true);
                giveUp.setEnabled(true);
            }
            catch (Exception ex){
                output.setText("");
            }
        }

        if(e.getSource() == giveUp) {
            try {
                output.setText("You gave up, the right number was: " + (int)number);
                guess.setEnabled(false);
            }
            catch (Exception ex) {
                output.setText("");
            }
        }
    }
    
    public static void main(String args[]) {
        NumberGuesser guesser = new NumberGuesser();
    }
}