package Utils;

import Location.Location;
import Utils.LookLike;
import Utils.Lookable;

import java.util.Objects;

public class DogHaircut implements Lookable {

    public static enum HaircutType{
        STRAIGHT,
        BRAIDS,
    }

    private LookLike look;
    private final String name;
    private final HaircutType type;
    private boolean brushed = false;

    public DogHaircut(String name, HaircutType type){
        this.name = name;
        this.look = LookLike.FINE;
        this.type = type;
    }

    public String getName() {
        return this.name + " " + this.type;
    }

    public HaircutType getType(){
        return this.type;
    }

    public void brush(){
        this.look = LookLike.BAD;
        this.brushed = true;
    }

    @Override
    public void clean() {
        if(this.brushed || this.type != HaircutType.BRAIDS) {
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
