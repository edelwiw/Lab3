package Creatures.Humans;

import Creatures.Animals.Animal;
import Exceptions.Checkable.NotEnoughMoney;
import Food.Pills;

public class Veterinarian extends Human {

    public Veterinarian(String name, int age) {
        super(name, age);
    }

    public void treat(Animal animal, BankAccount bankAccount){
        try {
            bankAccount.doTrans(this.bankAccount, getPrice(animal));
        } catch (NotEnoughMoney e) {
            System.out.println("You need yearn a bit more money. It will cost " + getPrice(animal) + " coins");
            return;
        }

        System.out.println("Doctor " + this.getName() + " will help you! " + animal.getName() + " now feel itself well!");
        Pills pillForAnimal = new Pills("Pills for " + animal.getName(), 100 - animal.getHP());
        animal.heal(pillForAnimal);
    }

    public int getPrice(Animal animal){
        return (100 - animal.getHP())  * 2 + 30;
    }
}
