package Utils;

import Creatures.Animals.Dog;

public enum LookLike {
    DIRTY("Грязный"),
    BAD("Плохо"),
    OKAY("Хорошо"),
    FINE("Отлично");

    private String text;

    LookLike(String arg){
        this.text = arg;
    }

    public String translate(){
        return this.text;
    }
}
