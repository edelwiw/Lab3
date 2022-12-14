import Creatures.*;
import Food.Food;
import Location.Bath;
import Location.Salon;
import Location.BedRoom;
import Utils.DogHaircut;
import Utils.LookLike;

public class Main {
    public static void main(String[] args) {

        Rat rat = new Rat("Bad rat", 7);

        Goat kozlik = new Goat("Kozlik");
        kozlik.dream(String.valueOf(rat));
        rat.bite(kozlik);

        Food bakedPotato = new Food("Baked potato", 6);
        Food potato = new Food("Potato", 2);
        Food cabbage = new Food("Cabbage", 4);
        Food horseradish = new Food("Horseradish", 4);

        kozlik.heal(bakedPotato.getHealingEffect());
        kozlik.heal(potato.getHealingEffect());
        kozlik.heal(cabbage.getHealingEffect());
        kozlik.heal(horseradish.getHealingEffect());

        Veterinarian aibolit = new Veterinarian("Aibolit", 64);
        aibolit.treat(kozlik);

        Bath mimiBath = new Bath("Bath for Mimi", 45.2f);
        Bath rolandBath = new Bath("Bath for Roland", 143);
        Salon salon = new Salon("Salon");
        BedRoom bedroom = new BedRoom("Bedroom");


        // Наиболее ответственным делом, которое поручили Незнайке, было купание собак
        Neznaika neznaika = new Neznaika("Neznaika", 9);
        MsMinoga minoga = new MsMinoga("Miss Minoga", 56);

        minoga.setLocation(bedroom);

        Dog mimi = new Dog("Mimi", 6, DogHaircut.HaircutType.STRAIGHT);
        Dog roland = new Dog("Roland", 15, DogHaircut.HaircutType.BRAIDS);


        mimi.setLocation(bedroom);
        roland.setLocation(bedroom);

        //Для этой цели в доме имелась специальная комната с двумя ваннами.
        // Одна ванна, побольше, для Роланда, другая, поменьше, для Мими.


        // (Rolnad) так как перед купанием ему обязательно надо было распускать косички, а это требовало много времени.

        roland.getHaircut().brush();

        mimiBath.fill(); // Наполнить ванную водой
        rolandBath.fill();

        mimi.setLocation(mimiBath); // отвести собак в ванную
        roland.setLocation(rolandBath);

        neznaika.wash(mimi);// искупать собак
        neznaika.wash(roland);

        mimiBath.flush(); // слить воду
        rolandBath.flush();

        mimi.setLocation(salon); // отвести собак в парикмахерскую
        roland.setLocation(salon);

        mimi.doHaircut(); // сделать прическу
        roland.doHaircut();

        mimi.setLocation(bedroom);
        roland.setLocation(bedroom);

        minoga.wakeUp();
        minoga.say("Good Morning!");

        LookLike loook = LookLike.BAD;
        System.out.println(loook.translate());

    }
}

