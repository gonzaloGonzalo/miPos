package com.emSoft.miPos.indexer.block.model;

import com.emSoft.miPos.indexer.block.handler.visitor.BlockVisitor;

/**
 * Created by computer on 23/05/18.
 */
public class DriverBlock extends Block {

    private DriverAttributes driverAttributes;

    public void accept(final BlockVisitor blockVisitor){
        blockVisitor.visit(this);
    }

    public DriverAttributes getDriverAttributes() {
        return driverAttributes;
    }

    public void setDriverAttributes(DriverAttributes driverAttributes) {
        this.driverAttributes = driverAttributes;
    }
}
