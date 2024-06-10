package ex04;

import ex02.Category;
import ex03.Transaction;
import ex03.TransactionsLinkedList;
import ex03.User;
import ex03.UsersArrayList;

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

    public int retrieveUserBalance(int id) {
        
        return users.retrievUserById(id).getBalance();
    }

    public void createTransaction(int senderId, int recipientId, int amount) {
        User sender = users.retrievUserById(senderId);
        User recipient = users.retrievUserById(recipientId);
        // System.out.println("sender.getBalance() " + sender.getBalance() + " amount " + amount);
        if (sender.getBalance() < amount)
            throw new IllegalTransactionException(senderId);
        String uuid = sender.addTransaction(new Transaction(
            sender,
            recipient,
            Category.CREDIT,
            -amount
        ));
        recipient.addTransaction(new Transaction(
            sender,
            recipient,
            Category.DEBIT,
            amount,
            uuid
        ));
    }
    
    public Transaction[] retrieveUserTransactions(int id) {
        return users.retrievUserById(id).getTransactions().toArray();
    }

    public Transaction removeuserTransaction(int id, String uuid) {
        return users.retrievUserById(id).getTransactions().remove(uuid);
    }

    public Transaction[]    checkTransactionsValidity() {
        TransactionsLinkedList   unpairedTransactions = new TransactionsLinkedList(); //temporary size allocation
    
        for (int i = 0; i < users.getListSize(); i ++) {
            User user = users.retrievUserByIndex(i);
            TransactionsLinkedList transactions = user.getTransactions();
            
            Transaction temp = transactions.getHead();
            while (temp != null) {
                if (temp.getCategory().equals(Category.CREDIT) 
                    && temp.getRecipient().getTransactions().getTransactionById(temp.getUuid()) == null) {
                        unpairedTransactions.add(temp);
                }
                else if (temp.getCategory().equals(Category.DEBIT) 
                && temp.getSender().getTransactions().getTransactionById(temp.getUuid()) == null) {
                    unpairedTransactions.add(temp);
                }
                temp = temp.getNext();
            }
        }
        return unpairedTransactions.toArray();
    }

    public User findUser(int id) {
        return users.retrievUserById(id);
    }
}
