package de.ude.es.twin;

import de.ude.es.comm.Protocol;
import de.ude.es.comm.Subscriber;

public class CloudTwin extends DigitalTwin {

    Protocol protocol;
    Subscriber subscriber = posting -> System.out.println("Received data: " + posting.data());

    public CloudTwin(String identifier) {
        super(identifier);
    }

    public void subscribeForData(String twin, String dataId) {
        protocol.subscribeForData(twin, dataId, subscriber);
    }

    public void publishData(String dataId, String data) {
        protocol.publishData(dataId, data);
    }

    @Override
    protected void executeOnBind() {
        protocol = new Protocol(this);
    }

}
