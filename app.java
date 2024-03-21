import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class app {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        initializeComponents(frame);
        frame.setVisible(true);
    }

    private static void initializeComponents(JFrame frame) {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel firstNumberLabel = new JLabel("First Number:");
        JTextField firstNumber = new JTextField(10);
        JLabel secondNumberLabel = new JLabel("Second Number:");
        JTextField secondNumber = new JTextField(10);

        JButton tambah = new JButton("+");
        JButton kurang = new JButton("-");
        JButton kali = new JButton("*");
        JButton bagi = new JButton("/");

        JLabel result = new JLabel("Result:", SwingConstants.CENTER);
        result.setBorder(new EmptyBorder(5, 0, 5, 0));

        tambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateResult(firstNumber, secondNumber, result, '+');
            }
        });

        kurang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateResult(firstNumber, secondNumber, result, '-');
            }
        });

        kali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateResult(firstNumber, secondNumber, result, '*');
            }
        });

        bagi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateResult(firstNumber, secondNumber, result, '/');
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(firstNumberLabel, gbc);

        gbc.gridx = 1;
        panel.add(firstNumber, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(secondNumberLabel, gbc);

        gbc.gridx = 1;
        panel.add(secondNumber, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(tambah, gbc);

        gbc.gridx = 1;
        panel.add(kurang, gbc);

        gbc.gridx = 2;
        panel.add(kali, gbc);

        gbc.gridx = 3;
        panel.add(bagi, gbc);

        gbc.gridwidth = 4;
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(result, gbc);

        frame.add(panel, BorderLayout.CENTER);
    }

    private static void calculateResult(JTextField firstNumber, JTextField secondNumber, JLabel result, char operator) {
        try {
            int a = Integer.parseInt(firstNumber.getText());
            int b = Integer.parseInt(secondNumber.getText());
            int c = 0;
            switch (operator) {
                case '+':
                    c = a + b;
                    break;
                case '-':
                    c = a - b;
                    break;
                case '*':
                    c = a * b;
                    break;
                case '/':
                    if (b != 0) {
                        c = a / b;
                    } else {
                        result.setText("Error: Division by zero");
                        return;
                    }
                    break;
            }
            result.setText("Result: " + c);
        } catch (NumberFormatException ex) {
            result.setText("Error: Invalid input");
        }
    }
}
