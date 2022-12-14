package Creatures;

public class Veterinarian extends Human{

    public Veterinarian(String name, int age) {
        super(name, age);
    }

    public void treat(Animal animal){
        System.out.println("Doctor " + this.getName() + " will help you! " + animal.getName() + " now feel itself well!");
        animal.heal(100);
    }
}
