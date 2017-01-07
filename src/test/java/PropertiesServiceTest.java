import com.luxoft.buying_currency.service.PropertiesService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by User on 25.12.2016.
 */
public class PropertiesServiceTest {
    private static final Logger log = Logger.getLogger(UserServiceTest.class);

    @Test
    public void testGetProperties() {
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/root-context.xml");
        PropertiesService propServ = (PropertiesService) context.getBean("propertiesService");
        log.info("Testing getting parameters from file...");
        log.info(propServ.getDefaultBalanceRUB());
        log.info(propServ.getDefaultBalanceUSD());
        log.info(propServ.getDefaultBalanceEUR());
    }
}
