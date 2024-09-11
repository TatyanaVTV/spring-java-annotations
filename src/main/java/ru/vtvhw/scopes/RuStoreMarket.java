package ru.vtvhw.scopes;

import java.util.ArrayList;
import java.util.List;

public class RuStoreMarket implements MobileMarket {
    private String name;
    private List<MobileApp> apps = new ArrayList<>();

    public RuStoreMarket() {
        this.name = "RuStore";
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
        return String.format("Market '%s' [%s]", name, super.toString());
    }
}
