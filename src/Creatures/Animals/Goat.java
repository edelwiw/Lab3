package Creatures.Animals;

import Creatures.Animals.Animal;
import Creatures.CanSeeDreems;

public class Goat extends Animal implements CanSeeDreems {

    public Goat(String name) {
        super(name);
    }

    public Goat(String name, int age) {
        super(name, age);
    }

    public Goat(){}

    @Override
    public void dream(String dream){
        System.out.println("Zzz... " + this.getName() + " now dream about " + dream);
    }

}
