import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Calculator extends JFrame implements ActionListener{

	private JButton button0;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton buttonPlus;
    private JButton buttonMinus;
    private JButton buttonEquals;
    private JButton buttonC;

    static JLabel text;

    String firstNumber;
    String secondNumber;
    String operation;

	public Calculator() {

	    this.setSize(450,600); 
        this.setTitle("Calculator");

        text = new JLabel("", SwingConstants.RIGHT);

        button0 = new JButton("0");
        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");
        buttonPlus = new JButton("+");
        buttonMinus = new JButton("-");
        buttonEquals = new JButton("=");
        buttonC = new JButton("C");

        button0.setPreferredSize(new Dimension(100, 100));
        button1.setPreferredSize(new Dimension(100, 100));
        button2.setPreferredSize(new Dimension(100, 100));
        button3.setPreferredSize(new Dimension(100, 100));
        button4.setPreferredSize(new Dimension(100, 100));
        button5.setPreferredSize(new Dimension(100, 100));
        button6.setPreferredSize(new Dimension(100, 100));
        button7.setPreferredSize(new Dimension(100, 100));
        button8.setPreferredSize(new Dimension(100, 100));
        button9.setPreferredSize(new Dimension(100, 100));
        buttonPlus.setPreferredSize(new Dimension(100, 100));
        buttonMinus.setPreferredSize(new Dimension(100, 100));
        buttonEquals.setPreferredSize(new Dimension(100, 100));
        buttonC.setPreferredSize(new Dimension(100, 100));

        text.setPreferredSize(new Dimension(400, 100));
        text.setFont(new Font("SansSerif", Font.PLAIN,40));

        this.getContentPane().add(text);

        this.getContentPane().add(button7);
        this.getContentPane().add(button8); 
        this.getContentPane().add(button9); 
        this.getContentPane().add(buttonPlus);

        this.getContentPane().add(button4);
        this.getContentPane().add(button5); 
        this.getContentPane().add(button6); 
        this.getContentPane().add(buttonMinus); 

        this.getContentPane().add(button1);
        this.getContentPane().add(button2); 
        this.getContentPane().add(button3); 
        this.getContentPane().add(buttonEquals); 

        this.getContentPane().add(button0); 
        this.getContentPane().add(buttonC); 

        button0.addActionListener(this);
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);
        button7.addActionListener(this);
        button8.addActionListener(this);
        button9.addActionListener(this);
        buttonPlus.addActionListener(this);
        buttonMinus.addActionListener(this);
        buttonEquals.addActionListener(this);
        buttonC.addActionListener(this);

        this.setLayout(new FlowLayout());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);
     
        firstNumber = secondNumber = operation = "";
    }

    public void actionPerformed(ActionEvent e) {
        

        if(text.getText().length()<=16)
        {
            text.setText(text.getText()+e.getActionCommand());

            String text = e.getActionCommand();
            
            if (text.charAt(0) >= '0' && text.charAt(0) <= '9')
            {
                if (operation.equals(""))
                {
                    firstNumber += text;
                }
                else
                {
                    secondNumber += text;
                }

                Calculator.text.setText(firstNumber + operation + secondNumber);
            }
            else
            {
                switch(text)
                {
                    case "+" :
                        if (operation.equals(""))
                        {
                            operation = "+";
                        }
                        else
                        {
                            firstNumber = equals(firstNumber, operation, secondNumber);
                            operation = "+";
                            secondNumber = "";
                        }
                        Calculator.text.setText(firstNumber + operation + secondNumber);
                    break;
                    case "-" :
                        if (operation.equals(""))
                        {
                            operation = "-";
                        }
                        else
                        {
                            firstNumber = equals(firstNumber, operation, secondNumber);
                            operation = "-";
                            secondNumber = "";
                        }
                        Calculator.text.setText(firstNumber + operation + secondNumber);
                    break;
                    case "=" :
                        if(!firstNumber.equals("") || !operation.equals("") || !secondNumber.equals(""))
                        {
                            Calculator.text.setText(equals(firstNumber, operation, secondNumber));
                        }
                        else if(!firstNumber.equals(""))
                        {
                            Calculator.text.setText(firstNumber);
                        }
                    break;
                    case "C":
                        Calculator.text.setText("");
                        firstNumber = operation = secondNumber = "";
                    break;
                    default :
                    
                    break;
                }
            }
            
            

        }
        else
        {
            text.setText("");
            firstNumber = operation = secondNumber = "";
        }
        
        
    }   

    public String equals(String firstNumber, String operation, String secondNumber)
    {
        int result = 0;
        switch(operation)
        {
            case "+":
                result = Integer.parseInt(firstNumber) + Integer.parseInt(secondNumber);
            break;
            case "-":
                result = Integer.parseInt(firstNumber) - Integer.parseInt(secondNumber);
            break;
        }

        return Integer.toString(result);
    }
    public static void main (String[] args){
        Calculator calc = new Calculator();
    }
}
