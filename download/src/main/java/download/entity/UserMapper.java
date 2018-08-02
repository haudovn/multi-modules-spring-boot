package download.entity;

import download.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Map data of table User to object of User class
 *
 */
public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet row, int rowNum) throws SQLException {
        User user = new User();
        user.setId(row.getInt("id"));
        user.setFullName(row.getString("fullName"));
        user.setCompanyName(row.getString("companyName"));
        return user;
    }
}
