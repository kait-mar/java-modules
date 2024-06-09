package ex03;
import ex01.UserIdsGenerator;
import ex02.UserNotFoundException;

public class User {
    private int     id;
    private String  name;
    private int     balance = 0;
    TransactionsLinkedList  transactions = null;

    // public static void main(String[] args) {
    //     System.out.println("hello");
    // }
    User(String _name){
        this.name = _name;
        this.id = UserIdsGenerator.getInstance().generateId();
        transactions = new TransactionsLinkedList();
    }

    User(String _name, int _balance){
        this.name = _name;
        if (_balance < 0){
            System.err.println("Balance can't be negative!");
            return ;
        }
        this.balance = _balance;
        this.id = UserIdsGenerator.getInstance().generateId();
        transactions = new TransactionsLinkedList();
    }

    public String getName() { return this.name; }
    public int  getId() { return this.id; }

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
        System.out.println("I am " + this.name + " id : " + this.id + ", my balance is " + this.balance);
    }

    public void addTransaction(Transaction tr) {
        transactions.add(tr);
    }

    public TransactionsLinkedList getTransactions() {
        return transactions;
    }
    // public void setTransaction(TransactionsLinkedList list) {
    //     transactions = list;
    // }
}
