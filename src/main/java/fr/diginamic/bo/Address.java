package fr.diginamic.bo;

import jakarta.persistence.*;
import java.io.Serializable;

    /**
     * Représente une adresse.
     * Une adresse est associée à un magasin d'animaux.
     * Cette classe est mappée à une table de base de données en utilisant les annotations JPA.
     */
    @Entity
    public class Address implements Serializable {

        /** Identifiant unique de l'adresse */
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "ID")
        private long Id;

        /** Numéro de l'adresse */
        @Column(name = "NUMBER")
        private String number;

        /** Rue de l'adresse */
        @Column(name = "STREET")
        private String street;

        /** Code postal de l'adresse */
        @Column(name = "ZIP_CODE")
        private String zipCode;

        /** Ville de l'adresse */
        @Column(name = "CITY")
        private String city;

        /** Magasin d'animaux associé à cette adresse */
        @OneToOne(mappedBy = "address")
        private PetStore petStore;

    /**
     * Constructeur par défaut
     */
    public Address() {
    }

        /**
         * Constructeur avec paramètres
         * @param number Numéro de l'adresse
         * @param street Rue de l'adresse
         * @param zipCode Code postal de l'adresse
         * @param city Ville de l'adresse
         */
    public Address(String number, String street, String zipCode, String city) {
        this.number = number;
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
    }


        /**
         * Getter
         * @return Id
         */
        public long getId() {
            return Id;
        }


        /**
         * Getter
         * @return number
         */
        public String getNumber() {
            return number;
        }

        /**
         * Setter
         * @param number number
         */
        public void setNumber(String number) {
            this.number = number;
        }

        /**
         * Getter
         * @return street
         */
        public String getStreet() {
            return street;
        }

        /**
         * Setter
         * @param street street
         */
        public void setStreet(String street) {
            this.street = street;
        }

        /**
         * Getter
         * @return zipCode
         */
        public String getZipCode() {
            return zipCode;
        }

        /**
         * Setter
         * @param zipCode zipCode
         */
        public void setZipCode(String zipCode) {
            this.zipCode = zipCode;
        }

        /**
         * Getter
         * @return city
         */
        public String getCity() {
            return city;
        }

        /**
         * Setter
         * @param city city
         */
        public void setCity(String city) {
            this.city = city;
        }

        /**
         * Getter
         * @return petStore
         */
        public PetStore getPetStore() {
            return petStore;
        }

        /**
         * Setter
         * @param petStore petStore
         */
        public void setPetStore(PetStore petStore) {
            this.petStore = petStore;
        }

        /**
         * Représentation en chaîne de caractères de l'objet Address
         * @return représentation en chaîne de caractères
         */
        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Address{");
            sb.append("Id=").append(Id);
            sb.append(", number='").append(number).append('\'');
            sb.append(", street='").append(street).append('\'');
            sb.append(", zipCode='").append(zipCode).append('\'');
            sb.append(", city='").append(city).append('\'');
            sb.append(", petStore=").append(petStore);
            sb.append('}');
            return sb.toString();
        }
    }
