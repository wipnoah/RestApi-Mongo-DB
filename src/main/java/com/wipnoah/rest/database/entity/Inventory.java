package com.wipnoah.rest.database.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.wipnoah.rest.database.entity.NPC;








    @Document(collection = "inventory")
    @Getter
    @Setter
    @ToString

    @AllArgsConstructor
    @NoArgsConstructor
    public class Inventory {

        String id;
        String name;
        String type;
        String quantity;


        public Inventory(final NPC owner, final String name, final String type, final String quantity) {
            this.name = name;
            this.type = type;
            this.quantity = quantity;

        }

    }

