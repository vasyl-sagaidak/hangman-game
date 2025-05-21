package org.example;

import java.security.SecureRandom;
import java.util.Scanner;

public class Hangman {
    public static final int MAX_MISTAKES = 13;
    private final Vocabulary vocabulary;
    private final Visualizer gameVisualizer = new Visualizer();
    private final WordHandler wordHandler = new WordHandler();
    private final Scanner sc = new Scanner(System.in);
    private final SecureRandom random = new SecureRandom();
    private int mistakes = 0;
    private String resultingWord;

    public Hangman(Vocabulary vocabulary) {
        this.vocabulary = vocabulary;
    }

    public void start() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Добро пожаловать в игру \"Виселица\". " +
                    "\nНачать новую игру: 1 \nПокинуть игру: 0");
            System.out.println("---");
            int state = scanner.nextInt();
            if (state == 0) {
                System.err.println("Ваш выбор: " + state + ". Вы вышли из игры.");
                break;
            } else if (state == 1) {
                String usedLetters = "";
                System.err.println("Ваш выбор: " + state + ". Начинаем новую игру!");
                String word = vocabulary.getRandomNoun();
                resultingWord = wordHandler.encrypt(word);
                gameVisualizer.visualize(mistakes);
                wordHandler.print(word,resultingWord,mistakes, usedLetters);

                while (mistakes < MAX_MISTAKES) {
                    if (word.equalsIgnoreCase(resultingWord)) {
                        System.out.println("----------------------------------------");
                        System.out.println("### ПОЗДРАВЛЯЕМ! ВЫ ОДЕРЖАЛИ ПОБЕДУ! ###");
                        System.out.println("----------------------------------------");
                        System.out.println("       --------------------------       ");
                        System.out.println("            ---------------             ");
                        System.out.println("               ---------                ");
                        System.out.println("                  ---                   ");
                        break;
                    }
                        System.out.println("Пожалуйста введите букву: ");
                        String userInput = sc.next().toLowerCase();
                        if (inputChecker(userInput)) {
                            usedLetters += userInput;
                            System.out.println("Вы ввели букву " + userInput);
                            if (word.contains(userInput)) {

                                System.out.println("Поздравляем! Вы угадали букву!" );

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
                                resultingWord = recoupled;
                                wordHandler.print(word,resultingWord,mistakes, usedLetters);
                                gameVisualizer.visualize(mistakes);

                            } else {
                                if (++mistakes == MAX_MISTAKES) {
                                    gameVisualizer.visualize(mistakes);
                                    System.out.println("-----------------------");
                                    System.out.println("#### ВЫ ПРОИГРАЛИ! ####");
                                    System.out.println("-----------------------");
                                    System.out.println("   -----------------   ");
                                    System.out.println("      -----------      ");
                                    System.out.println("         -----         ");
                                    System.out.println("           -           ");
                                    break;
                                }
                                System.out.println("Вы ошиблись! Повезет в другой раз!");
                                wordHandler.print(word,resultingWord,mistakes, usedLetters);
                                gameVisualizer.visualize(mistakes);
                            }
                        }
                }
            } else {
                System.out.println("Неверный ввод! Сделайте выбор между 1 - Новая игра / 0 - Выход");
            }
        }
    }

    public boolean inputChecker(String input) {
        // 224 - 255
        if (input.length() != 1 || input.equals(" ")) {
            System.err.println("Ввод не должен превышать размер в один символ!");
            return false;
        }
        char inputChar = input.toCharArray()[0];
        if (inputChar < 1072 || inputChar > 1103) {
            System.err.println("Пожалуйста используйте кириллицу!");
            return false;
        }
        return true;
    }
}
