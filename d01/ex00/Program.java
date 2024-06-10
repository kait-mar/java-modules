package ex00;

public class Program {

    public static void  main(String[] args) {
        User user1 = new User("kait", 320);
        User user2 = new User("mar", 12);
        User user3 = new User("sso", 120);

        user1.print();
        user2.print();
        Transaction tr1 = new Transaction(user1, user2, Category.CREDIT, -200);
        Transaction tr2 = new Transaction(user3, user1, Category.DEBIT, 50);
        tr1.print();
        tr2.print();
    }
}