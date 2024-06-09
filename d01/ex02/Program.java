package ex02;
import ex01.User;

public class Program {

    public static void  main(String[] args) {
        try {
            UsersArrayList usersList = new UsersArrayList();

            for (int i = 0; i < 10; i++) {
                usersList.addUser(new User("Person_" + i, i));
            }
            User temp = usersList.retrievUserById(7);
            temp.print();
            temp = usersList.retrievUserById(25);
            temp.print();
            System.out.println("finished with no errors");
        } catch (RuntimeException e) {
            System.err.println(e);
        }
    }
}
