package logic;

import models.Hangman;
import util.StringVariables;
import util.RandomWordPicker;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Processor {
    private RandomWordPicker randomWordPicker;
    private Scanner scanner = new Scanner(System.in);
    private String word;
    private Set<Character> triedLetters = new HashSet<>();
    private Hangman hangman = new Hangman();
    private final String filePath = "words.txt";

    public Processor() {
        try {
            randomWordPicker = new RandomWordPicker(filePath);
            word = randomWordPicker.getRandomWord();
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
        }
    }

    public void run() {
        System.out.println(StringVariables.WELCOME);
        while (hangman.getLives() > 0 && !hangman.isPlayerWon()) {
            printWord();
            System.out.println(StringVariables.LIVES_REMAINING + hangman.getLives());
            System.out.println(StringVariables.PROMPT_LETTER);
            processPlayerInput();
            System.out.println(HangmanStage.getDrawing(hangman.getLives()));
            updateWinStatus();
        }

        if (hangman.isPlayerWon()) {
            System.out.println(StringVariables.WIN + word);
        } else {
            System.out.println(StringVariables.LOSS + word);
        }
        scanner.close();
    }

    private void printWord() {
        for (char character : word.toCharArray()) {
            if (triedLetters.contains(character)) {
                System.out.print(character);
            } else {
                System.out.print(StringVariables.HIDDEN_LETTER);
            }
        }
        System.out.println();
    }

    private void processPlayerInput() {
        String input = scanner.nextLine().trim().toLowerCase();

        if (!isValidCyrillicInput(input)) {
            return;
        }

        char letter = input.charAt(0);

        if (triedLetters.contains(letter)) {
            System.out.println(StringVariables.LETTER_ALREADY_TRIED);
            return;
        }

        triedLetters.add(letter);

        if (word.indexOf(letter) >= 0) {
            System.out.println(StringVariables.LETTER_CORRECT);
        } else {
            System.out.println(StringVariables.LETTER_WRONG);
            hangman.setLives(hangman.getLives() - 1);
        }
    }

    private boolean isValidCyrillicInput(String input) {
        if (input == null || input.isEmpty()) {
            System.out.println(StringVariables.ERROR_EMPTY_INPUT);
            return false;
        }

        if (input.length() != 1) {
            System.out.println(StringVariables.ERROR_MULTIPLE_CHARS);
            return false;
        }

        char letter = input.charAt(0);

        boolean isCyrillic = (letter >= '\u0410' && letter <= '\u042F') ||
                (letter >= '\u0430' && letter <= '\u044F') ||
                letter == '\u0401' ||
                letter == '\u0451';

        if (!isCyrillic) {
            System.out.println(StringVariables.ERROR_NOT_CYRILLIC);
            return false;
        }

        return true;
    }

    private void updateWinStatus() {
        boolean allGuessed = true;
        for (char character : word.toCharArray()) {
            if (!triedLetters.contains(character)) {
                allGuessed = false;
                break;
            }
        }
        hangman.setPlayerWon(allGuessed);
    }
}
