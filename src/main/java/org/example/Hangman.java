package org.example;

import java.util.Scanner;

public class Hangman {
    public static final int MAX_MISTAKES = 13;
    private final Vocabulary vocabulary;
    private final Visualizer gameVisualizer = new Visualizer();
    private final WordHandler wordHandler = new WordHandler();
    private final Scanner scanner = new Scanner(System.in);
    private int mistakes = 0;

    public Hangman(Vocabulary vocabulary) {
        this.vocabulary = vocabulary;
    }

    public void start() {
        while (true) {
            ConsolePrinter.welcomeMessage();
            int state = scanner.nextInt();
            if (state == 0) {
                ConsolePrinter.exitMessage(state);
                break;
            } else if (state == 1) {
                ConsolePrinter.startNewGameMessage(state);
                String word = vocabulary.getRandomNoun();
                String resultingWord = wordHandler.encrypt(word);
                String usedLetters = "";
                gameVisualizer.visualize(mistakes);
                ConsolePrinter.currentScoreMessage(word, resultingWord, mistakes, usedLetters);

                while (mistakes < MAX_MISTAKES) {
                    if (word.equalsIgnoreCase(resultingWord)) {
                        ConsolePrinter.gameWinnerMessage();
                        break;
                    }
                        ConsolePrinter.letterInputRequestMessage();
                        String userInput = scanner.next().toLowerCase();
                        if (inputChecker(userInput)) {
                            usedLetters += userInput;
                            ConsolePrinter.enteredLetterPrintToConsole(userInput);
                            if (word.contains(userInput)) {
                                ConsolePrinter.letterMatchMessage();
                                resultingWord = wordHandler.showOpenedLetters(word, resultingWord,userInput);
                            } else {
                                if (!resultingWord.contains(userInput)) {
                                    mistakes++;
                                }
                                if (mistakes == MAX_MISTAKES) {
                                    gameVisualizer.visualize(mistakes);
                                    ConsolePrinter.gameOverMessage();
                                    break;
                                }
                                ConsolePrinter.letterMisMatchMessage();
                            }
                            ConsolePrinter.currentScoreMessage(word, resultingWord, mistakes, usedLetters);
                            gameVisualizer.visualize(mistakes);
                        }
                }
            } else {
                ConsolePrinter.wrongInputMessage();
            }
        }
    }

    public boolean inputChecker(String input) {
        if (input.length() != 1 || input.equals(" ")) {
            ConsolePrinter.inputLengthExceedsOneMessage();
            return false;
        }
        char inputChar = input.toCharArray()[0];
        if (inputChar < 1072 || inputChar > 1103) {
            ConsolePrinter.inputToBeCyrilicMessage();
            return false;
        }
        return true;
    }
}
