package util;

public class StringVariables {
    public static final String WELCOME = "Добро пожаловать в игру \"Виселица\", угадай слово!";
    public static final String PROMPT_LETTER = "Введите букву.";
    public static final String LIVES_REMAINING = "Оставшиеся жизни: ";

    // Game results
    public static final String WIN = "Поздравляем! Вы победили! Слово было: ";
    public static final String LOSS = "Вы проиграли! Загаданное слово: ";

    // Letter feedback
    public static final String LETTER_CORRECT = "Вы угадали букву!";
    public static final String LETTER_WRONG = "Вы не угадали букву.";
    public static final String LETTER_ALREADY_TRIED = "Вы уже вводили эту букву!";

    // Validation errors
    public static final String ERROR_EMPTY_INPUT = "Ошибка: Вы ничего не ввели!";
    public static final String ERROR_MULTIPLE_CHARS = "Ошибка: Введите только одну букву!";
    public static final String ERROR_NOT_CYRILLIC = "Ошибка: Введите букву на кириллице (А-Я, а-я)!";

    // Menu
    public static final String MENU_PROMPT = "Начать новую игру (Y) или выйти (N)?";
    public static final String MENU_YES = "Y";
    public static final String MENU_NO = "N";
    public static final String MENU_INVALID = "Некорректный ввод.";

    // Game display
    public static final String HIDDEN_LETTER = "_ ";

    // File errors
    public static final String ERROR_FILE_EMPTY = "The file is empty.";

    private StringVariables() {
        throw new UnsupportedOperationException("Utility class");
    }
}
