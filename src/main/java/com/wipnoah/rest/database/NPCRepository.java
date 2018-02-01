package com.wipnoah.rest.database;


import com.wipnoah.rest.database.entity.NPC;
import java.util.List;



import org.springframework.data.mongodb.repository.MongoRepository;


public interface NPCRepository extends MongoRepository<NPC, String>{

        //@Override
        NPC findOne(String id);



    NPC findByNameIgnoreCase(String name);

    @Override
    void delete(NPC deleted);
}