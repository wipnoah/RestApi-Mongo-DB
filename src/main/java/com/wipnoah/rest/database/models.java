package com.wipnoah.rest.database;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

public class models {

    @Document(collection = "npcs")
    public static class NPC {
        @Id
        String id;

        String name;
        String race;

        String[] gear;

        /*public NPC() {

        }

        public NPC(String name, String race) {
            this.name = name;
            this.race = race;

        }*/
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRace() {
            return race;
        }

        public void setRace(String race) {
            this.race = race;
        }

        public void setGear(String []gear) {
            this.gear = gear;
        }

        public String[] getGear() {
            return gear;
        }


    }
}
