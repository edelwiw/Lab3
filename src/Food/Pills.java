package Food;

import Utils.HasHealingEffect;

public class Pills implements HasHealingEffect {
    private final int healingEffect;
    private final String name;

    public Pills(String name, int healingEffect){
        this.name = name;
        this.healingEffect = healingEffect;
    }


    public String getName() {
        return name;
    }

    @Override
    public int getHealingEffect() {
        return this.healingEffect;
    }

    @Override
    public String toString(){
        return this.name;
    }
}
