package Hibernate;

import Hibernate.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Person person = session.get(Person.class, "Bob the builder");
            System.out.println(person);

            person.setAge(666);
            System.out.println(session.get(Person.class, "Bob the builder"));

            session.getTransaction().commit();
        }
    }
}
