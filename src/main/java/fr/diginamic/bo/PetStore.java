package fr.diginamic.bo;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Représente une entité petStore (Animalerie).
 * Une animalerie peut avoir plusieurs animaux et produits associés, ainsi qu'une adresse et un manager.
 * Cette classe est mappée à une table de base de données en utilisant les annotations JPA.
 * @author Hugo-Desain
 */

@Entity
public class PetStore implements Serializable {

    /** Identifiant unique pour le Petstore */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long Id;

    /** Nom du PetStore */
    @Column(name = "NAME")
    private String name;

    /** Nom du manager */
    @Column(name = "MANAGER_NAME")
    private String managerName;

    /** Adresse du Petstore  */
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    /** Ensemble d'animaux présents dans le PetStore */
    @OneToMany(mappedBy = "petStore", cascade = CascadeType.ALL)
    private Set<Animal> animals;

    /** Ensemble de produits disponibles dans le PetStore */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "PETSTORE_PRODUCT",
            joinColumns = @JoinColumn(name = "ID_Petstore", referencedColumnName="ID"),
            inverseJoinColumns = @JoinColumn(name="ID_Product", referencedColumnName="ID")
    )

    private Set<Product> products;

    {
        animals = new HashSet<>();
        products = new HashSet<>();
    }

    /**
     * Constructeur par défaut
     */
    public PetStore() {

    }

    /**
     * Constructeur avec paramètres
     * @param name Nom du magasin
     * @param managerName Nom du gérant
     * @param address Adresse du magasin
     */
    public PetStore(String name, String managerName, Address address) {
        this.name = name;
        this.managerName = managerName;
        this.address = address;
    }


    /**
     * Ajoute un produit au PetStore
     * @param product Produit à ajouter
     */
    public void addProduct(Product product) {
        if (product != null) {
            this.products.add(product);
            product.getPetStores().add(this);
        }
    }

    /**
     * Retire un produit du PetStore
     * @param product Produit à retirer
     */
    public void removeProduct(Product product) {
        if (product != null) {
            this.products.remove(product);
            product.getPetStores().remove(this);
        }
    }

    /**
     * Ajoute un animal au PetSTore
     * @param animal Animal à ajouter
     */
    public void addAnimal(Animal animal) {
        if (animal != null) {
            animals.add(animal);
            animal.setPetStore(this);
        }
    }

    /**
     * Retire un animal du PPet
     * @param animal Animal à retirer
     */
    public void removeAnimal(Animal animal) {
        if (animal != null) {
            animals.remove(animal);
            animal.setPetStore(null);
        }
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
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter
     * @return managerName
     */
    public String getManagerName() {
        return managerName;
    }

    /**
     * Setter
     * @param managerName managerName
     */
    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    /**
     * Getter
     * @return address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Setter
     * @param address address
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Getter
     * @return products
     */
    public Set<Product> getProducts() {
        return products;
    }

    /**
     * Setter
     * @param products products
     */
    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    /**
     * Getter
     * @return animals
     */
    public Set<Animal> getAnimals() {
        return animals;
    }

    /**
     * Setter
     * @param animals animals
     */
    public void setAnimals(Set<Animal> animals) {
        this.animals = animals;
    }

    /**
     * Représentation en chaîne de caractères de l'objet PetStore
     * @return représentation en chaîne de caractères
     */
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PetStore{");
        sb.append("Id=").append(Id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", managerName='").append(managerName).append('\'');
        sb.append(", address=").append(address);
        sb.append(", animals=").append(animals);
        sb.append(", products=").append(products);
        sb.append('}');
        return sb.toString();
    }
}
