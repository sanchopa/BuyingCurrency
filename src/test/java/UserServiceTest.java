import com.luxoft.buying_currency.model.Account;
import com.luxoft.buying_currency.model.History;
import com.luxoft.buying_currency.model.User;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.luxoft.buying_currency.service.UserService;

/**
 * Класс-тест для темтирования @see UserServiceImpl
 *
 * @version 1.0
 * @autor Zavalny Alexander
 */
public class UserServiceTest extends Assert {
    private static final Logger log = Logger.getLogger(UserServiceTest.class);

    final static String USER1_NAME = "Ivan";
    User user1;
    UserService userService;

//    @Before
    public void dataPreparation() {
        user1 = new User(USER1_NAME);
        Account account = new Account(user1, 1000, 1000, 1000);
        user1.setAccount(account);
        History history = new History(user1);
        user1.setHistory(history);
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/root-context.xml");
        userService = (UserService) context.getBean("userService");
        userService.addUser(user1);
    }

    @Test
    public void testGet() {
        log.info("Testing obtain user base...");
        assertEquals(user1.getName(), userService.getUser(USER1_NAME).getName());
        assertEquals(null, userService.getUser("noname"));
    }

    @Test
    public void testGetAccount() {
        log.info("Testing obtain account balance of the user...");
        log.info("Balance in rubles: "+userService.getUser(USER1_NAME).getAccount().getBalanceRUB());
    }
}
