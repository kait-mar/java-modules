package ex03;

import java.util.UUID;

enum  category{
    CREDIT,
    DEBIT
};

public class Transaction {
    private String      uuid;
    private User        recipient;
    private User        sender;
    private long        amount;
    private category    category;
    private  Transaction next = null;
    private  Transaction prev = null;

    public Transaction(User _sender, User _reciepient, category _category, long _amount) {
        if (_reciepient == null || _sender == null) {
            System.err.println("reciepent and sender can't be null");
            return ;
        }
        if (_category.equals(category.CREDIT) && _amount < 0) {
            System.err.println("amount can't be negative for credit transactions");
            return;
        }
        if (_category.equals(category.DEBIT) && _amount > 0) {
            System.err.println("amount can't be positive for debit transactions");
            return;
        }
        this.recipient = _reciepient;
        this.sender = _sender;
        this.amount = _amount;
        this.category = _category;
        this.uuid = UUID.randomUUID().toString().replace("-", "");
    }

    public Transaction(Transaction tr){
         this(tr.getSender(), tr.getRecipient(), tr.getCategory(), tr.getAmount());
    }

    public void print() {
        System.out.println(
            this.category + " Transaction from " + this.sender.getName()
            + " to " + this.recipient.getName()
            + " of amount : " + this.amount);
    }

    public String  getUuid() { return uuid; }
    public Transaction getNext() { return next; }
    public Transaction getPrev() { return prev; }
    public User getSender() { return this.sender; }
    public User getRecipient() { return this.recipient; }
    public category getCategory() { return this.category; }
    public long getAmount() { return this.amount; }

    public void setNext(Transaction tr) { next = tr; }
}