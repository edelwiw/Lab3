package Location;

public class Bath extends Location{

    private final float volume;
    private boolean isFilled;

    public Bath(String locationName, float volume){
        super(locationName);
        this.volume = volume > 0 ? volume : 1;
    }

    public boolean isFilled(){
        return isFilled;
    }

    public void fill(){
        if(!isFilled) {
            System.out.println("Bath " + this.getName() + " now filled with water!");
            System.out.printf("It been used %.2f liters of water\n", this.volume);
            this.isFilled = true;
        }
        else System.out.println("Bath " + this.getName() + " is already filled");
    }

    public void flush(){
        if(isFilled) {
            System.out.println(this.getName() + " flushed!");
            this.isFilled = false;
        }
        else System.out.println(this.getName() + " is already empty");
    }

}
