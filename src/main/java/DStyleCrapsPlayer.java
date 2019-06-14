public class DStyleCrapsPlayer extends Player{
    Person person;
    Integer chips;
    public DStyleCrapsPlayer(Person player) {
        this.person=player;
        House house=new House(2);
        chips=house.moneyToChips(20.0);

    }

    public Integer roll(Dice dice){
       Integer total= dice.tossAndSum();
        return total;
    }
    public Integer numOfChips(){
        if (person.getWallet()==0)
            return null;
        else
        return chips;
        
    }
    public Integer bet(Integer betChips){
        chips=chips-betChips;
        return betChips;
    }

}
