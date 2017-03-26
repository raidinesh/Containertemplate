/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocpm.example.facade;

import javax.inject.Inject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.containsString;
  
/**
 *
 * @author Chris
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ocpm.example.ContainerExample.class)
@AutoConfigureMockMvc
public class DoubleItFacadeTest {
  
  /** This is a Spring helper object to test making calls to your Controller. */
  @Inject
  private MockMvc mockMvc;
  
  @Test
  public void testSimpleSet() throws Exception {
    
    mockMvc.perform(post("/example/doubleit/11"))
      .andDo(print())
      .andExpect(status().isOk());
    
    mockMvc.perform(get("/example/value"))
      .andDo(print())
      .andExpect(status().isOk())
      .andExpect(content().string(containsString("22")));
  }
}
