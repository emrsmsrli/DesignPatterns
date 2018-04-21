package iztechify.models;

import iztechify.models.user.User;

import java.util.List;
import java.util.Observable;

public class Users extends Observable {
    private List<User> users;

    public Users(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public User getUser(String username) {
        for(User u : users)
            if(u.getUsername().equals(username))
                return u;
        return null;
    }
}
