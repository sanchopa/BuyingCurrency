import com.luxoft.buying_currency.model.user.User;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.luxoft.buying_currency.service.UserService;

/** Класс-тест для темтирования @see UserServiceImpl
 * @autor Zavalny Alexander
 * @version 1.0
 */
public class UserServiceTest extends Assert {
    private static final Logger log = Logger.getLogger(UserServiceTest.class);

    final static String USER1_NAME = "Ivan";

    User user1;
    UserService service;

    public void newUser() {
        user1 = new User();
        user1.setName(USER1_NAME);
    }

    public void addUser() {
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/root-context.xml");
        service = (UserService) context.getBean("userService");
        service.addUser(user1);
    }

    @Before
    public void dataPreparation() {
        newUser();
        addUser();
    }

    @Test
    public void testGet() {
        log.info("Testing obtain user base.");
        assertEquals(user1.getName(),service.getUser(USER1_NAME).getName());
        assertEquals(null,service.getUser("noname"));
    }
}
