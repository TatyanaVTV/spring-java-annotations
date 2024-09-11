package ru.vtvhw.scopes;

public interface MobileMarket {
    void publish(MobileApp app);
    void printPublishedApps();
    default void doDestroy() {
        System.out.printf("%nDestroying Market bean.%n");
    }
}
