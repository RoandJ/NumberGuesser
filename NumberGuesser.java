import javax.swing.JFrame;
import javax.swing.JTextField;

public class NumberGuesser {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 100;

    public static int randomNumber() {
        int temp;
        temp = (int) (Math.random() * MAX_NUMBER + 1);
        return temp;
    }
    
    public static void myFrame() {
        JFrame frame = new JFrame();
        JTextField textfield = new JTextField();
        JTextField input = new JTextField();

        frame.setTitle("Number Guesser!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setResizable(false);
        frame.setLayout(null);

        textfield.setBounds(150, 50, 150, 50);
        textfield.setText("Test");

        frame.add(textfield);
        frame.setVisible(true);

    }
    
    
    public static void main(String args[]) {
        myFrame();
    }

}