package org.example;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public final class Vocabulary {
    private static final List<String> words = new ArrayList<>();
    private final SecureRandom random = new SecureRandom();

    public Vocabulary() {
        words.add("трактор");
        words.add("паяльник");
        words.add("фонарик");
        words.add("компас");
        words.add("молоток");
        words.add("косточка");
        words.add("журнал");
        words.add("кирпич");
        words.add("штанга");
        words.add("автобус");
        words.add("рюкзак");
        words.add("рубанок");
        words.add("свисток");
        words.add("кувшин");
        words.add("бинокль");
        words.add("комната");
        words.add("планшет");
        words.add("двигатель");
        words.add("пейзаж");
        words.add("словарь");
        words.add("зонтик");
        words.add("ласточка");
        words.add("прилавок");
        words.add("табурет");
        words.add("мотоблок");
        words.add("палатка");
        words.add("термос");
        words.add("балкон");
        words.add("копилка");
        words.add("пробирка");
        words.add("домино");
        words.add("автобус");
        words.add("ластик");
        words.add("солдат");
        words.add("монитор");
        words.add("собака");
        words.add("личность");
        words.add("программа");
        words.add("обьект");
        words.add("конфета");
        words.add("шаурма");
        words.add("крекер");
    }

    public String getRandomNoun() {
        return words.get(random.nextInt(42));
    }
}
