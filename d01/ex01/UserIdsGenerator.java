package ex01;

public class UserIdsGenerator {
    private int _id = 0;
    private static UserIdsGenerator instance = null;

    public static int generateId(){
        return instance._id++;
    }

    public static UserIdsGenerator getInstance() {
        if (instance == null) {
            instance = new UserIdsGenerator();
        }
        return instance;
    }
}
