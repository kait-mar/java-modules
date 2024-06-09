package ex03;

public class Program { // how about the bidirectional linked list
    public static void main(String[] args) {
        try{
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
                    i < 5 ? category.CREDIT : category.DEBIT,
                    i < 5 ? i : -i
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
            


        } catch(RuntimeException e) {
            System.err.println(e);
        }
    }
}
