package com.wipnoah.rest.database.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.xml.internal.bind.v2.model.core.ID;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;

import java.util.List;


@Document(collection = "npcs")
@Getter
@Setter
@Entity

public class NPC {
    @Id

    Long id;

    String name;
    String race;

    @JsonIgnore
    List<Inventory> gear;


    ;

    public NPC() {
    }

    ;

    public NPC(final NPC npc) {
        this.name = npc.getName();
        this.race = npc.getRace();
        this.gear = npc.getGear();


    }

    public NPC(final NPC npc, final Long id) {
        this.id = id;
        this.name = npc.getName();
        this.race = npc.getRace();
        this.gear = npc.getGear();

    }


}
