package com.emSoft.miPos.indexer.block.handler.visitor;

import com.emSoft.miPos.indexer.block.model.DriverBlock;
import com.emSoft.miPos.indexer.block.model.RoadMapBlock;
import com.emSoft.miPos.indexer.block.model.VehicleBlock;

/**
 * Created by computer on 23/05/18.
 */
public interface BlockVisitor {

    void visit(DriverBlock driverBlock);
    void visit(VehicleBlock driverBlock);
    void visit(RoadMapBlock roadMapBlock);

}
