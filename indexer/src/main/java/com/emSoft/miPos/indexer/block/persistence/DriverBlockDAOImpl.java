package com.emSoft.miPos.indexer.block.persistence;

import com.emSoft.miPos.indexer.block.model.Block;
import com.emSoft.miPos.indexer.block.model.DriverBlock;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by computer on 24/06/18.
 */
public class DriverBlockDAOImpl extends BlockDAO {

    public Integer create(Block block){
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.save(block);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully created " + block.toString());
        return block.getId();
    }
    public List<Block> read(){
        return null;
    }
    public Block findById(Integer id){
        return null;
    }
    public void update(Block block){

    }
    public void delete(Integer id){

    }
}
