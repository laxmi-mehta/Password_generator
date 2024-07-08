package PasswordGenerator;

import java.security.SecureRandom;

public class PasswordBackend {

    private static final String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String lowerCase = "abcdefghijklmnopqrstuvwxyz";
    private static final String numbers = "0123456789";
    private static final String chacters = "!@#$%^&*()_+";

    public static String generatePassword(int length) {
        String characters = lowerCase + upperCase + numbers + chacters;
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            password.append(characters.charAt(randomIndex));
        }

        return password.toString();
    }

    public static void main(String[] args) {
        int passwordLength = 20;
        String generatedPassword = generatePassword(passwordLength);
        System.out.println("Password Generated: " + generatedPassword);
    }
}
