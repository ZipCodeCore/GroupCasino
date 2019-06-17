public class Action {
    private  String input;

    public Action(String input) {
        this.input = input;
    }

    public String toActionString() {
        return "";
    }

    public Act getAct() {

        return Act.QUIT;
    }

    public String normalizeInput() {
        return "";
    }
}
