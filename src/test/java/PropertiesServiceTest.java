import com.luxoft.buying_currency.service.PropertiesServiceImpl;
import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * Created by User on 25.12.2016.
 */
public class PropertiesServiceTest {
    private static final Logger log = Logger.getLogger(UserServiceTest.class);
    @Test
    public void testGetProperties() {
        PropertiesServiceImpl propServ = new PropertiesServiceImpl();
        log.info(propServ.getDefaultBalanceRUB());
        log.info(propServ.getDefaultBalanceUSD());
        log.info(propServ.getDefaultBalanceEUR());
    }
}
