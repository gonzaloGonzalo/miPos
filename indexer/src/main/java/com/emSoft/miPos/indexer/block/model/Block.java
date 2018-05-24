package com.emSoft.miPos.indexer.block.model;

import com.emSoft.miPos.indexer.block.handler.visitor.BlockVisitor;

import java.time.ZonedDateTime;

/**
 * Created by computer on 23/05/18.
 */
public abstract class Block {

    private String event;
    private String UUID;
    private ZonedDateTime date;

    public abstract void accept(BlockVisitor blockVisitor);

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public void setDate(ZonedDateTime date) {
        this.date = date;
    }
}
