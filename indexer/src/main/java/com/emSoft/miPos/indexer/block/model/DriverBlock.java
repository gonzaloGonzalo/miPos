package com.emSoft.miPos.indexer.block.model;

import com.emSoft.miPos.indexer.block.handler.visitor.BlockVisitor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.ZonedDateTime;
import java.util.Map;

/**
 * Created by computer on 23/05/18.
 */
@Entity
@Table(name = "driver")
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

    public void mapValues(Map<String, String> messageMap){
        super.mapValues(messageMap);
    }
}
