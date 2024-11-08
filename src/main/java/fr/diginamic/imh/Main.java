package fr.diginamic.imh;

import fr.diginamic.bo.*;
import fr.diginamic.dal.PersistenceManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

/**
 * Classe principale permettant de gérer et de manipuler des entités dans la base de données.
 */
public class Main {
    public static void main(String[] args) {

        // Récupération de l'EntityManagerFactory et création de l'EntityManager
        EntityManagerFactory emf = PersistenceManager.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // Création des adresses
        Address address1 = new Address("5", "la paix", "30000", "Ales");
        Address address2 = new Address("2", "la colline", "34000", "Montpellier");
        Address address3 = new Address("55", "la montagne", "75000", "Paris");

        // Persistance des adresses
        em.persist(address1);
        em.persist(address2);
        em.persist(address3);

        // Création des magasins d'animaux
        PetStore petStore1 = new PetStore("OuafStore", "Michel", address1 );
        PetStore petStore2 = new PetStore("MiaouStore", "Bobby", address2);
        PetStore petStore3 = new PetStore("PiouStore", "Charlie", address3 );

        // Création des animaux
        Cat cat1 = new Cat(new Date(), "blue", petStore1, "Siamese");
        Cat cat2 = new Cat(new Date(), "grey", petStore1, "Tiger");
        Cat cat3 = new Cat(new Date(), "black", petStore2, "Potte");

        Fish fish1 = new Fish(new Date(), "red", petStore1, FishLivEnv.FRESH_WATER);
        Fish fish2 = new Fish(new Date(), "green", petStore2, FishLivEnv.SEA_WATER);
        Fish fish3 = new Fish(new Date(), "yellow", petStore2, FishLivEnv.FRESH_WATER);

        // Association des animaux aux magasins
        petStore1.addAnimal(cat1);
        petStore1.addAnimal(cat2);
        petStore1.addAnimal(fish1);
        petStore2.addAnimal(cat3);
        petStore2.addAnimal(fish2);
        petStore2.addAnimal(fish3);

        // Création des produits
        Product food = new Product("123", "Cat Food",ProdType.FOOD, 10.99);
        Product toy = new Product("456","Fish Toy", ProdType.ACCESSORY, 4.99);
        Product clean = new Product("567","Litiere", ProdType.CLEANING, 8.50);

        // Association des produits aux magasins
        petStore1.getProducts().add(clean);
        petStore2.getProducts().add(food);
        petStore3.getProducts().add(toy);

        // Persistance des magasins, animaux et produits
        em.persist(petStore1);
        em.persist(petStore2);
        em.persist(petStore3);
        em.persist(cat1);
        em.persist(fish1);
        em.persist(food);
        em.persist(toy);

        // Exécution d'une requête JPQL pour obtenir les animaux d'un magasin spécifique
        long petStoreId = petStore2.getId();
        String jpql = "SELECT a FROM Animal a WHERE a.petStore.id = :petStoreId";
        TypedQuery<Animal> query = em.createQuery(jpql, Animal.class);
        query.setParameter("petStoreId", petStoreId);

        // Affichage des animaux associés au magasin
        List<Animal> animals = query.getResultList();
        for (Animal animal : animals) {
            System.out.println(animal);
        }

        // Validation de la transaction et fermeture de l'EntityManager et de l'EntityManagerFactory
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}