package Creatures;

public class MsMinoga extends Human{

    private boolean sleep = true;

    public MsMinoga(String name, int age){
        super(name, age);
    }

    public void wakeUp(){
        System.out.println(this.getName() + " woke up");
        this.sleep = false;
    }

    public boolean isSleep(){
        return this.sleep;
    }
}
