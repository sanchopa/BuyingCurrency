import com.luxoft.buying_currency.model.Account;
import com.luxoft.buying_currency.model.User;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.luxoft.buying_currency.service.auth.UserService;

/** Класс-тест для темтирования @see UserServiceImpl
 * @autor Zavalny Alexander
 * @version 1.0
 */
public class UserServiceTest extends Assert {
    private static final Logger log = Logger.getLogger(UserServiceTest.class);

    final static String USER1_NAME = "Ivan";
    User user1;
    UserService userService;

    @Before
    public void dataPreparation() {
        user1 = new User(USER1_NAME);
        Account account = new Account(user1,"000", "001", "002");
        user1.setAccount(account);
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/root-context.xml");
        userService = (UserService) context.getBean("userService");
        userService.addUser(user1);
    }

    @Test
    public void testGet() {
        log.info("Testing obtain user base.");
        assertEquals(user1.getName(), userService.getUser(USER1_NAME).getName());
        assertEquals(null, userService.getUser("noname"));
    }

    @Test
    public void testGetAccount() {
        log.info(userService.getUser(USER1_NAME).getAccount().getBalanceRUB());
    }
}
