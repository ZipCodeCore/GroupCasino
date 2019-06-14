import java.lang.reflect.Array;
import java.util.ArrayList;

public class Mediator {
    private Console console;
    private Person person;

    public Mediator() {
        this.console = new Console(System.in, System.out);
    }


    public void enterLounge(){
        console.println("Welcome to our casino, Prasanthi's Palace!");
        this.person = makePerson();
        console.println("You are currently in the lounge");
        printOptions();
        String action = console.getStringInput("What would you like to do?");
        while (!action.equals("quit")) {
            String prompt = getPrompt(action);
            action = console.getStringInput(prompt);
        }
    }

    public String getPrompt(String action) {
        String prompt = "";
        switch (action) {
            case "": printOptions(); break;
            case "drink": getDrink(); break;
            case "eat": getFood(); break;
            case "palace": playPalace(); break;
            case "poker": playPoker(); break;
            case "cee-lo": playCeeLo(); break;
            case "blackjack": playBlackJack(); break;
            case "craps": playCraps(); break;
            default: prompt = "Have you considered playing a game?"; break;
        }
        return prompt;
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
        String drink = console.getStringInput("I can make you any drink, any way you want. What would you like?");
        console.println(String.format("%s, served just the way you like it. That'll be 8 dollars", drink));
        String finished = console.getStringInput("Done drinking?");
        if (finished.equals("yes")) console.println("Sorry, we have a one drink limit. You'll have to leave now");
        else console.println("Too bad, someone else needs your stool. Take your drink with you.");
        console.println("You have returned to our luxurious lounge.");
    }
    public void getFood() {
        console.println("Welcome to Stefun's Sustainable Eatery");
        if (person.getWallet() <= 0) console.println("C'mon, how're you going to eat without any money. You can have some water.");
        String food = console.getStringInput("We can make just about anything. What do you want?");
        console.println(String.format("%s, straight from the kitchen.", food));
        String finished = console.getStringInput("Done eating?");
        if (finished.equals("yes")) console.println("Sorry, we have quite the wait. I'd appreciate it if you leave");
        else console.println("Too bad, someone else needs your table. Here's a container for your food.");
        console.println("You have returned to the beautiful lounge.");
    }

    public void parseInput(String input){}

    public Boolean checkAge() { return false; }
}
