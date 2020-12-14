package es.uclm.esi.iso2.bc4.Yakitoro.dao;

public class Broker {
    private ConnectionDataBase db;

    private Broker() {
        db = new ConnectionDataBase();
    }

    private static class BrokerHolder {
        static Broker singleton = new Broker();
    }

    public static Broker get() {
        return BrokerHolder.singleton;
    }

    public ConnectionDataBase getBd(){
        return db;
    }
}
