package fr.diginamic.bo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import java.util.Date;

/**
 * Représente un chat, qui est un type d'animal.
 * Cette classe hérite de la classe Animal.
 */
@Entity
public class Cat extends Animal{

    /** Identifiant de la puce du chat */
    @Column(name = "CHIP_ID")
    private String chipId;

    /**
     * Constructeur par défaut
     */
    public Cat() {
    }

    /**
     * Constructeur avec identifiant de puce
     * @param chipId Identifiant de la puce du chat
     */
    public Cat(String chipId) {
        this.chipId = chipId;
    }

    /**
     * Constructeur avec tous les paramètres
     * @param birth Date de naissance du chat
     * @param couleur Couleur du chat
     * @param petStore Magasin d'animaux associé
     * @param chipId Identifiant de la puce du chat
     */
    public Cat(Date birth, String couleur, PetStore petStore, String chipId) {
        super(birth, couleur, petStore);
        this.chipId = chipId;
    }

    /**
     * Retourne une représentation en chaîne de caractères de l'objet Cat
     * @return Représentation en chaîne de caractères
     */
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Cat = ");
        sb.append("Type : ").append(chipId);
        sb.append(", Couleur : ").append(getCouleur());
        sb.append('\n');
        return sb.toString();
    }
}
