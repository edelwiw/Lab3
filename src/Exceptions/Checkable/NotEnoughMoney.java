package Exceptions.Checkable;

public class NotEnoughMoney extends Exception{
    public NotEnoughMoney(String message){
        super(message);
    }

    public NotEnoughMoney(){

    }
}
