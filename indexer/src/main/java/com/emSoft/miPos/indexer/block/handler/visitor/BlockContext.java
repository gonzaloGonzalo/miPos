package com.emSoft.miPos.indexer.block.handler.visitor;

import com.emSoft.miPos.indexer.block.model.Block;
import com.emSoft.miPos.indexer.block.model.DriverBlock;
import com.emSoft.miPos.indexer.block.model.RoadMapBlock;
import com.emSoft.miPos.indexer.block.model.VehicleBlock;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by computer on 23/05/18.
 */
public class BlockContext {

    private static Map<String, Class> EVENT_CLASS;

    public enum Event {
        DRIVER_CREATION("driver creation"),
        VEHICLE_CREATION("vehicle creation"),
        ROAD_MAP_CHECK("road map check");

        private String event;

        Event(String event){
            this.event = event;
        }

        public String getValue(){
            return event;
        }
    }

    static {
        EVENT_CLASS = new HashMap<String, Class>();
        EVENT_CLASS.put(Event.DRIVER_CREATION.getValue(), DriverBlock.class);
        EVENT_CLASS.put(Event.VEHICLE_CREATION.getValue(), VehicleBlock.class);
        EVENT_CLASS.put(Event.ROAD_MAP_CHECK.getValue(), RoadMapBlock.class);
    }

    public static Block build(String event) throws IllegalArgumentException{
        Block block;
        try {
            Class classResult = EVENT_CLASS.get(event);
            block = (Block) classResult.newInstance();
            return block;
        }
        catch (Exception ex){
            throw new IllegalStateException("Error getting class for event.");
        }
    }
}
