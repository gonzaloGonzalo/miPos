package com.emSoft.miPos.indexer.block.consumer.mosquittoConsumer;

import com.emSoft.miPos.indexer.block.consumer.BrokerConsumer;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;



/**
 * Created by computer on 24/05/18.
 */
public class MqttConsumer implements BrokerConsumer {

    private static final Logger LOGGER = Logger.getLogger(MqttConsumer.class.getName());

    private final static String HOST = "localhost";
    private final static String PORT = "1883";
    private final static String TOPIC = "iot_data";

    @Override
    public void consume() throws MqttException {
        LOGGER.log(Level.INFO, "== START SUBSCRIBER ==");
        MqttClient client=new MqttClient(generateURL(), MqttClient.generateClientId());
        client.setCallback( new SimpleMqttCallBack());
        client.connect();
        client.subscribe(TOPIC);

    }

    private String generateURL(){
        StringBuilder url = new StringBuilder();
        url.append("tcp://");
        url.append(HOST);
        url.append(":");
        url.append(PORT);
        return url.toString();
    }
}
