import java.lang.reflect.Array;
import java.util.ArrayList;

public class Mediator {
    private Console console;
    private Person person;
    private Boolean gameContinue;

    public Mediator() {
        this.console = new Console(System.in, System.out);
        gameContinue = true;
    }


    public void enterLounge(){
        console.println("Welcome to our casino, Prasanthi's Palace!");
        this.person = makePerson();
        console.println("You are currently in the lounge");
        printOptions();
        while (gameContinue) {
            String input = console.getStringInput("What would you like to do?");
            parseInput(input);
        }
    }


    private void playCraps() {
    }

    private void playBlackJack() {
    }


    private void playCeeLo() {
    }

    private void playPoker() {

    }

    private void playPalace() {
    }

    public Person makePerson() {
        console.println("Tell us a little about yourself");
        Integer age = console.getIntegerInput("How old are you?");
        String name = console.getStringInput("What's your name?");
        //Double wallet = (age >= 21) ? console.getDoubleInput("How much money do you want to bet today?") : 0.0;
        Double wallet = console.getDoubleInput("How much money have you brought with you today?");
        return new Person(wallet, name, age);
    }

    public void printOptions() {
        console.println("There are five games available to play :");
        console.print("1) Palace\n2) Texas Hold 'Em\n3) Black Jack\n4) Cee-lo\n5) Dolio Style Craps\n");
        console.println("While in the lounge you can get a drink or a bite to eat.");
        console.println("Let us know what you want to do");
    }

    public void getDrink() {
        console.println("Welcome to Will's Watering Hole");
        if (person.getWallet() <= 0) console.println("Remember, our drinks cost money. Would you like some water?");
        else {
            String drink = console.getStringInput("I can make you any drink, any way you want. What would you like?");
            console.println(String.format("%s, served just the way you like it. That'll be 8 dollars", drink));
            String finished = console.getStringInput("Done drinking?");
            if (finished.equals("yes")) console.println("Sorry, we have a one drink limit. You'll have to leave now");
            else console.println("Too bad, someone else needs your stool. Take your drink with you.");
        }
        console.println("You have returned to our luxurious lounge.");
    }
    public void getFood() {
        console.println("Welcome to Stefun's Sustainable Eatery");
        if (person.getWallet() <= 0) console.println("C'mon, how're you going to eat without any money. You can have some water.");
        else {
            String food = console.getStringInput("We can make just about anything. What do you want?");
            console.println(String.format("%s, straight from the kitchen.", food));
            String finished = console.getStringInput("Done eating?");
            if (finished.equals("yes")) console.println("Sorry, we have quite the wait. I'd appreciate it if you leave");
            else console.println("Too bad, someone else needs your table. Here's a container for your food.");
        }
        console.println("You have returned to the beautiful lounge.");
    }

    public String parseInput(String input){
        Action action = new Action(input);
        Act act = action.getAct();
        switch (act) {
            case QUIT:
                leaveGame();
                break;
            case PLAY:
                printOptions();
                break;
            case DRINK:
                getDrink();
                break;
            case EAT:
                getFood();
                break;
            case PALACE:
                playPalace();
                break;
            case POKER:
                playPoker();
                break;
            case CEELO:
                playCeeLo();
                break;
            case BLACKJACK:
                playBlackJack();
                break;
            case CRAPS:
                playCraps();
                break;
            case LOUNGE:
                enterLounge();
                break;
        }
        return "We're not sure what you meant by that. Can you be more specific?";
    }

    private void leaveGame() {
        console.println("We're sorry to see you go!");
        gameContinue = false;
    }

    public Boolean checkAge() {
        if (person == null) return false;
        return (person.getAge() >= 21);
    }
}
