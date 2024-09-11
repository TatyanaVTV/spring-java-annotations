package ru.vtvhw.vtvhw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import ru.vtvhw.scopes.*;

@Configuration
@PropertySource("classpath:application.properties")
public class SpringConfig {
    @Autowired
    private Environment env;

    @Bean
    @Scope("singleton")
    public ApiKey apiKey() {
        System.out.println("Initialising ApiKey in SpringConfig.");
        return new ApiKey(env.getProperty("apiKey.value", "ApiKey value is not set!"));
    }

    @Bean
    @Scope("singleton")
    public MobileMarket market() {
        System.out.println("Initialising MobileMarket in SpringConfig.");
        String marketName = env.getProperty("market.name", "ruStore");
        if (marketName.equals("ruStore")) {
            return new RuStoreMarket(apiKey());
        } else return new GooglePlayMarket(apiKey());
    }

    @Bean
    @Scope("prototype")
    public MobileApp mobileApp() {
        System.out.println("Initialising MobileApp in SpringConfig.");
        return MobileApp.createMobileApp(env.getProperty("mobileApp.defaultName", "Default Mobile App name"));
    }
}
