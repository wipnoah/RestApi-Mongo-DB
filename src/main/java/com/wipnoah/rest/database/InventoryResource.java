package com.wipnoah.rest.database;

import com.wipnoah.rest.database.entity.NPC;
import lombok.Getter;
import org.springframework.hateoas.ResourceSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import com.wipnoah.rest.database.NPCController;
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
public class InventoryResource extends ResourceSupport {

    private Inventory inventory;


    public InventoryResource(final Inventory inventory) {
        this.inventory = inventory;
        final String id = inventory.getId();
        add(linkTo(NPCController.class).withRel("npcs/{id}"));
        add(linkTo(methodOn(NPCController.class).get(id)).withSelfRel());



    }
}

