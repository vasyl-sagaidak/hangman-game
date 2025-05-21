package org.example;

import java.util.Arrays;

public class Visualizer {
    private final String[][] display;

    public Visualizer() {
        display = new String[][] {
                {" "," "," "," "},
                {" "," "," "," "},
                {" "," "," "," "},
                {" "," "," "," "},
                {" "," "," "," "}
        };
    }

    private void draw(int mistakes) {
        switch (mistakes) {
            case 1: display[4][0] = "|";
                break;
            case 2: display[3][0] = "|";
                break;
            case 3: display[2][0] = "|";
                break;
            case 4: display[1][0] = "|";
                break;
            case 5: display[0][1] = "_";
                break;
            case 6: display[0][2] = "_";
                break;
            case 7: display[1][2] = "O";
                break;
            case 8: display[2][2] = "|";
                break;
            case 9: display[2][1] = "/";
                break;
            case 10: display[2][3] = "\\";
                break;
            case 11: display[3][2] = "|";
                break;
            case 12: display[4][1] = "/";
                break;
            case 13: display[4][3] = "\\";
                break;
        }
    }

    public void visualize(int mistakes) {
        draw(mistakes);
        String[][] displayHangman = display;
        for (int i = 0; i < displayHangman.length; i++) {
            System.out.println(Arrays.toString(displayHangman[i]));
        }
    }

}
