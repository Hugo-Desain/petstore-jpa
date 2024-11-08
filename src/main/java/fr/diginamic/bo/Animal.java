package fr.diginamic.bo;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Animal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long Id;

    @Column(name = "DATE")
    private Date birth;

    @Column(name = "COULEUR")
    private String couleur;

    @ManyToOne
    @JoinColumn(name = "ID_PetStore")
    private PetStore petStore;

    public Animal(){

    }



    public Animal(Date birth, String couleur, PetStore petStore) {
        this.birth = birth;
        this.couleur = couleur;
        this.petStore = petStore;
    }

    public Animal(Date birth, String couleur) {
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
     * @return birth
     */
    public Date getBirth() {
        return birth;
    }

    /**
     * Setter
     * @param birth birth
     */
    public void setBirth(Date birth) {
        this.birth = birth;
    }

    /**
     * Getter
     * @return couleur
     */
    public String getCouleur() {
        return couleur;
    }

    /**
     * Setter
     * @param couleur couleur
     */
    public void setCouleur(String couleur) {
        this.couleur = couleur;
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

}
