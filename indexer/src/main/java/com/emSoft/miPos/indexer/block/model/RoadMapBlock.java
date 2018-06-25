package com.emSoft.miPos.indexer.block.model;

import com.emSoft.miPos.indexer.block.handler.visitor.BlockVisitor;

import java.util.Map;

/**
 * Created by computer on 24/05/18.
 */
public class RoadMapBlock extends Block{

    private RoadMapExtra roadMapExtra;
    private VehicleExtra vehicleExtra;

    public void accept(final BlockVisitor blockVisitor){
        blockVisitor.visit(this);
    }

    public RoadMapExtra getRoadMapExtra() {
        return roadMapExtra;
    }

    public void setRoadMapExtra(RoadMapExtra roadMapExtra) {
        this.roadMapExtra = roadMapExtra;
    }

    public VehicleExtra getVehicleExtra() {
        return vehicleExtra;
    }

    public void setVehicleExtra(VehicleExtra vehicleExtra) {
        this.vehicleExtra = vehicleExtra;
    }

    public void mapValues(Map<String, String> messageMap){

    }
}
