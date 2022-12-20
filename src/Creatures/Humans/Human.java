package Creatures.Humans;

import Creatures.Creature;
import Exceptions.Checkable.NotEnoughMoney;

public abstract class Human extends Creature {

    public final BankAccount bankAccount;
    public Human(String name, int age){

        super(name, age);
        this.bankAccount = new BankAccount(this);

    }

    public void say(String text){
        System.out.println(this.getName() + " says: " + text);
    }

    public static class BankAccount{
        Human owner;
        int balance = 0;

        BankAccount(Human owner){
            this.owner = owner;
        }

        public void doTrans(BankAccount recipient, int amount) throws NotEnoughMoney {
            if (balance < amount) throw new NotEnoughMoney();
            recipient.topUp(amount);
            withdraw(amount);
        }

        public int getBalance(){
            return this.balance;
        }

        private void topUp(int amount){
            this.balance += amount;
        }

        private void withdraw(int amount){
            this.balance -= amount;
        }

        public void topUpWithCash(int amount){
            this.balance += amount;
            System.out.println("Wow! Money! Now balance is " +  this.balance);
        }



    }


}
