package ex02;
import ex01.User;

public class Program {

    public static void  main(String[] args) {
        UsersArrayList usersList = new UsersArrayList();

        for (int i = 1; i < 10; i++) {
            usersList.addUser(new User("Person_" + i, i));
        }
        User temp = usersList.retrievUserById(7);
        temp.print();
        temp = usersList.retrievUserById(25);
        temp.print();
        System.out.println("finished with no errors");
    }
}
