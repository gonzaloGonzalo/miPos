package com.emSoft.miPos.indexer.block.handler;

import com.emSoft.miPos.indexer.block.consumer.BrokerConsumer;
import com.emSoft.miPos.indexer.block.consumer.mosquittoConsumer.MqttConsumer;

/**
 * Created by computer on 23/05/18.
 */
public class BlockHandler {

    public static void main(String args[])throws Exception{
        BrokerConsumer brokerConsumer = new MqttConsumer();
        brokerConsumer.consume();
    }
}
