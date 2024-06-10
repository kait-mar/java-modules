package ex00;

import java.util.UUID;

public class User {
    private int     id;
    private String  name;
    private int     balance = 0;

    User(String _name){
        this.name = _name;
    }
    User(String _name, int _balance){
        this.name = _name;
        if (_balance < 0){
            System.err.println("Balance can't be negative!");
            return ;
        }
        this.balance = _balance;
    }

    public String getName() {return this.name; }

    public void setBalance(int _balance) {
        if (_balance < 0){
            System.err.println("Balance can't be negative!");
            return ;
        }
        this.balance = _balance;
    }

    public int getBalance() {
        return (this.balance);
    }

    public int  getId() { return this.id; }

    public void print() {
        System.out.println("I am " + this.name + ", I have " + this.balance);
    }
}