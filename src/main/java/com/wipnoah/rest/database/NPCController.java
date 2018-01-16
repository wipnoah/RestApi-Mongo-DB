package com.wipnoah.rest.database;

import com.wipnoah.rest.database.models.NPC;
import com.wipnoah.rest.database.NPCRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;


@RestController
public class NPCController {
    @Autowired
    NPCRepository NPCRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/npcs/findall")
    public Iterable<NPC> NPC() {
        return NPCRepository.findAll();
    }

    /*@RequestMapping(method=RequestMethod.GET, value="/npcs/{id}")
    public NPC show(@PathVariable String id) {
        return NPCRepository.findOne(id);

    }*/

    @RequestMapping(method = RequestMethod.GET, value = "/npcs/findbyid")
    public NPC show(@RequestParam (value="id")String id) {
        return NPCRepository.findOne(id);

    }

    @RequestMapping(method = RequestMethod.GET, value = "/npcs/findbyname")
    public NPC showbyname(@RequestParam (value="name")String name) {
        return NPCRepository.findByNameIgnoreCase(name);

    }

    @RequestMapping(method = RequestMethod.POST, value = "/npcs")
    public NPC save(@RequestBody NPC npc) {
        NPCRepository.save(npc);

        return npc;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/npcs/{id}")
    public String delete(@PathVariable String id) {
        NPC npc = NPCRepository.findOne(id);
        NPCRepository.delete(npc);

        return "NPC deleted";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/npcs/deleteall")
    public Iterable<NPC> NPCkill() {
        NPCRepository.deleteAll();
        return NPCRepository.findAll();


    }
}
