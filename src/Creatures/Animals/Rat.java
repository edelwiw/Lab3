package Creatures.Animals;

import Creatures.Creature;

public class Rat extends Animal {
    public Rat(String name, int age) {
        super(name, age);
    }

    public Rat(String name){
        super(name);
    }

    public Rat(){}

    public void bite(Creature target){

        class Attack{
            private static int attackCounter = 1;
            final Creature target;

            public Attack(Creature target){
                this.target = target;
            }

            public void attack(){
                int damage = this.calculateDamage();
                System.out.println("Attack number " + attackCounter++ + " with damage " + damage);
                target.damage(damage);
            }

            private int calculateDamage(){
                return Rat.this.getAge() * 8 + 10;
            }
        }

        new Attack(target).attack();

    }
}
