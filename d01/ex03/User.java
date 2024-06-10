package ex03;
import ex02.Category;
import ex01.UserIdsGenerator;
import ex02.UserNotFoundException;

public class User {
    private int     id;
    private String  name;
    private int     balance;
    TransactionsLinkedList  transactions;

    public User(String _name){
        this.name = _name;
        this.id = UserIdsGenerator.getInstance().generateId();
        this.balance = 0;
        transactions = new TransactionsLinkedList();
    }

    public User(String _name, int _balance){
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

    public String addTransaction(Transaction tr) {
        this.balance += tr.getAmount(); 
        transactions.add(tr);
        return tr.getUuid();
    }

    public TransactionsLinkedList getTransactions() {
        return transactions;
    }

}
