package com.emSoft.miPos.indexer.block.handler.visitor.impl;

import com.emSoft.miPos.indexer.block.handler.visitor.BlockVisitor;
import com.emSoft.miPos.indexer.block.model.DriverBlock;
import com.emSoft.miPos.indexer.block.model.RoadMapBlock;
import com.emSoft.miPos.indexer.block.model.VehicleBlock;

/**
 * Created by computer on 23/05/18.
 */
public class BlockVisitorImpl implements BlockVisitor {

    public void visit(DriverBlock driverBlock){
        System.out.println(driverBlock.getClass().getCanonicalName());
    }

    public void visit(VehicleBlock vehicleBlock){
        System.out.println(vehicleBlock.getClass().getCanonicalName());
    }

    public void visit(RoadMapBlock roadMapBlock){
        System.out.println(roadMapBlock.getClass().getCanonicalName());
    }
}
