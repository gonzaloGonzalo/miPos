package com.emSoft.miPos.indexer.block.model;

import com.emSoft.miPos.indexer.block.handler.visitor.BlockVisitor;

/**
 * Created by computer on 24/05/18.
 */
public class VehicleBlock extends Block {

    private VehicleAttributes vehicleAttributes;

    public void accept(final BlockVisitor blockVisitor){
        blockVisitor.visit(this);
    }

    public VehicleAttributes getVehicleAttributes() {
        return vehicleAttributes;
    }

    public void setVehicleAttributes(VehicleAttributes vehicleAttributes) {
        this.vehicleAttributes = vehicleAttributes;
    }
}
