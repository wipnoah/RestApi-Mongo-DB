package com.wipnoah.rest.database;

import com.wipnoah.rest.database.entity.Inventory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InventoryRepository extends MongoRepository<InventoryRepository, Long> {
}
