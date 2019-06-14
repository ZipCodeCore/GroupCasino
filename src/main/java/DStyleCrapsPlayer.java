public class DStyleCrapsPlayer extends Player{
    Person person;
    Chips chip;
    Integer chips;
    public DStyleCrapsPlayer(Person player) {
        this.person=player;
        chip = new Chips(person.getWallet().doubleValue());
         chips=chip.getChips();
    }

    public Integer roll(Dice dice){
       Integer total= dice.tossAndSum();
        return total;
    }
    public Chips numOfChips(){
        if (person.getWallet()==0)
            return null;
        else
        return chip;
        
    }
    public Integer bet(Integer betChips){
        chips=chips-betChips;
        return betChips;
    }

}
