package download.service;

import download.dao.UserDAO;
import download.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public List<User> lstAllUsers() {
        return this.userDAO.lstAllUsers();
    }

    @Override
    public User getUser(int id) {
        return this.userDAO.getUser(id);
    }

    @Override
    public boolean addNewUser(User user) {
        if (!this.userDAO.isExistedUser(user.getFullName(), user.getCompanyName())) {
            this.userDAO.addNewUser(user);
            return true;
        } else {
//            this.userDAO.updateUser(user);
            return false;
        }
    }

    @Override
    public void updateUser(User user) {
        this.userDAO.updateUser(user);
    }

    @Override
    public void deleteUser(User user) {
        this.userDAO.deleteUser(user);
    }

    @Override
    public void deleteUser(int id) {
        this.userDAO.deleteUser(id);
    }
}
