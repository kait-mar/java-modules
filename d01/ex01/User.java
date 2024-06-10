package ex01;

import ex01.UserIdsGenerator;

public class User {
    private int     id;
    private String  name;
    private int     balance;

    public User(String _name, int _balance){
        this.name = _name;
        if (_balance < 0){
            System.err.println("Balance can't be negative!");
            return ;
        }
        this.balance = _balance;
        this.id = UserIdsGenerator.getInstance().generateId();
    }

    public int getId() { return id; }

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

    public void print() {
        System.out.println("I am " + this.name + " id : " + this.id + ", I have " + this.balance);
    }

}
