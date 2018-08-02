package download.util;

import download.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserUtils {

    /**
     * for test
     *
     * @return
     */
    public static User getStaticUserForTest() {
        User user = new User();
        user.setId(1);
        user.setFullName("Hau Do");
        user.setCompanyName("Titan");
        return user;
    }

    public static List<Object> getListValues(User user) {
        List<Object> listValues = new ArrayList<>();
        listValues.add(user.getId());
        listValues.add(user.getFullName());
        listValues.add(user.getCompanyName());
        return listValues;
    }
}
