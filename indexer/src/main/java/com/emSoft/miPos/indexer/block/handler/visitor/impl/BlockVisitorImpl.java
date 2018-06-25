package com.emSoft.miPos.indexer.block.handler.visitor.impl;

import com.emSoft.miPos.indexer.block.handler.visitor.BlockVisitor;
import com.emSoft.miPos.indexer.block.model.DriverBlock;
import com.emSoft.miPos.indexer.block.model.RoadMapBlock;
import com.emSoft.miPos.indexer.block.model.VehicleBlock;
import com.emSoft.miPos.indexer.block.persistence.BlockDAO;
import com.emSoft.miPos.indexer.block.persistence.DriverBlockDAOImpl;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Created by computer on 23/05/18.
 */
public class BlockVisitorImpl implements BlockVisitor {
    private static final Logger LOGGER = Logger.getLogger(BlockVisitorImpl.class.getName());

    public void visit(DriverBlock driverBlock){
        LOGGER.log(Level.INFO, driverBlock.getClass().getCanonicalName());
        BlockDAO driverDAO = new DriverBlockDAOImpl();
        driverDAO.create(driverBlock);
    }

    public void visit(VehicleBlock vehicleBlock){
        LOGGER.log(Level.INFO, vehicleBlock.getClass().getCanonicalName());
    }

    public void visit(RoadMapBlock roadMapBlock){
        LOGGER.log(Level.INFO, roadMapBlock.getClass().getCanonicalName());
    }
}
