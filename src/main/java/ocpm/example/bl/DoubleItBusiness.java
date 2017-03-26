/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocpm.example.bl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dinesh
 */
@RefreshScope
@Service
public class DoubleItBusiness {
  
  private static final int multiplier = 2;
  
  private static final Logger logger = LoggerFactory.getLogger(DoubleItBusiness.class);
  /**
   * Simple constructor
   */
  public DoubleItBusiness () {
  }
  
  @Value("${ocpm.doubleit.value:9 default}")
  private Integer value;
  
  @Autowired
  private Tracer tracer;
  
  /**
   * Get the current value
   * @return an integer representing 2x the value we were set with.
   */
  
  public int getValue () {
    return value;
  }
  
  /**
   * The main purpose of this function, given a number, store twice its value.
   * @param numToDouble - The number to be doubled
   */
  public void doubleIt(int numToDouble) {
    logger.warn("I was told to double {}", numToDouble);
    this.value = multiplier * numToDouble;
    // Turn this off for now
    someComplicatedFunction();
  }
  
  /**
   * This method only really exists to show tracing.
   */
  private void someComplicatedFunction() {
    Span span = tracer.createSpan("complicated_function");
    tracer.addTag("emotionalBaggage", "doesn't fit in the overhead compartment");
    tracer.close(span);
  }
  
}
