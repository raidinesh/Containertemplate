package ocpm.example.bl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Shalini on 1/31/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest()
public class MyAdminStateTest {

    @Autowired
    MyAdminState classUnderTest;

    @Test
    public void getValue() throws Exception {
        List<String> valid_values = Arrays.asList("up", "down");
        assertTrue("MyAdminState is either up or down", valid_values.contains(classUnderTest.getValue()));
    }

    @Test
    public void setValueUp() throws Exception {
        classUnderTest.setValue("up");
        assertEquals("MyAdminState is up", "up", classUnderTest.getValue());
    }

    @Test
    public void setValueDown() throws Exception {
        classUnderTest.setValue("down");
        assertEquals("MyAdminState is down","down", classUnderTest.getValue());
    }

}
