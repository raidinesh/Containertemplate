package ocpm.example.bl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import java.util.Locale;

/**
 * Created by Shalini on 1/30/2017.
 */

/**
 * The MyAdminState class is a bean which indicates if the application is
 * administratively enabled (true) or disabled (false)
 */
@Service
public class MyAdminState {
    private static final Logger logger = LoggerFactory.getLogger(MyAdminState.class);

    private String value;

    /**
     * Simple constructor
     * Sets the admin state to UP (default)
     */
    public MyAdminState () {
        this.value = "up";
    }

    /**
     * Used by healthengine implementation to determine if the serviec is admin up or down.
     * @return "up" if admin up, "down" if admin down.
     */
    public String getValue() { return this.value; }

    /**
     * Simple setter method that accepts "up" or "down".  Parameter case is folded and stored lower case.
     * @param adminState String of the value "up" or "down"
     */
    public void setValue(String adminState) {
        if ("up".equalsIgnoreCase(adminState) || "down".equalsIgnoreCase(adminState)) {
            logger.info("Setting admin state to {}", adminState);
            // Using a locale is recommended.  Only the English language locale makes sense
            // for this health endpoint.
            this.value = adminState.toLowerCase(Locale.ENGLISH);
        } else {
            logger.warn("Ignoring bad state {}", adminState);
        }
    }
}
