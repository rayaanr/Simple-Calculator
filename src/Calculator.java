import javax.swing.*;
import java.awt.*;

public class Calculator extends JFrame {

    private double num1;
    private double num2;
    private String operator;
    private double result;

    Calculator(){
        final String[] input = {""};

        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300,400);
            frame.setLocationRelativeTo(null); // center the frame on the screen
            frame.setResizable(false);
        frame.setLayout(new BorderLayout()); // set the layout manager

        JPanel displayPane = new JPanel();
        displayPane.setPreferredSize(new Dimension(350,100));
        frame.add(displayPane, BorderLayout.NORTH);

        JTextField displayField = new JTextField();
        displayField.setPreferredSize(new Dimension(300, 80));
        displayField.setEditable(false);
            Font font = displayField.getFont();
            font = font.deriveFont(34.0f); //set font size to 24
            displayField.setFont(font);
        displayPane.add(displayField);

        JPanel inputPane = new JPanel();
        inputPane.setLayout(new GridLayout(5,4));
        frame.add(inputPane, BorderLayout.CENTER);

        String[] buttonLabels = {"AC", "Del", "%", "/", "1", "2", "3", "x", "4", "5", "6", "-", "7", "8", "9", "+", "+/-", "0", ".", "="};
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            Font buttonFont = button.getFont();
            buttonFont = buttonFont.deriveFont(20.0f); //set font size to 24
            button.setFont(buttonFont);

            switch (label) {
                case "AC" -> button.addActionListener(e -> {
                        input[0] = input[0].substring(0, 0);
                        displayField.setText(input[0]);
                        result = 0;
                    });
                case "Del" -> button.addActionListener(e -> {
                        if (input[0].length() > 0) {
                            input[0] = input[0].substring(0, input[0].length() - 1);
                            displayField.setText(input[0]);
                        }
                    });
                case "%" -> button.addActionListener(e -> {
                        num1 = Double.parseDouble(input[0]);
                        result = num1 / 100;
                        input[0] = "";
                        displayField.setText(String.valueOf(result));
                    });
                case "/" -> button.addActionListener(e -> setOperator("/", input, displayField));
                case "x" -> button.addActionListener(e -> setOperator("x", input, displayField));
                case "-" -> button.addActionListener(e -> setOperator("-", input, displayField));
                case "+" -> button.addActionListener(e -> setOperator("+", input, displayField));
                case "+/-" -> button.addActionListener(e -> {
                        if (!input[0].isEmpty() && input[0].contains("-")) {
                            input[0] = input[0].replace("-", "");
                        } else if (!input[0].isEmpty() ) {
                            input[0] = "-" + input[0];
                        }
                        displayField.setText(input[0]);
                    });
                case "=" -> button.addActionListener(e -> {
                        num2 = Double.parseDouble(input[0]);
                        switch (operator){
                            case "/" -> result = num1 / num2;
                            case "x" -> result = num1 * num2;
                            case "-" -> result = num1 - num2;
                            case "+" -> result = num1 + num2;
                        }
                        displayField.setText(String.valueOf(result));
                    });
                case "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "." ->
                    button.addActionListener(e -> {
                    input[0] += button.getText();
                    displayField.setText(input[0]);
                });
            }
            inputPane.add(button);
        }
        frame.setVisible(true);
    }

    public void setOperator(String operator, String[] input, JTextField field) {
        if(result != 0) {
            num1 = result;
        } else {
            num1 = Double.parseDouble(input[0]);
        }
        this.operator = operator;
        input[0] = "";
        field.setText(input[0]);
    }

}
