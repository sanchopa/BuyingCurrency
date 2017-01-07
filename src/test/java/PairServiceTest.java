import com.luxoft.buying_currency.model.Pair;
import com.luxoft.buying_currency.service.PairService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by User on 03.01.2017.
 */
public class PairServiceTest {
    private static final Logger log = Logger.getLogger(UserServiceTest.class);

    @Test
    public void testPair() {
        Pair usdrub = new Pair("usdrub", 15);
        Pair eurrub = new Pair("eurrub", 10);
        Pair eurusd = new Pair("eurusd", 20);

        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/root-context.xml");
        PairService pairService = (PairService) context.getBean("pairService");
        pairService.addPair(usdrub);
        pairService.addPair(eurrub);
        pairService.addPair(eurusd);
    }

    @Test
    public void getCourse() {
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/root-context.xml");
        PairService pairService = context.getBean(PairService.class);
        log.info("Test the receiving rate USD/RUB from the database...");
        log.info(pairService.getPair("usdrub").getCourse());
    }
}
