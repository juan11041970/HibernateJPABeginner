package net.codejava.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BooksManager {

    static EntityManagerFactory factory;
    static EntityManager entityManager;

    public static void main(String[]  args) {
        begin();

        create();

        end();
    }

    private static void end() {
        entityManager.getTransaction().commit();
        entityManager.close();
        factory.close();
    }

    private static void begin() {
        factory = Persistence.createEntityManagerFactory("BookUnit");
        entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
    }

    private static void create() {
        Book book = new Book();
        book.setTitle("Java");
        book.setAuthor("juan");
        book.setPrice(39);

        entityManager.persist(book);
    }
}
