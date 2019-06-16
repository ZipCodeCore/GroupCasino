public enum Act {

    QUIT("leave", "end", "quit", "q", "leave game", "end game"),
    PLAY("play game", "games", "game", "play a game", "play games", "gamble"),
    BLACKJACK("blackjack", "bj", "2"),
    POKER("Texas Hold 'em", "poker", "3"),
    PALACE("palace", "1"),
    CRAPS("craps", "dolio style craps", "dolio-style craps", "ds craps", "dolio"),
    CEELO("cee lo", "cee-lo", "ceelow", "cee-low", "ceelo"),
    DRINK("drink", "get a drink", "bar", "water"),
    EAT("eat", "get a bite to eat", "food", "restaurant", "grub", "chow", "dinner", "snacks"),
    LOUNGE("lounge", "lobby", "restroom", "rest room", "resting room");

    private String[] inputPossibilities;

    Act(String ...input) {
        inputPossibilities = input;
    }


    public String[] getInputPossibilities() {
        return inputPossibilities;
    }

}
