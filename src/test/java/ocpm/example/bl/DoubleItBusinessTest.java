/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocpm.example.bl;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Dinesh
 */
@RunWith(SpringRunner.class)
@SpringBootTest()
public class DoubleItBusinessTest {

  @Autowired
  DoubleItBusiness classUnderTest;

  @Before
  public void setupTest() {
    //classUnderTest = new DoubleItBusiness();
  }

  @Test
  public void testZero() {
    classUnderTest.doubleIt(0);
    assertEquals(0, classUnderTest.getValue());
  }

  @Test
  public void testPositive() {
    classUnderTest.doubleIt(23);
    assertEquals(46, classUnderTest.getValue());

  }

  @Test
  public void testNegative() {
    classUnderTest.doubleIt(-4);
    assertEquals(-8, classUnderTest.getValue());
  }

}
