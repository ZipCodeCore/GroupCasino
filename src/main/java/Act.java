public enum Act {
    QUIT ("leave", "Quit", "quit", "q", "leave game", "end", "end game"),
    PLAY ("play game", "games", "game", "play a game", "play games", "Game", "Games", "Play Game"),
    BLACKJACK ("blackjack", "blackJack", "BlackJack", "BJ", "2"),
    POKER ("Texas Hold 'Em", "Poker", "poker", "3"),
    PALACE ("palace", "Palace"),
    CRAPS ("Dolio style craps", "craps", "DS craps", "Craps", "CRAPS", "Dolio"),
    CEELO("Cee lo", "CEE-lo", "CEELO", "ceelo", "cee-lo", "ceeLO", "ceelow", "cee-LOW"),
    LOUNGE("lounge", "Lounge", "lobby", "Lobby", "first");

    Act(String ...input) {}

}
