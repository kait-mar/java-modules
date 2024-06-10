package ex03;
import ex02.Category;

public class Program { // how about the bidirectional linked list
    public static void main(String[] args) {
            UsersArrayList  usersList = new UsersArrayList();
            // TransactionsLinkedList transactionsList = new TransactionsLinkedList();

            for (int i = 0; i < 10; i++) {
                usersList.addUser(new User("Person_" + i, i));
            }
            for (int i = 0; i < 9; i++) {
                User sender = usersList.retrievUserById(i);
                User reciepent = usersList.retrievUserById(i + 1);
                Transaction tr = new Transaction(
                    sender,
                    reciepent,
                    i < 5 ? Category.CREDIT : Category.DEBIT,
                    i < 5 ? -(i + 10) : i + 10
                );
                // transactionsList.add(tr);
                sender.addTransaction(tr);
                reciepent.addTransaction(tr);
                tr.print();
            }
            System.out.println("**************************");
            for (int i = 0; i < 10; i++) {
                usersList.retrievUserById(i).getTransactions().print();
                System.out.println("-------");
            }
            
    }
}