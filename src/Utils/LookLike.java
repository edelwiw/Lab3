package Utils;

public enum LookLike {
    DIRTY("Грязный"),
    BAD("asd"),
    OKAY("ASd"),
    FINE("SAD");

    String text;
    LookLike(String arg){
        this.text = arg;
    }

    public String translate(){
        return this.text;
    }
}
