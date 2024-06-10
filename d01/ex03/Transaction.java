package ex03;

import java.util.UUID;

import ex02.Category;


public class Transaction {
    private String      uuid;
    private User        recipient;
    private User        sender;
    private int        amount;
    private Category    category;
    private  Transaction next = null;
    // private  Transaction prev = null;

    public Transaction(User _sender, User _reciepient, Category _category, int _amount) {
        if (_reciepient == null || _sender == null) {
            throw new RuntimeException("reciepent and sender can't be null");
        }
        if (_reciepient.getId() == _sender.getId()) {
            throw new RuntimeException("A user can't perform a transaction for himself");
        }
        if (_category.equals(Category.CREDIT) && _amount > 0) {
            throw new RuntimeException("amount can't be positive for credit transactions");
        }
        if (_category.equals(Category.DEBIT) && _amount < 0) {
            throw new RuntimeException("amount can't be negative for debit transactions");
        }
        if (_sender.getBalance() < amount) {
            throw new RuntimeException("insufficient balance for user " + _sender.getName());
        }
        this.recipient = _reciepient;
        this.sender = _sender;
        this.amount = _amount;
        this.category = _category;
        this.uuid = UUID.randomUUID().toString();
    }

    public Transaction(User _sender, User _reciepient, Category _category, int _amount, String _uuid) {
        if (_reciepient == null || _sender == null) {
            System.err.println("reciepent and sender can't be null");
            return ;
        }
        if (_reciepient.getId() == _sender.getId()) {
            System.err.println("Error: A user can't perform a transaction for himself");
            return;
        }
        if (_category.equals(Category.CREDIT) && _amount > 0) {
            System.err.println("amount can't be positive for credit transactions");
            return;
        }
        if (_category.equals(Category.DEBIT) && _amount < 0) {
            System.err.println("amount can't be negative for debit transactions");
            return;
        }
        if (_sender.getBalance() < amount) {
            System.err.println("insufficient balance for user " + _sender.getName());
            return;
        }
        this.recipient = _reciepient;
        this.sender = _sender;
        this.amount = _amount;
        this.category = _category;
        this.uuid = _uuid;
    }

    public Transaction(Transaction tr){
         this(tr.getSender(), tr.getRecipient(), tr.getCategory(), tr.getAmount(), tr.getUuid());
    }

    public void print() {
        System.out.println(
            this.category + " Transaction from " + this.sender.getName()
            + " to " + this.recipient.getName()
            + " of amount : " + this.amount
            + " with uuid " + this.uuid
            );
    }

    public String  getUuid() { return uuid; }
    public Transaction getNext() { return next; }
    // public Transaction getPrev() { return prev; }
    public User getSender() { return this.sender; }
    public User getRecipient() { return this.recipient; }
    public Category getCategory() { return this.category; }
    public int getAmount() { return this.amount; }

    public void setNext(Transaction tr) { next = tr; }
}