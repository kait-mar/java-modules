
enum  category{
    CREDIT,
    DEBIT
};

public class Transaction {
    private String      identifier;
    private User        recipient;
    private User        sender;
    private long        amount;
    private category    category;

    Transaction(User _reciepient, User _sender, category _category, long _amount) {
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
    }

    public void print() {
        System.out.println(
            this.category + " Transaction from " + this.sender.getName()
            + " to " + this.recipient.getName()
            + " of amount : " + this.amount);
    }
}