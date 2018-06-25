package com.emSoft.miPos.indexer.block.persistence;

import com.emSoft.miPos.indexer.block.model.Block;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Created by computer on 24/06/18.
 */
public abstract class BlockDAO {

    public static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration
                .buildSessionFactory(builder.build());
        return sessionFactory;
    }

    public abstract Integer create(Block block);
    public abstract List<Block> read();
    public abstract Block findById(Integer id);
    public abstract void update(Block block);
    public abstract void delete(Integer id);

}
