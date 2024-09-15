package ru.vtvhw.scopes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("ruStore")
@Scope("singleton")
@Lazy
public class RuStoreMarket implements MobileMarket {
    private String name;
    private List<MobileApp> apps = new ArrayList<>();

    @Autowired
    private ApiKey apiKey;

    public RuStoreMarket(ApiKey apiKey) {
        this.name = "RuStore";
        this.apiKey = apiKey;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void publish(MobileApp app) {
        apps.add(app);
    }

    @Override
    public void printPublishedApps() {
        System.out.printf("%s: %n", this);
        apps.forEach(System.out::println);
    }

    @Override
    public String toString() {
        return String.format("Market '%s' (%s) [%s]", name, apiKey, super.toString());
    }
}