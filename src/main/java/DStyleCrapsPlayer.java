public class DStyleCrapsPlayer extends Player{
    Person person;
    public DStyleCrapsPlayer(Person player) {
        this.person=player;
    }
    Player[] player1;
    Integer chips=0;
    public Integer roll(Dice dice){
       Integer total= dice.tossAndSum();
        return total;
    }
    public Integer numOfChips(){
        if (person.getWallet()==0)
            return 0;
        else
            chips=person.getWallet()/5;
        return chips;
        
    }
    DolioStyleCraps dcraps=new DolioStyleCraps(2);
    public Integer bet(Integer betChips){
     chips=chips-betChips;
      if(dcraps.didWin(player1[0]))
      return chips+betChips*2;
      else
          return chips;
    }

}
