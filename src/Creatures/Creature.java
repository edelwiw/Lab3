package Creatures;

import Location.Locatable;
import Location.Location;

import java.util.Objects;

public abstract class Creature implements Locatable {

    Location location;
    public Creature(String name, int age){
        setName(name);
        setAge(age);
    }
    private String name;
    private int age;

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
        return "name= " + this.name + ", age= " + this.age;
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
