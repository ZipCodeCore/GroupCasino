public class PrasanthiCard {
    public PrasanthiCard() {

    }

    private String drawBack() {
        return drawCard("~","P");
    }

    private String drawCard(String rank, String suit) {
        return String.format("+-----+\n" + "| %2s  |\n" +
                "| %2s  |\n" + "| %2s  |\n" +
                "+-----+", rank, suit, rank);
    }
}
