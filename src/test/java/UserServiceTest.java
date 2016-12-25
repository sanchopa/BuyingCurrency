import com.luxoft.buying_currency.model.user.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.luxoft.buying_currency.service.UserService;

/**
 * Created by Alex Zavalnyi on 21.12.2016.
 */
public class UserServiceTest extends Assert {
    final static String USER1_NAME = "Ivan";
    final static String USER2_NAME = "Alex";
    final static String USER3_NAME = "Lololol";
    final static String USER4_NAME = "Scr";

    User user1, user2, user3, user4;
    UserService service;

    public void newUser() {
        user1 = new User();
        user1.setName(USER1_NAME);

        user2 = new User();
        user2.setName(USER2_NAME);

        user3 = new User();
        user3.setName(USER3_NAME);

        user4 = new User();
        user4.setName(USER4_NAME);
    }

    public void getService() {
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/orm-context.xml");
        service = (UserService) context.getBean("userService");
    }

    @Before
    public void addUser() {
        newUser();
        getService();

        service.addUser(user1);
        service.addUser(user2);
        service.addUser(user3);
        service.addUser(user4);
    }

    @Test
    public void testGet() {
        assertEquals(user1.getName(),service.getUser(USER1_NAME).getName());
        assertEquals(null,service.getUser("noname"));
    }
}
