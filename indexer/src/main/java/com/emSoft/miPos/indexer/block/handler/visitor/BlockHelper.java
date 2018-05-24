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
public class BlockHelper {

    private static final String DRIVER_CREATION = "driver creation";
    private static final String VEHICLE_CREATION = "vehicle creation";
    private static final String ROAD_MAP_CHECK = "road map check";

    private static final Map<String, Class> CLASS_EVENT;
    private static final ObjectMapper MAPPER;

    static {
        CLASS_EVENT = new HashMap<>();
        MAPPER = new ObjectMapper().findAndRegisterModules();

        CLASS_EVENT.put(DRIVER_CREATION, DriverBlock.class);
        CLASS_EVENT.put(VEHICLE_CREATION, VehicleBlock.class);
        CLASS_EVENT.put(ROAD_MAP_CHECK, RoadMapBlock.class);
    }

    public static Block build(Map map){
        String event = (String) map.get("event");
        if("".equals(event)){
            throw new IllegalArgumentException("");
        }
        Class classResult = CLASS_EVENT.get(event);
        if(classResult != null){
            return (Block) MAPPER.convertValue(map, classResult);
        }
        else {
            throw new IllegalArgumentException("");
        }
    }
}
