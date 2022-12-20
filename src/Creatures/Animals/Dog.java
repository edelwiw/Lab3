package Creatures.Animals;

import Exceptions.Uncheckable.EmptyBath;
import Location.Bath;
import Location.Salon;
import Utils.LookLike;
import Utils.Lookable;

import java.util.Objects;

public class Dog extends Animal implements Lookable{

    private LookLike look = LookLike.OKAY;
    private DogHaircut haircut;

    public Dog(String name, int age, DogHaircut.HaircutType haircut){
        super(name, age);
        this.haircut = new DogHaircut(name + " haircut", haircut);
    }

    public void bark(){
        System.out.println(this.getName() + " barks!");
    }

    public DogHaircut getHaircut(){
        return haircut;
    }

    public void doHaircut(){
        if(!(this.locate() instanceof Salon)) {
            System.out.println(getName() + " Cannot get a haircut here");
            return;
        }
        ((Salon) this.locate()).doHaircut(this.getHaircut());
    }

    @Override
    public void clean() {
        if(!(this.locate() instanceof Bath)) {
            System.out.println(getName() + " cannot wash without a bath");
            return;
        }
        if(!((Bath) this.locate()).isFilled()) {
//            System.out.println(getName() + " cannot wash in an empty bath");
            throw new EmptyBath(this.getName() + " cannot wash in an empty bath!");
        }
        if(this.look == LookLike.FINE) System.out.println(this.getName() + " is already beautiful!");
        else{
            this.look = LookLike.OKAY;
            System.out.println(this.getName() + " now brilliant!");
            this.haircut.drabble(); // cause they are wet now
        }
    }

    @Override
    public void drabble(){
        System.out.println(this.getName() + " now look bad, so sad :(");
        this.look = LookLike.DIRTY;
    }

    @Override
    public LookLike getLook() {
        if(this.haircut.getLook() != LookLike.FINE) {
            return haircut.getLook();
        }
        return this.look;
    }

    public static class DogHaircut implements Lookable {

        public static enum HaircutType{
            STRAIGHT,
            BRAIDS,
        }


        private LookLike look;
        private final String name;
        private final Dog.DogHaircut.HaircutType type;
        private boolean brushed = false;

        public DogHaircut(String name, Dog.DogHaircut.HaircutType type){
            this.name = name;
            this.look = LookLike.FINE;
            this.type = type;
        }

        public String getName() {
            return this.name + " " + this.type;
        }

        public Dog.DogHaircut.HaircutType getType(){
            return this.type;
        }

        public void brush(){
            this.look = LookLike.BAD;
            this.brushed = true;
        }

        @Override
        public void clean() {
            if(this.brushed || this.type != Dog.DogHaircut.HaircutType.BRAIDS) {
                this.look = LookLike.OKAY;
                System.out.println(this.name + " now cleared");
            }
            else{
                this.look = LookLike.BAD;
                System.out.println(this.name + " hasn't been brushed. Now this look bad:(");
            }
            this.brushed = false;

        }

        @Override
        public LookLike getLook() {
            return look;
        }

        public void setLook(LookLike look){
            this.look = look;
        }

        @Override
        public void drabble() {
            this.look = LookLike.DIRTY;
        }

        @Override
        public String toString() {
            return "Haircut name= " + this.name;
        }

        @Override
        public int hashCode() {
            return Objects.hash(type);
        }

        @Override
        public boolean equals(Object oth) {
            if (this == oth) return true;
            if (oth == null) return false;
            if (!oth.getClass().equals(this.getClass())) return false;

            DogHaircut other = (DogHaircut) oth;
            return type.equals(other.type) && brushed == other.brushed && look.equals(other.look);
        }
    }

}