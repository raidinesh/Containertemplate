package ocpm.example.healthengine;


import ocpm.example.bl.MyAdminState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by Shalini  on 1/28/2017.
 */

/**
 * This class implements the Common Health Engine API used to check the application health.
 * The isHealthy method internally tests all aspects of the application and is used by a HealthIndicator class
 * to return a status of UP or DOWN to health check queries.
 *
 * This implementation depends on an admin state class.  The AdminState class holds one aspect of the application state.
 */
@Service
public class HealthEngineExample implements HealthEngineInterface {

    private static final Logger logger = LoggerFactory.getLogger(HealthEngineExample.class);

    private final MyAdminState state;

    /**
     * Constructor for the class.  The admin state dependency is injected here.
     * @param state, an AdminState class which determines one aspect of the application health.
     */
    @Autowired
    public HealthEngineExample(MyAdminState state) {
        this.state = state;
    }

    @Override
    public boolean isHealthy() {
        // IMPLEMENTATION SPECIFICS
        // Application should replace this logic with their own health logic.
        // Need to return true for healthy and false for un-healthy
        boolean healthy = "up".equalsIgnoreCase(state.getValue());
        logger.warn("We are reporting healthy = {}", healthy);
        return healthy;
    }

    /**
     * This method returns a revision string which indicates the version and/or name of the HealthEngine implementation.
     * @return a string which indicates the specific health engine implementation.
     */
    @Override
    public String getRevision() {
        return "HEALTH-ENGINE-UP-N-RUNNING";
    }
}
