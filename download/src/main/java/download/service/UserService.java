package download.service;

import download.model.User;

import java.util.List;

public interface UserService {
    public List<User> lstAllUsers();
    public User getUser(int id);
    public boolean addNewUser(User user);
    public void updateUser(User user);
    public void deleteUser(User user);
    public void deleteUser(int id);
}
