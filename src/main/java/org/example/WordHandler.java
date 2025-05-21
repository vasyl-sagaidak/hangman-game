package org.example;

public class WordHandler {

    public void print(String word, String resultingWord, int mistakes, String letters) {
        System.out.println("Загаданное слово из " + word.length() + " букв: [" + resultingWord + "]");
        System.out.println("Допущено ошибок: " + mistakes + " из " + Hangman.MAX_MISTAKES + " возможных.");
        System.out.println("Использованные буквы: " + letters);
    }

    public String encrypt(String word) {
        int len = word.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append("*");
        }
        return sb.toString();
    }
}
