package Creatures.Humans;

import Creatures.Humans.Human;
import Utils.Lookable;

public class Neznaika extends Human {

    public Neznaika(String name, int age){
        super(name, age);
    }

    public void wash(Lookable entity){
        entity.clean();
        System.out.println("Done!, There are clean now!");
    }
}
