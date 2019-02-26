package io.zipcoder.casino.CardGame.Cards;

public enum Face {

        ACE("A"),
        TWO("2"),
        THREE("3"),
        FOUR("4"),
        FIVE("5"),
        SIX("6"),
        SEVEN("7"),
        EIGHT("8"),
        NINE("9"),
        TEN("10"),
        JACK("J"),
        QUEEN("Q"),
        KING("K");

        String faceValue;

        private Face(String f){
                this.faceValue = f;
        }

        public String getFaceValue(){
                return faceValue;
        }
}



