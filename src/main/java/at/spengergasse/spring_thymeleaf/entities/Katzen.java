package at.spengergasse.spring_thymeleaf.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Katzen {
        @Id
        private String name;
        private String rasse;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRasse() {
            return rasse;
        }

        public void setRasse(String rasse) {
            this.rasse = rasse;
        }
}
