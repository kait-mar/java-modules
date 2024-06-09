package ex04;

import ex03.Transaction;
import ex03.User;
import ex03.UsersArrayList;
import ex03.category;

public class TransactionsService {
        private UsersArrayList users;

    // Adding a user
    // • Retrieving a user’s balance
    // • Performing a transfer transaction (user IDs and transfer amount are specified). In
    // this case, two transactions of DEBIT/CREDIT types are created and added to
    // recipient and sender. IDs of both transactions must be equal
    // • Retrieving transfers of a specific user (an ARRAY of transfers is returned).
    // Removing a transaction by ID for a specific user (transaction ID and user ID are
    // specified)
    // • Check validity of transactions (returns an ARRAY of unpaired transactions).
    //     n case of an attempt to make a transfer of the amount exceeding user’s residual
    // balance, IllegalTransactionException runtime exception must be thrown. update balance in every transaction

    public TransactionsService() {
        this.users = new UsersArrayList();
    }

    public void addUser(User user) {
        users.addUser(user);
    }

    public long retrieveUserBalance(int id) {
        return users.retrievUserById(id).getBalance();
    }

    public void createTransaction(int senderId, int recipientId, long amount) {
        User sender = users.retrievUserById(senderId);
        User recipient = users.retrievUserById(recipientId);
        sender.addTransaction(new Transaction(
            sender,
            recipient,
            category.CREDIT,
            amount
        ));
        recipient.addTransaction(new Transaction(
            sender,
            recipient,
            category.DEBIT,
            -amount
        ));
    }
    
    public Transaction[] retrieveUserTransactions(int id) {
        users.retrievUserById(id).getTransactions().toArray();
    }

    public void removeuserTransaction(int id, String uuid) {
        users.retrievUserById(id).getTransactions().remove(uuid);
    }
}
