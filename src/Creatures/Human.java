package Creatures;

public abstract class Human extends Creature{

    public Human(String name, int age){
        super(name, age);
    }

    public void say(String text){
        System.out.println(this.getName() + " says: " + text);
    }
}
