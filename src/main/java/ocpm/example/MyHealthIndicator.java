package ocpm.example;

/**
 * Created by Shalini on 1/27/2017.
 */

import ocpm.example.healthengine.HealthEngineInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * Application Health Check Indicator
 * Performs application-specific health tests.
 * Creates the proper up or down response to health-check queries.
 */
@Component
public class MyHealthIndicator implements HealthIndicator {

    private static final Logger logger = LoggerFactory.getLogger(MyHealthIndicator.class);

    private static final String DESCRIPTION_STR = "description";
    private static final String VERSION_STR = "version";
    private static final String VER_VAL_STR = "1.0.0";
    private static final String HEALTH_ENGINE_STR = "healthengine";
    private static final String DESC_VAL_STR = "OCPM-CONTAINER-EXAMPLE";

    // IMPLEMENTATION HOOK
    // This should be replaced with a real health engine implementation
    private HealthEngineInterface healthEngine;

    /**
     * Constructor for the Health Check Indicator class
     * @param healthEngine healthengine implements the HealthEngineInterface
     */
    @Autowired
    public MyHealthIndicator(HealthEngineInterface healthEngine) {
        this.healthEngine = healthEngine;
    }

    /**
     * MyHealthIndicator calls respondUp when healthengine indicates that application is healthy.
     * Creates a health object that contains the proper details to indicate that the application is healthy.
     * @param revision String indicating the health engine implementation revision
     * @return health object indicating that application is up and running
     */
    protected Health respondUp(String revision)
    {
        return Health.up().withDetail(DESCRIPTION_STR, DESC_VAL_STR).withDetail(VERSION_STR, VER_VAL_STR).withDetail(HEALTH_ENGINE_STR, revision).build();
    }

    /**
     * MyHealthIndicator calls respondDown when healthengine indicates that application is not healthy.
     * Creates a health object that contains the proper details to indicate that the application is not healthy.
     * @param revision String indicating the health engine implementation revision
     * @return health object indicating our application is down
     */
    protected Health respondDown(String revision) {
        return Health.down().withDetail(DESCRIPTION_STR, DESC_VAL_STR).withDetail(VERSION_STR, VER_VAL_STR).withDetail(HEALTH_ENGINE_STR, revision).build();
    }

    /**
     * Returns a health object with the correct response status UP or DOWN.
     * @return health object indicating our application is up or down
     */
    @Override
    public Health health() {

        Health myHealth;

        try {
            String rev = healthEngine.getRevision();

            myHealth = respondDown(rev);
            if (healthEngine.isHealthy()) {
                myHealth = respondUp(rev);
            }
            return myHealth;

        } catch(RuntimeException e) {
            logger.warn("HealthEngine encountered error", e);
            return Health.down(e).build();
        }
    }

}
