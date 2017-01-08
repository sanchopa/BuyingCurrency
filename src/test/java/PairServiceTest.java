import com.luxoft.buying_currency.model.Pair;
import com.luxoft.buying_currency.service.PairService;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by User on 03.01.2017.
 */
public class PairServiceTest {
    private static final Logger log = Logger.getLogger(UserServiceTest.class);
    private PairService pairService;

    @Before
    public void getContext(){
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/root-context.xml");
        pairService = context.getBean(PairService.class);
    }

    @Test
    public void testPair() {
        Pair usdrub = new Pair("usdrub", 15);
        Pair eurrub = new Pair("eurrub", 10);
        Pair eurusd = new Pair("eurusd", 20);

        pairService.addPair(usdrub);
        pairService.addPair(eurrub);
        pairService.addPair(eurusd);
    }

    @Test
    public void getCourse() {
        log.info("Test the receiving rate USD/RUB from the database...");
        log.info(pairService.getPair("usdrub").getCourse());
    }

    @Test
    public void testGenerateRandomCourse() {
        log.info("Test generating random numbers...");
        log.info(pairService.generateRandomDecimal());
    }

    @Test
    public void testGenerateRandomCursePair() {
        pairService.generateRandomCursePair("usdrub");
    }
}
