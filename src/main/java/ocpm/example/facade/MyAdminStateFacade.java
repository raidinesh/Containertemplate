package ocpm.example.facade;

import ocpm.example.bl.MyAdminState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Shalini on 1/30/2017.
 */

/**
 * The MyAdminStateFacade class implements the REST controller which handles incoming requests to the
 * /admin-state endpoint
 */
@RestController
public class MyAdminStateFacade {

    private final MyAdminState state;

    @Autowired
    public MyAdminStateFacade(MyAdminState state) {
        this.state = state;
    }

    /**
     * Retrieve the current value
     *
     * @return The current stored value
     */
    @RequestMapping("/admin-state")
    public String getCurrentValue() {
        return state.getValue();
    }

    /**
     * Set the value to the admin state
     *
     * @param adminState - The admin state ("up" or "down")
     */
    @RequestMapping(value = "/admin-state/{adminState}", method = RequestMethod.PUT)
    public void set(@PathVariable String adminState) {
        state.setValue(adminState);
    }
}
