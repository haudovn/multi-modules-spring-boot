package download.dao;

import download.model.User;

import java.util.List;

public interface UserDAO {
    public List<User> lstAllUsers();
    public User getUser(int id);
    public void addNewUser(User user);
    public void updateUser(User user);
    public void deleteUser(User user);
    public void deleteUser(int id);
    public boolean isExistedUser(String fullName, String companyName);
}
