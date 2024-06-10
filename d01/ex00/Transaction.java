package ex00;
import java.util.UUID;

enum Category {
    CREDIT,
    DEBIT
};

public class Transaction {
    private String      id;
    private User        recipient;
    private User        sender;
    private int        amount;
    private Category    category;

    Transaction(User _sender , User _reciepient, Category _category, int _amount) {
        if (_reciepient == null || _sender == null) {
            System.err.println("null: invalid users");
            return;
        }
        if (_category.equals(category.CREDIT) && _amount > 0) {
            System.err.println("amount can't be positive for credit transactions");
            return;
        }
        if (_category.equals(category.DEBIT) && _amount < 0) {
            System.err.println("amount can't be negative for debit transactions");
            return;
        }
        if (_sender.getBalance() < amount) {
            System.err.println("insufficient balance for user " + _sender.getId());
            return;
        }
        this.recipient = _reciepient;
        this.sender = _sender;
        this.amount = _amount;
        this.category = _category;
        this.id = UUID.randomUUID().toString();
    }

    public void print() {
        System.out.println(
            this.category + " Transaction from " + this.sender.getName()
            + " to " + this.recipient.getName()
            + " of amount : " + this.amount);
    }
}
