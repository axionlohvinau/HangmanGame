# Hangman Game

A robust implementation of the classic Hangman game in pure Java. The application runs entirely in the terminal and demonstrates clean code practices, structured logic separation, and user input validation.

**Core mechanics:**
- 8 attempts before game over
- Progressive ASCII hangman drawing
- Cyrillic letter validation
- Duplicate guess prevention

**Technical highlights:**
- Object-oriented design (Hangman model, Processor logic, utility classes)
- HashSet for O(1) duplicate checking
- Resource management with proper exception handling
- Configurable word list via external `.txt` file

**Game flow:**
Welcome → Show masked word → Player guesses → Update hangman state → Repeat until win/loss → Play again prompt
