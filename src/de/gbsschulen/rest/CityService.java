package de.gbsschulen.rest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class CityService {

    private EntityManagerFactory emf;
    private EntityManager em;

    public CityService() {
        emf = Persistence.createEntityManagerFactory("citys");
        em = emf.createEntityManager();
    }

    public void close() {
        if (em != null) {
            em.close();
        }
        if (emf != null) {
            emf.close();
        }
    }


    public City getCity(int id) {
        return em.find(City.class, id);
    }

    public List<City> getAllCity() {
        TypedQuery<City> typedQuery = em.createQuery("Select a from City a", City.class);
        return typedQuery.getResultList();
    }

    public static void main(String[] args) {
        CityService cityService = new CityService();
        City city = cityService.getCity(1);
        System.out.println(city);
//        List<Book> allBooks = bookService.getAllBooks();
//        for (Book b : allBooks) {
//            System.out.println(b);
//        }
    }
}
