package Location;

import Creatures.Animals.Dog;
import Utils.LookLike;

public class Salon extends Location{

    public Salon(String name) {
        super(name);
    }

    public void doHaircut(Dog.DogHaircut hc){
        System.out.println(hc.getName() + " now well");
        if(!(hc.getLook() != LookLike.OKAY || hc.getLook() != LookLike.FINE)) {
            System.out.println("Hair is dirty. Cannot go to salon");
            return;
        }
        hc.setLook(LookLike.FINE);
    }

}
