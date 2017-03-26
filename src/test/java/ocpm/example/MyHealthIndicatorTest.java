package ocpm.example;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by Shalini on 1/31/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest()
public class MyHealthIndicatorTest {

    @Autowired
    private MyHealthIndicator classUnderTest;

    private static String default_revision;

    @BeforeClass
    public static void setup() {
        default_revision = "OCPM-DUMMY-ENGINE";
    }

    @Test
    public void createUpSignal() throws Exception {
        Health health = classUnderTest.respondUp(default_revision);
        assertEquals("Health Response Status equals UP", health.getStatus(), Status.UP);
    }

    @Test
    public void createDownSignal() throws Exception {
        Health health = classUnderTest.respondDown(default_revision);
        assertEquals("Health Response Status equals UP", health.getStatus(), Status.DOWN);
    }

    @Test
    public void health() throws Exception {
        Health health = classUnderTest.health();
        assertEquals("Health check returns Status equals UP", health.getStatus(), Status.UP);
    }

}
