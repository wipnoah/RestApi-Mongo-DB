package com.wipnoah.rest.database;


import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;


import com.wipnoah.rest.database.entity.NPC;
import com.wipnoah.rest.database.NPCRepository;
import com.wipnoah.rest.database.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.hateoas.Link;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;


import java.util.List;
import java.net.URI;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Collections;


@RestController
@RequestMapping(value = "/npcs", produces = "application/hal+json")

public class NPCController {


    final NPCRepository npcRepository;

    public NPCController(final NPCRepository npcRepository) {
        this.npcRepository = npcRepository;
    }

    /*@RequestMapping(method = RequestMethod.GET, value = "/npcs")
    public HttpEntity<NPC> npcs(@RequestParam (value="name")String name) {

        NPC npcs = new NPC(name);
        npcs.add(linkTo(methodOn(NPCController.class).npcs(name)).withSelfRel());

        return new ResponseEntity<NPC>(npcs,HttpStatus.OK);


    }*/

   /* @RequestMapping(method = RequestMethod.GET, value = "/npcs")
    public Iterable<NPC> NPC() {
        return NPCRepository.findAll();
    } */


    @GetMapping
    public ResponseEntity<Resources<NPCResource>> all() {
        final List<NPCResource> collection =
                npcRepository.findAll().stream().map(NPCResource::new).collect(Collectors.toList());

        final Resources<NPCResource> resources = new Resources<>(collection);
        final String uriString = ServletUriComponentsBuilder.fromCurrentRequest().build().toUriString();
        resources.add(new Link(uriString, "self"));

        return ResponseEntity.ok(resources);
    }

    @GetMapping({"/{id}"})

    public ResponseEntity<NPCResource> get(@PathVariable final String id) {
        final NPCResource resource = new NPCResource(npcRepository.findOne(id));
        final String uriString = ServletUriComponentsBuilder.fromCurrentRequest().build().toUriString();
        resource.add(new Link(uriString, "self"));
        return ResponseEntity.ok(resource);


    }






    /*@RequestMapping(method = RequestMethod.GET, value = "/npcs/{name}")
    public NPC showbyname(@RequestParam (value="name")String name) {
        return NPCRepository.findByNameIgnoreCase(name);

    }*/

    @RequestMapping(method = RequestMethod.POST, value = "/npcs")
    public NPC save(@RequestBody NPC npc) {
        npcRepository.save(npc);

        return npc;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/npcs/{id}")
    public String delete(@PathVariable String id) {
        NPC npc = npcRepository.findOne(id);
        npcRepository.delete(id);

        return "NPC deleted";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/npcs/deleteall")
    public Iterable<NPC> NPCkill() {
        npcRepository.deleteAll();
        return npcRepository.findAll();


    }

}
