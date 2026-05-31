package logic;

enum HangmanStage {
    STAGE8(8, """
            -------
            |
            |
            |
            |
            |
            """),
    STAGE7_6(7, """
            -------
            |     ()
            |
            |
            |
            |
            """),
    STAGE5(5, """
            -------
            |     (O)
            |
            |
            |
            |
            """),
    STAGE4(4, """
            -------
            |     (O)
            |      |
            |      |
            |
            |
            """),
    STAGE3(3, """
            -------
            |     (O)
            |    --|
            |      |
            |
            |
            """),
    STAGE2(2, """
            -------
            |     (O)
            |    --|--
            |      |
            |
            |
            """),
    STAGE1(1, """
            -------
            |     (O)
            |    --|--
            |      |
            |     /
            |
            """),
    STAGE0(0, """
            -------
            |     (O)
            |    --|--
            |      |
            |     / \\
            |
            """);

    private final int lives;
    private final String drawing;

    HangmanStage(int lives, String drawing) {
        this.lives = lives;
        this.drawing = drawing;
    }

    static String getDrawing(int lives) {
        for (HangmanStage stage : values()) {
            if (stage.lives == lives) {
                return stage.drawing;
            }
        }
        return STAGE7_6.drawing;
    }
}
