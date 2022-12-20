package Creatures;

import Exceptions.Uncheckable.CannotHealDead;
import Location.Locatable;
import Location.Location;
import Utils.HasHealingEffect;

import java.util.Objects;

public abstract class Creature implements Locatable {

    Location location;
    public Creature(String name, int age){
        setName(name);
        setAge(age);
    }

    public Creature(String name){
        setName(name);
    }

    public Creature(){}

    private String name = "No name";
    private int age;
    private int hp = 100;

    public final void damage(int damage){
        this.hp -= damage;
        if(this.hp > 0) System.out.println("That was really painful! Now " + this.name + " hp is " + this.hp);
        else System.out.println("That was really painful! Now " + this.name + " is dead :(");
    }

    public void heal(HasHealingEffect heal){
        if(!this.isAlive()) throw new CannotHealDead();
        System.out.println("Eating " + heal.toString() +  " gives " + this.name + " " + heal.getHealingEffect() + " hp.");
        this.hp = Math.min(100, this.hp + heal.getHealingEffect());
        //System.out.println("Sounds good! Now " + this.name + " hp is " + this.hp);
    }

    public boolean isAlive(){
        return this.hp > 0;
    }

    public int getHP(){
        return this.hp;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public Location locate() {
        return this.location;
    }

    @Override
    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "name=" + this.name + ", age=" + this.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public boolean equals(Object oth) {
        if (this == oth) return true;
        if (oth == null) return false;
        if (!oth.getClass().equals(this.getClass())) return false;

        Creature other = (Creature) oth;
        return name.equals(other.name) && location.equals(other.location);
    }
}
