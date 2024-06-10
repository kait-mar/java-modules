package ex00;

import ex00.Category;

public class Program {

    public static void  main(String[] args) {
        User user1 = new User("kait", 320);
        User user2 = new User("mar", 12);

        user1.print();
        user2.print();
        Transaction tr1 = new Transaction(user1, user2, Category.CREDIT, -200);
        // Transaction tr1 = new Transaction(user1, user2, category.CREDIT, -200);
        Transaction tr2 = new Transaction(user2, user1, Category.DEBIT, 200);
        // Transaction tr2 = new Transaction(user2, user1, category.DEBIT, 50);
        tr1.print();
        tr2.print();
    }
}