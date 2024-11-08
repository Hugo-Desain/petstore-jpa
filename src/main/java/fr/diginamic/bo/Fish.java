package fr.diginamic.bo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import java.util.Date;

/**
 * Représente un poisson, qui est un type d'animal.
 * Cette classe hérite de la classe Animal et contient des informations spécifiques
 * sur l'environnement de vie du poisson.
 */
@Entity
public class Fish extends Animal{

    /** Environnement de vie du poisson */
    @Column(name = "LIVING_ENV")
    @Enumerated(EnumType.STRING)
    private FishLivEnv livingEnv;

    /**
     * Constructeur par défaut
     */
    public Fish() {
    }

    /**
     * Constructeur avec environnement de vie
     * @param livingEnv Environnement de vie du poisson
     */
    public Fish(FishLivEnv livingEnv) {
        this.livingEnv = livingEnv;
    }

    /**
     * Constructeur avec tous les paramètres
     * @param birth Date de naissance du poisson
     * @param couleur Couleur du poisson
     * @param petStore Magasin d'animaux associé
     * @param livingEnv Environnement de vie du poisson
     */
    public Fish(Date birth, String couleur, PetStore petStore, FishLivEnv livingEnv) {
        super(birth, couleur,petStore);
        this.livingEnv = livingEnv;
    }

    /**
     * Retourne une représentation en chaîne de caractères de l'objet Fish
     * @return Représentation en chaîne de caractères
     */
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Fish = ");
        sb.append("Naissance : ").append(getBirth());
        sb.append(", Couleur : ").append(getCouleur());
        sb.append(", Environnement : ").append(livingEnv);
        sb.append('\n');
        return sb.toString();
    }

}
