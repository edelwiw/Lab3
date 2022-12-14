package Creatures;

public class Rat extends Creature{
    public Rat(String name, int age) {
        super(name, age);
    }

    public Rat(String name){
        super(name);
    }

    public Rat(){}

    private int calculateDamage(){
        return this.getAge() * 8 + 10;
    }

    public void bite(Creature target){
        target.damage(this.calculateDamage());
    }
}
