package by.pvt.security;

import by.pvt.configuration.SecurityConfiguration;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer {

    public SecurityInitializer(){
        super(SecurityConfiguration.class);
    }
}
