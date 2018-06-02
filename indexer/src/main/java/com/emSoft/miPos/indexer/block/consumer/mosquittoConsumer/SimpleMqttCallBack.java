package com.emSoft.miPos.indexer.block.consumer.mosquittoConsumer;

import com.emSoft.miPos.indexer.block.handler.visitor.BlockContext;
import com.emSoft.miPos.indexer.block.handler.visitor.BlockVisitor;
import com.emSoft.miPos.indexer.block.handler.visitor.impl.BlockVisitorImpl;
import com.emSoft.miPos.indexer.block.model.Block;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.lang.reflect.Type;
import java.util.Map;


public class SimpleMqttCallBack implements MqttCallback {

  private static final Logger LOGGER = Logger.getLogger(SimpleMqttCallBack.class.getName());

  public void connectionLost(Throwable throwable) {
    System.out.println("Connection to MQTT broker lost!");
  }

  public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
    try {
      String message = new String(mqttMessage.getPayload());
      LOGGER.log(Level.INFO, "Message received:\t"+ message);
      BlockVisitor blockVisitor = new BlockVisitorImpl();
      Block blck = BlockContext.build(getEventType(message));
      blck.accept(blockVisitor);
    }
    catch (Exception ex){
      LOGGER.log(Level.INFO, "Message not received:\t"+ ex.getMessage());
    }

  }

  public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
  }

  private String getEventType(String message){
    Type type = new TypeToken<Map<String, String>>(){}.getType();
    Map<String, String> messageMap = new Gson().fromJson(message, type);
    String event = messageMap.get("event");
    return event;
  }
}
