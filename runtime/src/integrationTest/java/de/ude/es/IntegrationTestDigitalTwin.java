package de.ude.es;

import de.ude.es.comm.HivemqBroker;
import de.ude.es.twin.CloudTwin;

public class IntegrationTestDigitalTwin {
    private static final String DOMAIN = "eip://uni-due.de/es";
    private static final String IP = "localhost";
    private static final int PORT = 1883;

    public static void main(String[] args) throws InterruptedException {
        HivemqBroker broker = new HivemqBroker(DOMAIN, IP, PORT);

        CloudTwin sendingTwin = new CloudTwin("sendingTwin");
        sendingTwin.bind(broker);
        CloudTwin receivingTwin = new CloudTwin("receivingTwin");
        receivingTwin.bind(broker);

        receivingTwin.subscribeForData("sendingTwin", "test");

        while (true) {
            sendingTwin.publishData("test", "testData");
            Thread.sleep(1000);
        }
    }
}
