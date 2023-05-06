package Hibernate;

import Hibernate.model.Passport;
import Hibernate.model.Person;
import Hibernate.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        Map<Integer, String> countries = new HashMap<>(
                Map.ofEntries(
                        Map.entry(0, "Murica"),
                        Map.entry(1, "DaWay"),
                        Map.entry(2, "Kurwa"),
                        Map.entry(3, "Raisa")
                )
        );

        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(Passport.class)
        ;

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Person person = new Person("John Doe", 22);
            Passport passport = new Passport(
                    person, countries.get(ThreadLocalRandom.current().nextInt(countries.size()))
            );

            session.save(person);

            session.getTransaction().commit();
        }
    }
}
