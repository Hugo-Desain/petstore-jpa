package fr.diginamic.bo;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Représente un produit.
 * Un produit peut être associé à plusieurs magasins d'animaux.
 * Cette classe est mappée à une table de base de données en utilisant les annotations JPA.
 */
@Entity
public class Product implements Serializable {

    /** Identifiant unique du produit */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long Id;

    /** Code unique du produit */
    @Column(name = "CODE")
    private String code;

    /** Libellé du produit */
    @Column(name = "LABEL")
    private String label;

    /** Type de produit */
    @Column(name = "TYPE")
    @Enumerated(EnumType.STRING)
    private ProdType type;

    /** Prix du produit */
    @Column(name = "PRICE")
    private double price;

    /** Ensemble des animaleries qui proposent ce produit */
    @ManyToMany(mappedBy="products")
    private Set<PetStore> petStores;


    {
        petStores = new HashSet<>();
    }

    /**
     * Constructeur avec paramètres
     * @param code Code unique du produit
     * @param label Libellé du produit
     * @param type Type de produit
     * @param price Prix du produit
     */
    public Product(String code, String label, ProdType type, double price) {
        this.code = code;
        this.label = label;
        this.type = type;
        this.price = price;
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
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * Setter
     * @param code code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Getter
     * @return label
     */
    public String getLabel() {
        return label;
    }

    /**
     * Setter
     * @param label label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Getter
     * @return type
     */
    public ProdType getType() {
        return type;
    }

    /**
     * Setter
     *
     * @param type type
     */
    public void setType(ProdType type) {
        this.type = type;
    }

    /**
     * Getter
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Setter
     * @param price price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Getter
     * @return petStores
     */
    public Set<PetStore> getPetStores() {
        return petStores;
    }

    /**
     * Setter pour les animaleries qui proposent ce produit
     * @param petStores Ensemble des magasins d'animaux
     */
    public void setPetStores(Set<PetStore> petStores) {
        this.petStores = petStores;
    }

    /**
     * Représentation en chaîne de caractères de l'objet Product
     * @return représentation en chaîne de caractères
     */
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Product{");
        sb.append("Id=").append(Id);
        sb.append(", code='").append(code).append('\'');
        sb.append(", label='").append(label).append('\'');
        sb.append(", type=").append(type);
        sb.append(", price=").append(price);
        sb.append(", petStores=").append(petStores);
        sb.append('}');
        return sb.toString();
    }
}
