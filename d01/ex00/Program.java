/**
 * Program
 */
public class Program {

    public static void  main(String[] args) {
        User user1 = new User("kait", 90);
        User user2 = new User("mar");

        // user2.setBalance(-10);
        user2.setBalance(10);
        Transaction tr1 = new Transaction(user1, user2, category.CREDIT, 200);
        // Transaction tr1 = new Transaction(user1, user2, category.CREDIT, -200);
        Transaction tr2 = new Transaction(user2, user1, category.DEBIT, -50);
        // Transaction tr2 = new Transaction(user2, user1, category.DEBIT, 50);
        tr1.print();
        tr2.print();
    }
}