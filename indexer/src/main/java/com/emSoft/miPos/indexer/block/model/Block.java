package com.emSoft.miPos.indexer.block.model;

import com.emSoft.miPos.indexer.block.handler.visitor.BlockVisitor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.ZonedDateTime;
import java.util.Map;

/**
 * Created by computer on 23/05/18.
 */
public abstract class Block {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private String event;
    private String UUID;
    private ZonedDateTime date;

    public void mapValues(Map<String, String> messageMap){
        this.event = (messageMap.get("event"));
        this.UUID = (messageMap.get("UUID"));
        this.date = (ZonedDateTime.parse(messageMap.get("date")));
    }

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
