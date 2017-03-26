package ocpm.example.facade;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.inject.Inject;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Shalini on 1/31/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ocpm.example.ContainerExample.class)
@AutoConfigureMockMvc
public class MyAdminStateFacadeTest {

    /** This is a Spring helper object to test making calls to your Controller. */
    @Inject
    private MockMvc mockMvc;

    private MyAdminStateFacade classUnderTest;

    @Test
    public void testAdminStateUp() throws Exception {
        mockMvc.perform(put("/admin-state/up"))
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(get("/admin-state"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("up")));
    }

    @Test
    public void testAdminStateUP() throws Exception {
        mockMvc.perform(put("/admin-state/UP"))
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(get("/admin-state"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("up")));
    }

    @Test
    public void testAdminStateDown() throws Exception {
        mockMvc.perform(put("/admin-state/down"))
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(get("/admin-state"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("down")));
    }

    @Test
    public void testAdminStateDOWN() throws Exception {
        mockMvc.perform(put("/admin-state/DOWN"))
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(get("/admin-state"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("down")));
    }
}
