/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocpm.example;

import net.logstash.logback.argument.StructuredArguments;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 *
 * @author Dinesh
 */
@SpringBootApplication
@EnableDiscoveryClient
@SuppressWarnings("squid:S2095") // False positive: Close this "ConfigurableApplicationContext"
public class ContainerExample {

  private static final Logger logger = LoggerFactory.getLogger(ContainerExample.class);

  /**
   * Create an explicit constructor
   */
  public ContainerExample() {
    
  }
  
  public static void main(String[] args) {
    // This is an example of using 'StructuredArguments' to set metadata to a log message.
    logger.warn("{} says: Lunch at {}", "Dinesh", StructuredArguments.value("lunch", "Horseshoe"));
    SpringApplication.run(ContainerExample.class, args);
  }
}
