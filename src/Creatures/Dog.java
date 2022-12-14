package Creatures;

import Location.Bath;
import Location.Salon;
import Utils.DogHaircut;
import Utils.LookLike;
import Utils.Lookable;

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
            System.out.println(getName() + " cannot wash in an empty bath");
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
}