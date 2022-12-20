package Food;

import Utils.HasHealingEffect;

public class Food implements HasHealingEffect {
    private int callory;
    private final String name;

    public Food(String name, int callory){
        this.callory = callory;
        this.name = name;
    }

    public int getCallory(){
        return this.callory;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public int getHealingEffect() {
        return this.callory * 2;
    }

    @Override
    public String toString(){
        return this.name;
    }
}
