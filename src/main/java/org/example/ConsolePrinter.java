package org.example;

public class ConsolePrinter {
    public static void welcomeMessage() {
        System.out.println("Добро пожаловать в игру \"Виселица\". " +
                "\nНачать новую игру: 1 \nПокинуть игру: 0");
        System.out.println("      ~#~      ");
    }

    public static void startNewGameMessage(int state) {
        System.err.println("Ваш выбор: " + state + ". Начинаем новую игру!");
    }

    public static void exitMessage(int state) {
        System.err.println("Ваш выбор: " + state + ". Вы вышли из игры.");
    }

    public static void letterInputRequestMessage() {
        System.out.println("Пожалуйста введите букву: ");
    }

    public static void letterMatchMessage() {
        System.out.println("Поздравляем! Вы угадали букву!");
        System.out.println("             ~#~              ");
    }

    public static void letterMisMatchMessage() {
        System.out.println("Вы ошиблись! Повезет в другой раз!");
    }

    public static void wrongInputMessage() {
        System.out.println("Неверный ввод! Сделайте выбор между 1 - " +
                "Новая игра / 0 - Выход");
    }

    public static void enteredLetterPrintToConsole(String input) {
        System.out.println("Вы ввели букву " + input);
    }

    public static void inputLengthExceedsOneMessage() {
        System.err.println("Ввод не должен превышать размер в один символ!");
    }

    public static void inputToBeCyrilicMessage() {
        System.err.println("Пожалуйста используйте кириллицу!");
    }

    public static void currentScoreMessage(
            String word, String resultingWord, int mistakes, String letters) {
        System.out.println("Загаданное слово из " + word.length()
                + " букв: [" + resultingWord + "]");
        System.out.println("Допущено ошибок: " + mistakes + " из "
                + Hangman.MAX_MISTAKES + " возможных.");
        System.out.println("Использованные буквы: " + letters);
    }

    public static void gameWinnerMessage() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("### ПОЗДРАВЛЯЕМ! ВЫ ОДЕРЖАЛИ ПОБЕДУ! ###");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("       ~~~~~~~~~~~~~~~~~~~~~~~~~~       ");
        System.out.println("            ~~~~~~~~~~~~~~~             ");
        System.out.println("               ~~~~~~~~~                ");
        System.out.println("                  ~#~                   ");
    }

    public static void gameOverMessage() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("#### ВЫ ПРОИГРАЛИ! ####");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("   ~~~~~~~~~~~~~~~~~   ");
        System.out.println("      ~~~~~~~~~~~      ");
        System.out.println("         ~~#~~         ");
        System.out.println("           ~           ");
    }
}
