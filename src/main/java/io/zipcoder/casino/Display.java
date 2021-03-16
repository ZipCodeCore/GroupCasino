package io.zipcoder.casino;

public class Display {

    String currentDisplay;

    public Display(){
        this.currentDisplay = "";
    }

    public void setCurrentDisplay(String currentDisplay){
        this.currentDisplay = currentDisplay;
    }

    public void printCurrentDisplay(){
        System.out.println(currentDisplay);
    }

    public void currentDisplaySP(String currentDisplay){
        this.setCurrentDisplay(currentDisplay);
        this.printCurrentDisplay();
    }
}
