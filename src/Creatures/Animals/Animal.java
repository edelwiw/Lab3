package Creatures.Animals;

import Creatures.Creature;

public abstract class Animal extends Creature {

    public Animal(String name, int age){
        super(name, age);
    }

    public Animal(String name){
        super(name);
    }

    public Animal(){}

}
