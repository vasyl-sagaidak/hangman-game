package org.example;

public class WordHandler {

    public String encrypt(String word) {
        int len = word.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append("*");
        }
        return sb.toString();
    }

    public String showOpenedLetters(String word, String resultingWord, String userInput) {
        char[] wordArray = word.toCharArray();
        char[] resultingChar = resultingWord.toCharArray();
        for (int i = 0; i < wordArray.length; i++) {
            if (String.valueOf(wordArray[i]).equals(userInput)) {
                resultingChar[i] = userInput.charAt(0);
            }
        }
        String recoupled = "";
        for (char c : resultingChar) {
            recoupled += c;
        }
        return recoupled;
    }
}
