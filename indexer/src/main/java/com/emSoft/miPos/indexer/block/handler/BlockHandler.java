package com.emSoft.miPos.indexer.block.handler;

import com.emSoft.miPos.indexer.block.handler.visitor.BlockHelper;
import com.emSoft.miPos.indexer.block.handler.visitor.BlockVisitor;
import com.emSoft.miPos.indexer.block.handler.visitor.impl.BlockVisitorImpl;
import com.emSoft.miPos.indexer.block.model.Block;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by computer on 23/05/18.
 */
public class BlockHandler {

    public static void main(String args[]){
        BlockVisitor blockVisitor = new BlockVisitorImpl();
        Map<String, String> block = new HashMap<>();
        block.put("event", "road map check");
        Block blck = BlockHelper.build(block);
        blck.accept(blockVisitor);
    }



}
