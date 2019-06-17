public class PrasanthiCard {
    public PrasanthiCard() {

    }

    private static String drawBack() {
        return "+-----+\n" + "||\n" +
                "|  ~  |\n" + "|  P  |\n" +
                "+-----+";
        //24c5
    }

    public static String drawCard(Rank rank, Suit suit) {
        return String.format("+-----+\n" + "|%s|\n" +
                "|%2s|\n" + "|%s|\n" +
                "+-----+", rank.getRankImage(), suit.getSuitImage(), rank.getRankImage());
    }

    private static String drawFirstCardRow() {
        return "  +------+  ";
    }
    private static String drawRankCardRow(String rankImage) {
        return String.format("  |  %s  |  ", rankImage);
    }
    private static String drawSuitCardRow(String suitImage) {
        return String.format("  |  %2s |  ", suitImage);
    }

    public static void drawAllCards() {
        for(Rank rank : Rank.values()) System.out.print(drawFirstCardRow());
        System.out.println();
        for(Rank rank : Rank.values()) System.out.print(drawRankCardRow(rank.getRankImage()));
        System.out.println();
        for(Rank rank : Rank.values()) System.out.print(drawSuitCardRow(Suit.HEART.getSuitImage()));
        System.out.println();
        for(Rank rank : Rank.values()) System.out.print(drawRankCardRow(rank.getRankImage()));
        System.out.println();
        for(Rank rank : Rank.values()) System.out.print(drawFirstCardRow());

//        System.out.println(drawBack());
   }
//
//
//
//            System.out.println(drawFirstCardRow());

}
