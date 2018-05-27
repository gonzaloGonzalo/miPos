package com.emSoft.miPos.indexer.block.consumer.mosquittoConsumer;

import com.emSoft.miPos.indexer.block.handler.visitor.BlockHelper;
import com.emSoft.miPos.indexer.block.handler.visitor.BlockVisitor;
import com.emSoft.miPos.indexer.block.handler.visitor.impl.BlockVisitorImpl;
import com.emSoft.miPos.indexer.block.model.Block;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.util.HashMap;
import java.util.Map;

public class SimpleMqttCallBack implements MqttCallback {

  public void connectionLost(Throwable throwable) {
    System.out.println("Connection to MQTT broker lost!");
  }

  public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
    System.out.println("Message received:\t"+ new String(mqttMessage.getPayload()) );
    BlockVisitor blockVisitor = new BlockVisitorImpl();
    Map<String, String> block = new HashMap<>();
    block.put("event", "road map check");
    Block blck = BlockHelper.build(block);
    blck.accept(blockVisitor);
  }

  public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
  }
}
