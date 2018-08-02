package download.dao;

import download.entity.UserMapper;
import download.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class UserDAOImpl implements UserDAO {
    private final String _TABLE_NAME = "user";
    private final String _FIELD_ID = "id";
    private final String _FIELD_FULL_NAME = "fullname";
    private final String _FIELD_COMPANY_NAME = "companyname";

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<User> lstAllUsers() {
        String querySQL = String.format("SELECT * FROM %1$s", _TABLE_NAME);
        RowMapper<User> rowMapper = new UserMapper();
        return this.jdbcTemplate.query(querySQL, rowMapper);
    }

    @Override
    public User getUser(int id) {
        String querySQL = String.format("SELECT * FROM %1$s WHERE %2$s = ?", _TABLE_NAME, _FIELD_ID);
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
        User user = this.jdbcTemplate.queryForObject(querySQL, rowMapper, id);
        return user;
    }

    @Override
    public void addNewUser(User user) {
        String querySQL = String.format("INSERT INTO %1$s (%2$s, %3$s) values (?, ?)", _TABLE_NAME, _FIELD_FULL_NAME, _FIELD_COMPANY_NAME);
        jdbcTemplate.update(querySQL, user.getFullName(), user.getCompanyName());

        //update id
        querySQL = String.format("SELECT %1$s FROM %2$s WHERE %3$s = ? and %4$s = ?", _FIELD_ID, _TABLE_NAME, _FIELD_FULL_NAME, _FIELD_COMPANY_NAME);
        int id = jdbcTemplate.queryForObject(querySQL, Integer.class, user.getFullName(), user.getCompanyName());
        user.setId(id);
    }

    @Override
    public void updateUser(User user) {
        String querySQL = String.format("UPDATE %1$s SET %2$s = ?, %3$s = ? WHERE %4$s = ?", _TABLE_NAME, _FIELD_FULL_NAME, _FIELD_COMPANY_NAME, _FIELD_ID);
        jdbcTemplate.update(querySQL, user.getFullName(), user.getCompanyName(), user.getId());
    }

    @Override
    public void deleteUser(User user) {
        deleteUser(user.getId());

    }

    @Override
    public void deleteUser(int id) {
        String querySQL = String.format("DELETE FROM %1$s WHERE %2$s = ?", _TABLE_NAME, _FIELD_ID);
        jdbcTemplate.update(querySQL, id);
    }

    public boolean isExistedUser(String fullName, String companyName) {
        String querySQL = String.format("SELECT count(*) FROM %1$s WHERE %2$s = ? and %3$s = ?", _TABLE_NAME, _FIELD_FULL_NAME, _FIELD_COMPANY_NAME);
        int count = jdbcTemplate.queryForObject(querySQL, Integer.class, fullName, companyName);
        return (count > 0);
    }
}
