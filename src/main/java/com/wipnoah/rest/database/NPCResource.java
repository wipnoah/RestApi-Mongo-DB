package com.wipnoah.rest.database;

import com.wipnoah.rest.database.NPCController;
import com.wipnoah.rest.database.InventoryController;
import com.wipnoah.rest.database.entity.Inventory;
import com.wipnoah.rest.database.entity.NPC;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.data.mongodb.*;
import org.springframework.hateoas.Link;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


@Getter

public class NPCResource extends ResourceSupport {
    private NPC npc;

    public NPCResource(final NPC npc) {
        this.npc = npc;
        final String id = npc.getId();
        add(linkTo(NPCController.class).withRel("npcs"));
        add(linkTo(methodOn(InventoryController.class).allItems(id)).withRel("Inventory"));

        add(linkTo(methodOn(NPCController.class).get(id)).withSelfRel());



    }
}




