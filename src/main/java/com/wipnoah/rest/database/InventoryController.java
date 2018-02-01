package com.wipnoah.rest.database;


import com.wipnoah.rest.database.entity.NPC;
import com.wipnoah.rest.database.entity.Inventory;
import com.wipnoah.rest.database.InventoryRepository;
import com.wipnoah.rest.database.NPCRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.hateoas.Link;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController

public class InventoryController {

    NPCRepository npcRepository;

    InventoryRepository inventoryRepository;

    public InventoryController(
            NPCRepository npcRepository,
            InventoryRepository inventoryRepository) {
        this.npcRepository = npcRepository;
        this.inventoryRepository = inventoryRepository;


    }

    @GetMapping ({"/{id}/inventory"})
    public ResponseEntity<Resources<InventoryResource>> allItems(@PathVariable("id") final String npcId) {
        final List<InventoryResource> collection = npcRepository.findOne(npcId).getGear().stream().map(InventoryResource::new).collect(Collectors.toList());
        final Resources<InventoryResource> resources = new Resources<>(collection);
        final String uriString = ServletUriComponentsBuilder.fromCurrentRequest().build().toUriString();
        resources.add(new Link(uriString, "self"));
        return ResponseEntity.ok(resources);
    }


}







