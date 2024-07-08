package PasswordGenerator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.security.SecureRandom;

public class PasswordFronted extends JFrame{

    private JTextField lengthField;
    private JTextArea passwordField;
    private JButton generateButton;

    private static final String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String lowerCase = "abcdefghijklmnopqrstuvwxyz";
    private static final String numbers = "0123456789";
    private static final String chacters = "!@#$%^&*()_+";

    public PasswordFronted() {
        setTitle("Password Generator");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10, 20));

        JLabel lengthLabel = new JLabel("Password Length:");
        lengthField = new JTextField();
        passwordField = new JTextArea();
        passwordField.setEditable(false);
        passwordField.setLineWrap(true);

        generateButton = new JButton("Generate Password");
        generateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generatePassword();
            }
        });

        panel.add(lengthLabel);
        panel.add(lengthField);
        panel.add(new JLabel("Password Generated:"));
        panel.add(passwordField);
        panel.add(generateButton);

        add(panel);
        setVisible(true);
    }

    private void generatePassword() {
        try {
            int len = Integer.parseInt(lengthField.getText());
            String characters = lowerCase + upperCase + numbers + chacters;
            SecureRandom random = new SecureRandom();
            StringBuilder password = new StringBuilder(len);

            for (int k = 0; k < len; k++) {
                int randomIndex = random.nextInt(characters.length());
                password.append(characters.charAt(randomIndex));
            }
             passwordField.setText(password.toString());
        } catch (NumberFormatException ex) {
        }
    }

    public static void main(String[] args) {

        new PasswordFronted();
    }
}