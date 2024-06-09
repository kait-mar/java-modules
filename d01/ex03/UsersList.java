package ex03;

public interface UsersList {

    /*
        * Add a user
        * Retrieve a user by ID
        * Retrieve a user by index
        * Retrieve the number of users
     */
    public void addUser(User user);
    public User retrievUserById(int id);
    public User retrievUserByIndex(int index);
    public int  userListSize();
}
