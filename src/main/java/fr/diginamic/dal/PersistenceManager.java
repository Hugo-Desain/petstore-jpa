package fr.diginamic.dal;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Gestionnaire de persistance pour l'application.
 */
public final class PersistenceManager {

    /** Instance unique de EntityManagerFactory */
    private static EntityManagerFactory emf;

    /**
     * Constructeur privé pour empêcher l'instanciation de la classe.
     */
    private PersistenceManager() {
    }

    /**
     * Retourne l'instance unique de EntityManagerFactory.
     * @return l'instance de EntityManagerFactory
     */
    public static EntityManagerFactory getEntityManagerFactory() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("petstore");
        }
        return emf;
    }

    /**
     * Ferme l'instance de EntityManagerFactory si elle est ouverte.
     */
    public static void closeEntityManagerFactory() {
        if (emf != null) {
            emf.close();
        }
    }
}
