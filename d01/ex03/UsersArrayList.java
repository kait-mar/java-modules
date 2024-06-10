package ex03;

import ex02.UserNotFoundException;

public class UsersArrayList implements UsersList{

    private User[] users;
    private int size;

    public  UsersArrayList() {
        this.users = new User[10];
        this.size = 0;
    }

    public void addUser(User user) {
        if (this.size >= users.length) {
            User[] temp = new User[size + size / 2];
            System.arraycopy(user, 0, temp, 0, size);
            users = temp;
        }
        users[size++] = user;
    }

    public User retrievUserById(int id) throws UserNotFoundException{
        for (int i = 0; i < size; i++) {
            if (id == users[i].getId())
                return users[i];
        }
        throw new UserNotFoundException(id);
    }

    public User retrievUserByIndex(int index) {
        // if (index < size && users[index] != null)
            return users[index];
        // throw new UserNotFoundException(-1);
    }

    public int  getListSize() {
        return size ;
    }

}
