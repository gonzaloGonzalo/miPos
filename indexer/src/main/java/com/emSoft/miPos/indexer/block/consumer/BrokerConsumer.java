package com.emSoft.miPos.indexer.block.consumer;

import org.eclipse.paho.client.mqttv3.MqttException;

/**
 * Created by computer on 24/05/18.
 */
public interface BrokerConsumer {

    void consume() throws Exception;
}
