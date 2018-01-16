package com.wipnoah.rest.database;


import com.wipnoah.rest.database.models.NPC;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface NPCRepository extends CrudRepository<NPC, String> {
    @Override
    NPC findOne(String id);

    NPC findByNameIgnoreCase(String name);

    @Override
    void delete(NPC deleted);
}