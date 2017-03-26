package ocpm.example.healthengine;

/**
 * Created by Shalini on 1/29/2017.
 */

/**
 * Common API used by application to determine application-health.
 */
public interface HealthEngineInterface {
    /**
     * Performs internal application-specific health checks.
     * @return true if application is health, false if application is not healthy.
     */
    public boolean isHealthy();

    /**
     * Returns a revision string specific to the application health check implementation
     * e.g. HEALTH-ENGINE-RANDOM, or HEALTH-CHECK-TIER-ONE-APP
     * @return returns a string to describe the health engine implementation.
     */
    public String getRevision();
}

