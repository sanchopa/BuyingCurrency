import com.luxoft.buying_currency.service.PropertiesServiceImpl;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.Properties;

/**
 * Created by User on 25.12.2016.
 */
public class PropertiesServiceTest {
    private static final Logger log = Logger.getLogger(UserServiceTest.class);
    @Test
    public void testGetProperties() {
        PropertiesServiceImpl propServ = new PropertiesServiceImpl();
        Properties property = propServ.getProperty("src/main/resources/defaultUser.properties");
        log.info(property.getProperty("MMM1"));

    }
}
