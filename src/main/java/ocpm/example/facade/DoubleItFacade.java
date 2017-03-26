/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocpm.example.facade;

import ocpm.example.bl.DoubleItBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Shalini
 */
@RestController
@RequestMapping("/example")
public class DoubleItFacade {

  private final DoubleItBusiness bl;

  @Autowired
  public DoubleItFacade(DoubleItBusiness bl) {
    this.bl = bl;
  }

  /**
   * Retrieve the current value
   *
   * @return The current stored value
   */
  @RequestMapping("/value")
  public int getCurrentValue() {
    return bl.getValue();
  }

  /**
   * Set the value to twice the number provided
   *
   * @param number - The number to double
   */
  @RequestMapping(value = "doubleit/{number}", method = RequestMethod.POST)
  public void add(@PathVariable int number) {
    bl.doubleIt(number);
  }
}
