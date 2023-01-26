import javax.swing.*;
import java.awt.*;

public class Calculator extends JFrame {

    static double num1;
    static double num2;
    static String operator;
    static double result;

    public static void main(String[] args) {

        final String[] input = {""};

        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,400);
        frame.setLocationRelativeTo(null); // center the frame on the screen
        frame.setResizable(false);
        frame.setLayout(new BorderLayout()); // set the layout manager

        JPanel displayPane = new JPanel();
        displayPane.setBackground(Color.BLUE);
        displayPane.setPreferredSize(new Dimension(350,100));
        frame.add(displayPane, BorderLayout.NORTH);

        JTextField displayField = new JTextField();
        displayField.setPreferredSize(new Dimension(300, 50));
        displayPane.add(displayField);

        JPanel inputPane = new JPanel();
        inputPane.setBackground(Color.CYAN);
        inputPane.setLayout(new GridLayout(5,4));
        frame.add(inputPane, BorderLayout.CENTER);

//        String[] buttonLabels = {"AC", "Del", "%", "/", "1", "2", "3", "x", "4", "5", "6", "-", "7", "8", "9", "+", "+/-", "0", ".", "="};
//        for (String label : buttonLabels) {
//            JButton button = new JButton(label);
//            if(label.matches("\\d")){
//                button.addActionListener(e -> {
//                    displayField.setText(button.getText());
//                });
//            }
//            inputPane.add(button);
//        }

        JButton allClear = new JButton("AC");
        allClear.addActionListener(e -> {
            input[0] = input[0].substring(0,0);
            displayField.setText(input[0]);
        });
        inputPane.add(allClear);

        JButton deleteBtn = new JButton("Del");
        deleteBtn.addActionListener(e -> {
            if (input[0].length() > 0) {
            input[0] = input[0].substring(0, input[0].length() - 1);
            displayField.setText(input[0]);
            }
        });
        inputPane.add(deleteBtn);

        JButton percentageBtn = new JButton("%");
        percentageBtn.addActionListener(e -> {
        });
        inputPane.add(percentageBtn);

        JButton divideBtn = new JButton("/");
        divideBtn.addActionListener(e -> {
            num1 = Double.parseDouble(input[0]);
            operator = "/";
            input[0] = input[0].substring(0,0);
            displayField.setText(input[0]);
        });
        inputPane.add(divideBtn);

        for (int i = 1; i <= 3; i++) {
            JButton button = new JButton(String.valueOf(i));
            button.addActionListener(e -> {
                input[0] += button.getText();
                displayField.setText(input[0]);
            });
            inputPane.add(button); // add the button to the panel
        }

        JButton multipleBtn = new JButton("x");
        multipleBtn.addActionListener(e -> {
            num1 = Double.parseDouble(input[0]);
            operator = "x";
            input[0] = input[0].substring(0,0);
            displayField.setText(input[0]);
        });
        inputPane.add(multipleBtn);

        for (int i = 4; i <= 6; i++) {
            JButton button = new JButton(String.valueOf(i));
            button.addActionListener(e -> {
                input[0] += button.getText();
                displayField.setText(input[0]);
            });
            inputPane.add(button); // add the button to the panel
        }

        JButton minusBtn = new JButton("-");
        minusBtn.addActionListener(e -> {
            num1 = Double.parseDouble(input[0]);
            operator = "-";
            input[0] = input[0].substring(0,0);
            displayField.setText(input[0]);
        });
        inputPane.add(minusBtn);

        for (int i = 7; i <= 9; i++) {
            JButton button = new JButton(String.valueOf(i));
            button.addActionListener(e -> {
                input[0] += button.getText();
                displayField.setText(input[0]);
            });
            inputPane.add(button); // add the button to the panel
        }
        JButton plusBtn = new JButton("+");
        plusBtn.addActionListener(e -> {
            num1 = Double.parseDouble(input[0]);
            operator = "+";
            input[0] = input[0].substring(0,0);
            displayField.setText(input[0]);
        });
        inputPane.add(plusBtn);

        JButton plusMinusBtn = new JButton("+/-");
        inputPane.add(plusMinusBtn);

        JButton zeroBtn = new JButton("0");
        zeroBtn.addActionListener(e -> {
            input[0] += zeroBtn.getText();
            displayField.setText(input[0]);
        });
        inputPane.add(zeroBtn);

        JButton dotBtn = new JButton(".");
        dotBtn.addActionListener(e -> {
            input[0] += dotBtn.getText();
            displayField.setText(input[0]);
        });
        inputPane.add(dotBtn);

        JButton equalBtn = new JButton("=");
        equalBtn.addActionListener(e -> {
            num2 = Double.parseDouble(input[0]);
            switch (operator){
                case "/" -> result = num1 / num2;
                case "x" -> result = num1 * num2;
                case "-" -> result = num1 - num2;
                case "+" -> result = num1 + num2;
            }
            displayField.setText(String.valueOf(result));
        });
        inputPane.add(equalBtn);




        //frame.pack(); // adjust the size of the frame to fit the buttons
        frame.setVisible(true);
    }
}
