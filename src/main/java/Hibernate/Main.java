package Hibernate;

import Hibernate.model.Person;
import Hibernate.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Product.class)
//                .addAnnotatedClass(Passport.class)
        ;

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Person person = new Person("Juan", 92);
            person.addProduct(new Product("Horse"));
            person.addProduct(new Product("Sea"));

            session.save(person);

            session.getTransaction().commit();
        }
    }
}
