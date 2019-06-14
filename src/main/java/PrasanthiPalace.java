public class PrasanthiPalace {

    public static void main(String[] args) {
        // write your tests before you start fucking with this
        run();
    }
    public static void run() {
//        Mediator mediator = new Mediator();
      Console console = new Console(System.in, System.out);
//        mediator.parseInput(input);
        console.println("Welcome to our casino, Prasanthi's Palace!");
        console.println("Tell me a little about yourself");
        Integer age = console.getIntegerInput("How old are you?");
        String name = console.getStringInput("What's your name?");
        Double wallet = (age >= 21) ? console.getDoubleInput("How much money do you want to bet today?") : 0.0;
        Person person = new Person(wallet, name, age);
        console.println("You are currently in the lounge");
        console.println("There are five games available to play :");
        console.print("1) Palace\n2) Texas Hold 'Em\n3) Black Jack\n4) Cee-lo\n5) Dolio Style Craps\n");
        console.println("You can also hang out in the lounge and get a drink or a bite to eat.");
        String first  = console.getStringInput("What would you like to do?");
    }
}
