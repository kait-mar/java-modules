
import java.util.UUID;

public class User {
    private int     Identifier;
    private String  name;
    private int     balance = 0;

    // public static void main(String[] args) {
    //     System.out.println("hello");
    // }
    User(String _name){
        this.name = _name;
        // this.Identifier = UUID.randomUUID();
    }
    User(String _name, int _balance){
        this.name = _name;
        if (_balance < 0){
            System.err.println("Balance can't be negative!");
            return ;
        }
        this.balance = _balance;
        // this.Identifier = UUID.randomUUID();
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

    public void print() {
        System.out.println("I am " + this.name + ", I have " + this.balance);
    }
}