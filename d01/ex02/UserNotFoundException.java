package ex02;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(int id) {
        super("User" + (id >= 0 ? "with id: " + id : "") + " was not found");
    }
}
