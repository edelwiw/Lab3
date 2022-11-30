package Location;

import java.util.Objects;

public abstract class Location {

    private String name = "Unnamed";

    public Location(String name){
        if(name != null) this.name = name;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public String toString() {
        return "Location name= " + this.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object oth) {
        if (this == oth) return true;
        if (oth == null) return false;
        if (!oth.getClass().equals(this.getClass())) return false;

        Location other = (Location) oth;
        return name.equals(other.name);
    }

}
