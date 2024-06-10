package ex03;
import ex02.Category;

public class Program { // how about the bidirectional linked list
    public static void main(String[] args) {
            UsersArrayList  usersList = new UsersArrayList();

            for (int i = 1; i < 10; i++) {
                usersList.addUser(new User("Person_" + i, i + 700));
            }
            for (int i = 1; i < 9; i++) {
                User sender = usersList.retrievUserById(i);
                User reciepent = usersList.retrievUserById(i + 1);
                Transaction tr1 = new Transaction(
                    sender,
                    reciepent,
                    Category.CREDIT,
                    -(i + 10)
                );
                Transaction tr2 = new Transaction(
                    sender,
                    reciepent,
                    Category.DEBIT,
                    (i + 10)
                );
                // transactionsList.add(tr);
                sender.addTransaction(tr1);
                reciepent.addTransaction(tr2);
                tr1.print();
                tr2.print();
            }
            System.out.println("**************************");
            for (int i = 1; i < 9; i++) {
                TransactionsLinkedList transactions = usersList.retrievUserById(i).getTransactions();
                Transaction[] transactionsArray = transactions.toArray();
                for (int j = 0; j < transactionsArray.length; j++)
                    transactionsArray[j].print();
                System.out.println("-------");
            }
            TransactionsLinkedList transactions = usersList.retrievUserById(5).getTransactions();
            transactions.remove("test");
    }
}
