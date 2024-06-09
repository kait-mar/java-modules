package ex01;

public class Program {

    public static void  main(String[] args) {
        User user1 = new User("kait", 90);
        User user2 = new User("mar", 20);
        User user3 = new User("sso", 230);

        // user2.setBalance(-10);
        user1.print();
        user2.print();
        user3.print();
        // System.out.println("**************");
        // UserIdsGenerator gen1 = UserIdsGenerator.getInstance();
        // UserIdsGenerator gen2 = UserIdsGenerator.getInstance();
        // System.out.println(gen1._id);
        // System.out.println(gen2._id);
    }
}
