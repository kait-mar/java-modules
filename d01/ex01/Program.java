package ex01;

public class Program {

    public static void  main(String[] args) {
        User user1 = new User("kait", 90);
        User user2 = new User("mar", 20);
        User user3 = new User("sso", 230);

        user1.print();
        user2.print();
        user3.print();
    }
}
